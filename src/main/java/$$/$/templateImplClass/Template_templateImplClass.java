package $$.$.templateImplClass;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_templateImplClass extends TemplateBase<Template_templateImplClass.Parts,Template_templateImplClass.Params> {

	protected Template_templateImplClass(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final $$.$.templateImplClass.templateImplClass.Template_constructor constructor;
		public final $$.$.templateImplClass.templateImplClass.Template_rendererClass rendererClass;
		public final TextTemplate className;
		public final TextTemplate baseClassName;
		
		
		
		public Parts(
		    $$.$.templateImplClass.templateImplClass.Template_constructor constructor,$$.$.templateImplClass.templateImplClass.Template_rendererClass rendererClass,TextTemplate className,TextTemplate baseClassName) {
			
			this.constructor = constructor;
			this.rendererClass = rendererClass;
			this.className = className;
			this.baseClassName = baseClassName;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		Renderer constructor($$.$.templateImplClass.templateImplClass.Template_constructor constructor);
		Renderer rendererClass($$.$.templateImplClass.templateImplClass.Template_rendererClass rendererClass);
		String className(TextTemplate className);
		String baseClassName(TextTemplate baseClassName);
		
	}
	
}
