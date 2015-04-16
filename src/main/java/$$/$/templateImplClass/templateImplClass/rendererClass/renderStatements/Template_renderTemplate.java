package $$.$.templateImplClass.templateImplClass.rendererClass.renderStatements;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_renderTemplate extends TemplateBase<Template_renderTemplate.Parts,Template_renderTemplate.Params> {

	protected Template_renderTemplate(Parts parts) {
		
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
