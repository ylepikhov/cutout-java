package cutout.java.util;

import cutout.java.AppenderRenderer;
import cutout.java.Renderer;
import cutout.java.util.Template_templateClass.Template_partClass;
import cutout.java.util.Template_templateClass.Template_partClass.Template_constructor.Template_params;
import cutout.java.util.Template_templateClass.Template_partClass.Template_constructor.Template_partsConstructorArgs;
import cutout.java.util.Template_templateClass.Template_partClass.Template_paramsClass;
import cutout.java.util.Template_templateClass.Template_partClass.Template_paramsClass.Template_builderClass;
import cutout.java.util.Template_templateClass.Template_partClass.Template_paramsClass.Template_builderClass.Template_buildMethod;
import cutout.java.util.Template_templateClass.Template_partClass.Template_paramsClass.Template_builderClass.Template_buildMethod.Template_paramsConstructorArgs;
import cutout.java.util.Template_templateClass.Template_partClass.Template_paramsClass.Template_builderClass.Template_builderMethods;
import cutout.java.util.Template_templateClass.Template_partClass.Template_partsClass;
import cutout.java.util.Template_templateClass.Template_partClass.Template_partsClass.Template_constructor.Template_fieldAssigments;
import cutout.java.util.Template_templateClass.Template_partClass.Template_partsClass.Template_fields;
import cutout.java.util.Template_templateClass.Template_partClass.Template_partsClassesMembers;
import cutout.java.util.Template_templateImplClass.Template_implClass;
import cutout.java.util.Template_templateImplClass.Template_implClass.Template_constructor;
import cutout.java.util.Template_templateImplClass.Template_implClass.Template_constructor.Template_constructorArgs;
import cutout.java.util.Template_templateImplClass.Template_implClass.Template_rendererClass;
import cutout.java.util.Template_templateImplClass.Template_implClass.Template_rendererClass.Template_renderStatements;
import cutout.java.util.Util.Template.Part;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import cutout.java.util.CutoutLexer;
import cutout.java.util.CutoutParser;
import cutout.java.util.CutoutParser.ContentContext;
import cutout.java.util.CutoutParser.CutContext;
import cutout.java.util.CutoutParser.Cut_block_closeContext;
import cutout.java.util.CutoutParser.Cut_block_openContext;
import cutout.java.util.CutoutParserBaseListener;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

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
						BasicFileAttributes attrs) throws IOException {
					
					if (path != null && attrs.isRegularFile() && matcher.matches(path.getFileName())) {
						processCutout(templatesOutputDir, templatesImplOutputDir, basePath, path);
					}
					
					return FileVisitResult.CONTINUE;
				}
			});
		}
	}

	private static void processCutout(Path templatesOutputDir,
			Path templatesImplOutputDir, Path basePath, Path path)
			throws IOException {
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
		String packageName = packagePath.toString().replace(FileSystems.getDefault().getSeparator(), ".");				
		
		Path templatePath = templatesOutputDir.resolve(packagePath).resolve("Template_" + className + ".java");
		Files.createDirectories(templatePath.getParent());
		
		BufferedWriter templateOut = Files.newBufferedWriter(templatePath, Charset.defaultCharset());
		
		try {
			
			generateTemplate(packageName, template, templateOut);
		}
		finally {
			
			templateOut.close();
		}
		
		Path templateImplPath = templatesImplOutputDir.resolve(packagePath).resolve("TemplateImpl_" + className + ".java");
		Files.createDirectories(templateImplPath.getParent());
		
		BufferedWriter templateImplOut = Files.newBufferedWriter(templateImplPath, Charset.defaultCharset());
		
		try {
			
			generateTemplateImpl(packageName, template, templateImplOut);
		}
		finally {

            templateImplOut.close();
		}
	}

	private static Template parseCutout(String className,
			InputStream inputStream) throws IOException {
		Template template = new Template(className, null);
		
		Reader r = new InputStreamReader(inputStream);
		
		try {
		
			ANTLRInputStream input = new ANTLRInputStream(r);
			CutoutLexer lexer = new CutoutLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			CutoutParser parser = new CutoutParser(tokens);
			
			parser.addParseListener(new BuildListener(template));
			parser.template();
			
		}
		finally {
			r.close();
		}
		return template;
	}

	private static void generateTemplateImpl(String packageName,
			Template template, Appendable templateImplOut) throws IOException {
		Template_templateImplClass templateImplClass = TemplateImpl_templateImplClass.INSTANCE;
		TemplateImplView.templateImplClass(packageName, template, templateImplClass).render(templateImplOut);
	}

	private static void generateTemplate(String packageName, Template template,
			Appendable templateOut) throws IOException {
		Template_templateClass templateClass = TemplateImpl_templateClass.INSTANCE;
		TemplateView.templateClass(packageName, template, templateClass).render(templateOut);
	}

	static public class TemplateView {
		
		public static Renderer templateClass(String packageName, Template template, Template_templateClass templateClass) {
			
			return templateClass.apply(templateClass.params()
				.packageName(packageName)
				.partClass(partClass(template, templateClass.parts.partClass))
				.build());
		}

		private static Renderer partClass(Template template, Template_partClass partClass) {
			
			return partClass.apply(partClass.params()
				.className("Template_" + template.className)
				.constructor(partClassConstructor(template, partClass.parts.constructor))
				.partsClass(partsClass(template, partClass.parts.partsClass))
				.paramsClass(paramsClass(template, partClass.parts.paramsClass))
				.partsClassesMembers(partsClassesMembers(template, partClass.parts.partsClassesMembers, partClass))
				.build());
		}

		private static Renderer partClassConstructor(Template template, Template_partClass.Template_constructor constructor) {
			
			return constructor.apply(constructor.params()
				.className("Template_" + template.className)
				.params(partClassConstructorParams(template, constructor.parts.params))
				.partsConstructorArgs(partsConstructorArgs(template, constructor.parts.partsConstructorArgs))
				.build());
		}

		private static Renderer partClassConstructorParams(final Template template, final Template_params params) {
			
			return template.parts.size() == 0 ? Renderer.EMPTY : new AppenderRenderer() {

				@Override
				public void render(Appender appender) throws IOException {
					
					boolean skipDelimiter = true;
					for (Template.Part part : template.parts) {
						
						if (part.type.equals("cut")) {
							
							appender.append(params.apply(params.params()
								.type(part.template.parts.size() > 0 ? "Template_" + part.template.className : "TextTemplate")
								.name(part.name)
								.delimiter(skipDelimiter ? "" : params.parts.delimiter.value)
								.build()));
							
							skipDelimiter = false;
						} else if (part.type.equals("mark")) {
							
							appender.append(params.apply(params.params()
								.type("TextTemplate")
								.name(part.name)
								.delimiter(skipDelimiter ? "" : params.parts.delimiter.value)
								.build()));
							
							skipDelimiter = false;
						}
					}
				}
			};
		}
		
		private static Renderer partsConstructorArgs(final Template template, final Template_partsConstructorArgs partsConstructorArgs) {
			
			return template.parts.size() == 0 ? Renderer.EMPTY : new AppenderRenderer() {

				@Override
				public void render(Appender appender) throws IOException {
					
					boolean skipDelimiter = true;
					for (Template.Part part : template.parts) {
						
						if (!part.type.equals("content")) {
							
							appender.append(partsConstructorArgs.apply(partsConstructorArgs.params()
								.value(part.name)
								.delimiter(skipDelimiter ? "" : partsConstructorArgs.parts.delimiter.value)
								.build()));
							
							skipDelimiter = false;
						}
					}
				}
			};
		}

		private static Renderer partsClass(final Template template, final Template_partsClass partsClass) {
			
			return partsClass.apply(partsClass.params()
				.fields(partsClassFields(template, partsClass.parts.fields))
				.constructor(partsClassConstructor(template, partsClass.parts.constructor))
				.build());
		}

		private static Renderer partsClassFields(final Template template, final Template_fields fields) {

			return template.parts.size() == 0 ? Renderer.EMPTY : new AppenderRenderer() {
				
				@Override
				public void render(Appender appender) throws IOException {

					for (Template.Part part : template.parts) {
						
						if (part.type.equals("cut")) {
							
							appender.append(fields.apply(fields.params()
								.type(part.template.parts.size() > 0 ? "Template_" + part.template.className : "TextTemplate")
								.name(part.name)
								.build()));
							
						} else if (part.type.equals("mark")) {
							
							appender.append(fields.apply(fields.params()
								.type("TextTemplate")
								.name(part.name)
								.build()));
							
						}
					}
				}
			};
		}

		private static Renderer partsClassConstructor(final Template template, final Template_partsClass.Template_constructor constructor) {
			
			return constructor.apply(constructor.params()
				.params(partsClassConstructorParams(template, constructor.parts.params))
				.fieldAssigments(partsClassConstructorFieldAssigments(template, constructor.parts.fieldAssigments))
				.build());
		}
		
		private static Renderer partsClassConstructorParams(
				final Template template,
				final Template_partsClass.Template_constructor.Template_params params) {

			return template.parts.size() == 0 ? Renderer.EMPTY : new AppenderRenderer() {

				@Override
				public void render(Appender appender) throws IOException {
					
					boolean skipDelimiter = true;
					for (Template.Part part : template.parts) {
						
						if (part.type.equals("cut")) {
							
							appender.append(params.apply(params.params()
								.type(part.template.parts.size() > 0 ? "Template_" + part.template.className : "TextTemplate")
								.name(part.name)
								.delimiter(skipDelimiter ? "" : params.parts.delimiter.value)
								.build()));
							
							skipDelimiter = false;
						} else if (part.type.equals("mark")) {
							
							appender.append(params.apply(params.params()
								.type("TextTemplate")
								.name(part.name)
								.delimiter(skipDelimiter ? "" : params.parts.delimiter.value)
								.build()));
							
							skipDelimiter = false;
						}
					}
				}
			};
		}

		private static Renderer partsClassConstructorFieldAssigments(
				final Template template, final Template_fieldAssigments fieldAssigments) {

			return template.parts.size() == 0 ? Renderer.EMPTY : new AppenderRenderer() {

				@Override
				public void render(Appender appender) throws IOException {
					
					for (Template.Part part : template.parts) {
						
						if (!part.type.equals("content")) {
							
							appender.append(fieldAssigments.apply(fieldAssigments.params()
								.name(part.name)
								.build()));		
						}
					}
				}
			};
		}

		private static Renderer paramsClass(Template template,
				Template_paramsClass paramsClass) {

			return paramsClass.apply(paramsClass.params()
				.fields(paramsClassFields(template, paramsClass.parts.fields))
				.constructor(paramsClassConstructor(template, paramsClass.parts.constructor))
				.builderClass(builderClass(template, paramsClass.parts.builderClass))
				.build());
		}
		
		private static Renderer paramsClassFields(
				final Template template,
				final Template_paramsClass.Template_fields fields) {

			return template.parts.size() == 0 ? Renderer.EMPTY : new AppenderRenderer() {
				
				@Override
				public void render(Appender appender) throws IOException {

					for (Template.Part part : template.parts) {
						
						if (part.type.equals("cut")) {
							
							appender.append(fields.apply(fields.params()
								.type("Renderer")
								.name(part.name)
								.build()));
							
						} else if (part.type.equals("mark")) {
							
							appender.append(fields.apply(fields.params()
								.type("String")
								.name(part.name)
								.build()));
							
						}
					}
				}
			};
		}

		private static Renderer paramsClassConstructor(Template template,
				Template_paramsClass.Template_constructor constructor) {

			return constructor.apply(constructor.params()
				.params(paramsClassConstructorParams(template, constructor.parts.params))
				.fieldAssigments(paramsClassConstructorFieldAssigments(template, constructor.parts.fieldAssigments))
				.build());
		}

		private static Renderer paramsClassConstructorParams(
				final Template template,
				final Template_paramsClass.Template_constructor.Template_params params) {

			return template.parts.size() == 0 ? Renderer.EMPTY : new AppenderRenderer() {
				
				@Override
				public void render(Appender appender) throws IOException {

					boolean skipDelimiter = true;
					for (Template.Part part : template.parts) {
						
						if (part.type.equals("cut")) {
							
							appender.append(params.apply(params.params()
								.type("Renderer")
								.name(part.name)
								.delimiter(skipDelimiter ? "" : params.parts.delimiter.value)
								.build()));
							
							skipDelimiter = false;
						} else if (part.type.equals("mark")) {
							
							appender.append(params.apply(params.params()
								.type("String")
								.name(part.name)
								.delimiter(skipDelimiter ? "" : params.parts.delimiter.value)
								.build()));

							skipDelimiter = false;
						}
					}
				}
			};
		}

		private static Renderer paramsClassConstructorFieldAssigments(
				final Template template,
				final Template_paramsClass.Template_constructor.Template_fieldAssigments fieldAssigments) {
			
			return template.parts.size() == 0 ? Renderer.EMPTY : new AppenderRenderer() {

				@Override
				public void render(Appender appender) throws IOException {
					
					for (Template.Part part : template.parts) {
						
						if (!part.type.equals("content")) {
							
							appender.append(fieldAssigments.apply(fieldAssigments.params()
								.name(part.name)
								.build()));		
						}
					}
				}
			};
		}

		private static Renderer builderClass(Template template,
				Template_builderClass builderClass) {
			
			return builderClass.apply(builderClass.params()
				.fields(builderClassFields(template, builderClass.parts.fields))
				.builderMethods(builderMethods(template, builderClass.parts.builderMethods))
				.buildMethod(buildMethod(template, builderClass.parts.buildMethod))
				.build());
		}

		private static Renderer builderClassFields(
				final Template template,
				final Template_builderClass.Template_fields fields) {


			return template.parts.size() == 0 ? Renderer.EMPTY : new AppenderRenderer() {
				
				@Override
				public void render(Appender appender) throws IOException {

					for (Template.Part part : template.parts) {
						
						if (part.type.equals("cut")) {
							
							appender.append(fields.apply(fields.params()
								.type("Renderer")
								.name(part.name)
								.build()));
							
						} else if (part.type.equals("mark")) {
							
							appender.append(fields.apply(fields.params()
								.type("String")
								.name(part.name)
								.build()));
							
						}
					}
				}
			};
		}

		private static Renderer builderMethods(final Template template,
				final Template_builderMethods builderMethods) {

			return template.parts.size() == 0 ? Renderer.EMPTY : new AppenderRenderer() {
				
				@Override
				public void render(Appender appender) throws IOException {

					for (Template.Part part : template.parts) {
						
						if (part.type.equals("cut")) {
							
							appender.append(builderMethods.apply(builderMethods.params()
								.type("Renderer")
								.name(part.name)
								.build()));
							
						} else if (part.type.equals("mark")) {
							
							appender.append(builderMethods.apply(builderMethods.params()
								.type("String")
								.name(part.name)
								.build()));
							
						}
					}
				}
			};
		}

		private static Renderer buildMethod(Template template,
				Template_buildMethod buildMethod) {

			return buildMethod.apply(buildMethod.params()
				.paramsConstructorArgs(buildMethodParamsConstructorArgs(template, buildMethod.parts.paramsConstructorArgs))	
				.build());
		}

		private static Renderer buildMethodParamsConstructorArgs(final Template template,
				final Template_paramsConstructorArgs paramsConstructorArgs) {

			return template.parts.size() == 0 ? Renderer.EMPTY : new AppenderRenderer() {

				@Override
				public void render(Appender appender) throws IOException {
					
					boolean skipDelimiter = true;
					for (Template.Part part : template.parts) {
						
						if (!part.type.equals("content")) {
							
							appender.append(paramsConstructorArgs.apply(paramsConstructorArgs.params()
								.value(part.name)
								.delimiter(skipDelimiter ? "" : paramsConstructorArgs.parts.delimiter.value)
								.build()));
							
							skipDelimiter = false;
						}
					}
				}
			};
		}

		private static Renderer partsClassesMembers(final Template template,
				final Template_partsClassesMembers partsClassesMembers, final Template_partClass partClass) {

			return template.parts.size() == 0 ? Renderer.EMPTY : new AppenderRenderer() {
				
				@Override
				public void render(Appender appender) throws IOException {
					
					for (Template.Part part : template.parts) {
						
						if (part.type.equals("cut") && part.template.parts.size() > 0 
							&& (!part.template.parts.get(0).type.equals("content")
								|| part.template.parts.size() > 1)) {
							
							appender.append(partsClassesMembers.apply(partsClassesMembers.params()
								.partClass(partClass(part.template, partClass))	
								.build()));
						}
					}
				}
			};
		}
	}

	static public class TemplateImplView {
		
		static public Renderer templateImplClass(String packageName, Template template, Template_templateImplClass templateImplClass) {
			
			return templateImplClass.apply(templateImplClass.params()
				.packageName(packageName)
				.implClass(implClass(template, templateImplClass.parts.implClass))
				.build());
		}

		private static Renderer implClass(Template template, Template_implClass implClass) {
			
			return implClass.apply(implClass.params()
				.className("TemplateImpl_" + template.className)
				.baseClassName("Template_" + template.className)
				.constructor(implClassConstructor(template, implClass.parts.constructor))
				.rendererClass(rendererClass(template, implClass.parts.rendererClass))
				.partsClassesMembers(partsClassesMembers(template, implClass, implClass.parts.partsClassesMembers))
				.build());
		}

		private static Renderer implClassConstructor(Template template,
				Template_constructor constructor) {

			return constructor.apply(constructor.params()
				.className("TemplateImpl_" + template.className)	
				.constructorArgs(implClassConstructorArgs(template, constructor.parts.constructorArgs))
				.build());
		}

		private static Renderer implClassConstructorArgs(
				final Template template,
				final Template_constructorArgs constructorArgs) {
			
			return template.parts.size() == 0 ? Renderer.EMPTY : new AppenderRenderer() {

				@Override
				public void render(Appender appender) throws IOException {

					boolean skipDelimiter = true;
					for (Template.Part part : template.parts) {
						
						if (part.type.equals("content")) continue;
						
						Template_constructorArgs.Params.Builder params = constructorArgs.params();
						if (skipDelimiter) params.delimiter(""); else params.delimiter(constructorArgs.parts.delimiter.value);
						
						switch (part.type) {
						case "mark":
							if (part.content.equals("")) {
								params.arg(constructorArgs.parts.arg.parts.empty.apply());
							}
							else {
								params.arg(constructorArgs.parts.arg.parts.value.apply(constructorArgs.parts.arg.parts.value.params()
									.stringValue("\"" + JavaStringLiteralUtil.escape(part.content) + "\"")
									.build()));
							}
							skipDelimiter = false;
							break;
						case "cut":
							if (part.template.className.equals("TextTemplate")) {
								params.arg(constructorArgs.parts.arg.parts.value.apply(constructorArgs.parts.arg.parts.value.params()
									.stringValue("\"" + JavaStringLiteralUtil.escape(part.template.parts.get(0).content) + "\"")
									.build()));
							}
							else {
								params.arg(constructorArgs.parts.arg.parts.part.apply(constructorArgs.parts.arg.parts.part.params()
									.className("TemplateImpl_" + part.template.className)
									.build()));
							}
							skipDelimiter = false;
							break;
						default:
							break;
						}
						
						appender.append(constructorArgs.apply(params.build()));
					}
				}
			};
		}

		private static Renderer rendererClass(Template template,
				Template_rendererClass rendererClass) {

			return rendererClass.apply(rendererClass.params()
				.renderStatements(renderStatements(template, rendererClass.parts.renderStatements))	
				.build());
		}

		private static Renderer renderStatements(
				final Template template,
				final Template_renderStatements renderStatements) {

			return template.parts.size() == 0 ? Renderer.EMPTY : new AppenderRenderer() {

				@Override
				public void render(Appender appender) throws IOException {
					
					for (Template.Part part : template.parts) {
					
						switch (part.type) {
						case "content":
							appender.append(renderStatements.parts.renderContent.apply(renderStatements.parts.renderContent.params()
								.stringValue("\"" + JavaStringLiteralUtil.escape(part.content) + "\"")	
								.build()));
							break;
						case "mark":
							appender.append(renderStatements.parts.renderMark.apply(renderStatements.parts.renderMark.params()
								.name(part.name)	
								.build()));
							break;
						case "cut":
							appender.append(renderStatements.parts.renderCut.apply(renderStatements.parts.renderCut.params()
								.name(part.name)	
								.build()));
							break;
						default:
							break;
						}
					}
				} 
			};
		}

		private static Renderer partsClassesMembers(
				final Template template,
				final Template_implClass implClass,
				final Template_implClass.Template_partsClassesMembers partsClassesMembers) {

			return template.parts.size() == 0 ? Renderer.EMPTY : new AppenderRenderer() {

				@Override
				public void render(Appender appender) throws IOException {
					
					for (Template.Part part : template.parts) {
						if (part.type.equals("cut") && !part.template.className.equals("TextTemplate")) {
							appender.append(partsClassesMembers.apply(partsClassesMembers.params()
								.partClass(implClass(part.template,  implClass))	
								.build()));
						}
					}
				}
			};
		}
	}
	
	static public class Template {
		
		public final String className;
		public final Template parent;
		public final List<Part> parts = new ArrayList<Part>();
	
		public Template(String className, Template parent) {
			
			this.className = className;
			this.parent = parent;
		}
		
		static public class Part {
			
			public String type;
			public String name;
			public String content;
			public Template template;
			
			public Part(String type, String name, String content, Template template) {
				this.type = type;
				this.name = name;
				this.content = content;
				this.template = template;
			}
		}
	}
	
	static private class BuildListener extends CutoutParserBaseListener {

		private Template template;
		
		public BuildListener(Template template) {
			
			this.template = template;
		}
		
		@Override
		public void exitCut_block_open(Cut_block_openContext ctx) {

			template = new Template(ctx.ID().getText(), template);
			
			super.exitCut_block_open(ctx);
		}

		@Override
		public void exitCut_block_close(Cut_block_closeContext ctx) {
			
			template.parent.parts.add(new Part("cut", ctx.ID().getText(), null, 
				template.parts.size() == 1 && template.parts.get(0).type.equals("content")
				? new Template("TextTemplate", template.parent) {
					
				{ parts.add(template.parts.get(0)); }
				}
				: template));
			
			template = template.parent;
			
			super.exitCut_block_close(ctx);
		}

		@Override
		public void exitContent(ContentContext ctx) {

			template.parts.add(new Part("content", null, ctx.getText(), null));
			
			super.exitContent(ctx);
		}

		@Override
		public void exitCut(CutContext ctx) {
			
			for (Template.Part part : template.parts) {
				if (part.type.equals("mark") && part.name.equals(ctx.ID().getText())) {

					super.exitCut(ctx);
					return;
				}
			}
			
			template.parts.add(new Part("mark", ctx.ID().getText(), ctx.content() == null ? "" : ctx.content().getText(), null));
			
			super.exitCut(ctx);
		}
	}
}