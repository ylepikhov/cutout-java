package $$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.arg;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_part extends TemplateBase<Template_part.Parts,Template_part.Params> {

	protected Template_part(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final TextTemplate className;
		
		
		
		public Parts(
		    TextTemplate className) {
			
			this.className = className;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		String className(TextTemplate className);
		
	}
	
}
