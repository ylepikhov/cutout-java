package $$.$.templateImplClass.templateImplClass.rendererClass.renderStatements;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_renderContent extends TemplateBase<Template_renderContent.Parts,Template_renderContent.Params> {

	protected Template_renderContent(Parts parts) {
		
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
