package $$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.arg;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_value extends TemplateBase<Template_value.Parts,Template_value.Params> {

	protected Template_value(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final TextTemplate stringValue;
		
		
		
		public Parts(
		    TextTemplate stringValue) {
			
			this.stringValue = stringValue;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		String stringValue(TextTemplate stringValue);
		
	}
	
}
