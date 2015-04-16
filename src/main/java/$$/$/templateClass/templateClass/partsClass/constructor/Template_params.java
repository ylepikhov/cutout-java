package $$.$.templateClass.templateClass.partsClass.constructor;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_params extends TemplateBase<Template_params.Parts,Template_params.Params> {

	protected Template_params(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final TextTemplate type;
		public final TextTemplate name;
		public final TextTemplate delimiter;
		
		
		
		public Parts(
		    TextTemplate type,TextTemplate name,TextTemplate delimiter) {
			
			this.type = type;
			this.name = name;
			this.delimiter = delimiter;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		String type(TextTemplate type);
		String name(TextTemplate name);
		String delimiter(TextTemplate delimiter);
		
	}
	
}
