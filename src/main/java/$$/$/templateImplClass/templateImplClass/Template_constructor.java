package $$.$.templateImplClass.templateImplClass;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_constructor extends TemplateBase<Template_constructor.Parts,Template_constructor.Params> {

	protected Template_constructor(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final $$.$.templateImplClass.templateImplClass.constructor.Template_partsConstructorArgs partsConstructorArgs;
		public final TextTemplate className;
		
		
		
		public Parts(
		    $$.$.templateImplClass.templateImplClass.constructor.Template_partsConstructorArgs partsConstructorArgs,TextTemplate className) {
			
			this.partsConstructorArgs = partsConstructorArgs;
			this.className = className;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		Renderer partsConstructorArgs($$.$.templateImplClass.templateImplClass.constructor.Template_partsConstructorArgs partsConstructorArgs);
		String className(TextTemplate className);
		
	}
	
}
