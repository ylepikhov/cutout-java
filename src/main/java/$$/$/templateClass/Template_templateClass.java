package $$.$.templateClass;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_templateClass extends TemplateBase<Template_templateClass.Parts,Template_templateClass.Params> {

	protected Template_templateClass(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final $$.$.templateClass.templateClass.Template_partsClass partsClass;
		public final $$.$.templateClass.templateClass.Template_paramsInterface paramsInterface;
		public final TextTemplate className;
		
		
		
		public Parts(
		    $$.$.templateClass.templateClass.Template_partsClass partsClass,$$.$.templateClass.templateClass.Template_paramsInterface paramsInterface,TextTemplate className) {
			
			this.partsClass = partsClass;
			this.paramsInterface = paramsInterface;
			this.className = className;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		Renderer partsClass($$.$.templateClass.templateClass.Template_partsClass partsClass);
		Renderer paramsInterface($$.$.templateClass.templateClass.Template_paramsInterface paramsInterface);
		String className(TextTemplate className);
		
	}
	
}
