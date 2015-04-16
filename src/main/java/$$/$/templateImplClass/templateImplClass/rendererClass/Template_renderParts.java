package $$.$.templateImplClass.templateImplClass.rendererClass;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_renderParts extends TemplateBase<Template_renderParts.Parts,Template_renderParts.Params> {

	protected Template_renderParts(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final $$.$.templateImplClass.templateImplClass.rendererClass.renderParts.Template_type type;
		public final TextTemplate name;
		
		
		
		public Parts(
		    $$.$.templateImplClass.templateImplClass.rendererClass.renderParts.Template_type type,TextTemplate name) {
			
			this.type = type;
			this.name = name;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		Renderer type($$.$.templateImplClass.templateImplClass.rendererClass.renderParts.Template_type type);
		String name(TextTemplate name);
		
	}
	
}
