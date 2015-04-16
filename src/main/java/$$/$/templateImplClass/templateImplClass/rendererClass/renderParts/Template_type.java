package $$.$.templateImplClass.templateImplClass.rendererClass.renderParts;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_type extends TemplateBase<Template_type.Parts,Template_type.Params> {

	protected Template_type(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final TextTemplate string;
		public final TextTemplate renderer;
		
		
		
		public Parts(
		    TextTemplate string,TextTemplate renderer) {
			
			this.string = string;
			this.renderer = renderer;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		String string(TextTemplate string);
		String renderer(TextTemplate renderer);
		
	}
	
}
