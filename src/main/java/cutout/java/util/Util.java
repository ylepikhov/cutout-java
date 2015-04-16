package cutout.java.util;

import $$.TemplateImpl_templateClass;
import $$.TemplateImpl_templateImplClass;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import cutout.java.util.CutoutLexer;
import cutout.java.util.CutoutParser;
import cutout.java.util.CutoutParser.ContentContext;
import cutout.java.util.CutoutParser.CutContext;
import cutout.java.util.CutoutParser.Cut_block_closeContext;
import cutout.java.util.CutoutParser.Cut_block_openContext;
import cutout.java.util.CutoutParserBaseListener;
import cutout.java.util.Template.Part;
import cutout.java.util.Template.Cut;
import cutout.java.util.Template.Mark;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Util {

	@Parameters(separators="=")
	static public class Args {
		
		@Parameter(names="-bo", description="template .java files output directory")
		public String templatesOutputDir;
		
		@Parameter(names="-io", description="template implementation .java files output directory")
		public String templatesImplOutputDir;
		
		@Parameter(description="paths to search .cutout files")
		public List<String> searchPath = new ArrayList<>();
	}
	
	public static void main(String[] args) throws IOException {
		
		Args jcArgs = new Args();
		new JCommander(jcArgs, args);
		
		Path cwdPath = Paths.get(System.getProperty("user.dir"));
		
		final Path templatesOutputDir = jcArgs.templatesOutputDir != null
			? cwdPath.resolve(jcArgs.templatesOutputDir)
			: Paths.get(System.getProperty("user.dir"));

		final Path templatesImplOutputDir = jcArgs.templatesImplOutputDir != null ? cwdPath.resolve(jcArgs.templatesImplOutputDir) : templatesOutputDir;
		
		final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.cutout"); 
		
		for (String searchPath : jcArgs.searchPath) {
			
			final Path basePath = cwdPath.resolve(searchPath);
			
			Files.walkFileTree(basePath, new SimpleFileVisitor<Path>() {

				@Override
				public FileVisitResult visitFile(Path path,
						BasicFileAttributes attributes) throws IOException {
					
					if (path != null && attributes.isRegularFile() && matcher.matches(path.getFileName())) {
						processCutout(
                            templatesOutputDir,
                            templatesImplOutputDir,
                            basePath, path);
					}
					
					return FileVisitResult.CONTINUE;
				}
			});
		}
	}

	private static void processCutout(

        Path templatesOutputDir,
        Path templatesImplOutputDir,
        Path basePath,
        Path path) throws IOException {

        String className = path.getFileName().toString();
		if (className.indexOf('.') > 0)
			className = className.substring(0, className.indexOf('.'));
		
		InputStream inputStream = Files.newInputStream(path);
		
		Template template = null;
		try {
			
			template = parseCutout(className, inputStream);
		}
		finally {
			inputStream.close();
		}
		
		Path packagePath = basePath.relativize(path.getParent());
        boolean isRoot = true;
		String packageName = packagePath.toString().replace(FileSystems.getDefault().getSeparator(), ".");

        generateTemplateClass(packageName, template, isRoot, templatesOutputDir, templatesImplOutputDir);
	}

    private static void generateTemplateClass(

            String packageName, Template template, boolean isRoot, Path templatesOutputDir, Path templatesImplOutputDir) throws IOException {

        Path packagePath = Paths.get(packageName.replace(".", FileSystems.getDefault().getSeparator()));
        Path templatePath = templatesOutputDir.resolve(packagePath).resolve("Template_" + template.className + ".java");
        Files.createDirectories(templatePath.getParent());

        BufferedWriter templateOut = Files.newBufferedWriter(templatePath, Charset.defaultCharset());

        try {

            TemplateView.templateClass(
                packageName,
                template, isRoot,
                TemplateImpl_templateClass.INSTANCE).render(templateOut);
        }
        finally {

            templateOut.close();
        }

        Path templateImplPath = templatesImplOutputDir.resolve(packagePath).resolve("TemplateImpl_" + template.className + ".java");
        Files.createDirectories(templatePath.getParent());

        BufferedWriter templateImplOut = Files.newBufferedWriter(templateImplPath, Charset.defaultCharset());

        try {

            TemplateView.templateImplClass(
                packageName,
                template, isRoot,
                TemplateImpl_templateImplClass.INSTANCE).render(templateImplOut);
        }
        finally {

            templateImplOut.close();
        }

        for (Cut cut : template.cuts.values()) {

            generateTemplateClass(

                packageName + (isRoot ? ".$."  : ".") + template.className,
                cut.template, false,
                templatesOutputDir, templatesImplOutputDir);
        }
    }

    private static Template parseCutout(String className,
			InputStream inputStream) throws IOException {
		Template template = new Template(className, new HashMap<String, Cut>(), new HashMap<String, Mark>(), new Template.Part[0]);
		
		Reader r = new InputStreamReader(inputStream);
		
		try {
		
			ANTLRInputStream input = new ANTLRInputStream(r);
			CutoutLexer lexer = new CutoutLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			CutoutParser parser = new CutoutParser(tokens);

            BuildListener listener = new BuildListener(template);

			parser.addParseListener(listener);
			parser.template();

            return listener.result;
			
		}
		finally {
			r.close();
		}
	}

    static private class BuildListener extends CutoutParserBaseListener {

        private LinkedList<Template> parents = new LinkedList<>();
		private Template template;

        public Template result;

		public BuildListener(Template template) {
			
			this.template = template;
		}
		
		@Override
		public void exitCut_block_open(Cut_block_openContext ctx) {

            parents.addFirst(template);
			template = new Template(ctx.ID().getText(), new HashMap<String, Cut>(), new HashMap<String, Mark>(), new Part[0]);
			
			super.exitCut_block_open(ctx);
		}

		@Override
		public void exitCut_block_close(Cut_block_closeContext ctx) {

            Template partTemplate = template;
            if (partTemplate.parts.length == 1 && partTemplate.parts[0].type == Part.PART_TYPE.CONTENT)
                partTemplate = new Template("TextTemplate", partTemplate.cuts, partTemplate.marks, partTemplate.parts);

            template = parents.pollFirst();

            template = template.addCut(ctx.ID().getText(), partTemplate);

			super.exitCut_block_close(ctx);
		}

		@Override
		public void exitContent(ContentContext ctx) {

            template = template.addContent(ctx.getText());
			
			super.exitContent(ctx);
		}

		@Override
		public void exitCut(CutContext ctx) {
			
			template = template.addMark(ctx.ID().getText(), ctx.defaultValue() == null ? "" : ctx.defaultValue().getText());
			
			super.exitCut(ctx);
		}

        @Override
        public void exitTemplate(@NotNull CutoutParser.TemplateContext ctx) {

            result = template;

            super.exitTemplate(ctx);
        }
    }
}