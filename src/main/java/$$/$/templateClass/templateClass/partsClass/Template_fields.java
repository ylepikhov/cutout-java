package $$.$.templateClass.templateClass.partsClass;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_fields extends TemplateBase<Template_fields.Parts,Template_fields.Params> {

	protected Template_fields(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final TextTemplate type;
		public final TextTemplate name;
		
		
		
		public Parts(
		    TextTemplate type,TextTemplate name) {
			
			this.type = type;
			this.name = name;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		String type(TextTemplate type);
		String name(TextTemplate name);
		
	}
	
}
