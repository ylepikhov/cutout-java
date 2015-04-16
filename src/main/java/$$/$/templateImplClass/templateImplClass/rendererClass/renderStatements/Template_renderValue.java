package $$.$.templateImplClass.templateImplClass.rendererClass.renderStatements;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_renderValue extends TemplateBase<Template_renderValue.Parts,Template_renderValue.Params> {

	protected Template_renderValue(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final TextTemplate name;
		
		
		
		public Parts(
		    TextTemplate name) {
			
			this.name = name;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		String name(TextTemplate name);
		
	}
	
}
