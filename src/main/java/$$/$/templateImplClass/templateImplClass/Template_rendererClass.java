package $$.$.templateImplClass.templateImplClass;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_rendererClass extends TemplateBase<Template_rendererClass.Parts,Template_rendererClass.Params> {

	protected Template_rendererClass(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final $$.$.templateImplClass.templateImplClass.rendererClass.Template_renderStatements renderStatements;
		public final $$.$.templateImplClass.templateImplClass.rendererClass.Template_renderParts renderParts;
		
		
		
		public Parts(
		    $$.$.templateImplClass.templateImplClass.rendererClass.Template_renderStatements renderStatements,$$.$.templateImplClass.templateImplClass.rendererClass.Template_renderParts renderParts) {
			
			this.renderStatements = renderStatements;
			this.renderParts = renderParts;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		Renderer renderStatements($$.$.templateImplClass.templateImplClass.rendererClass.Template_renderStatements renderStatements);
		Renderer renderParts($$.$.templateImplClass.templateImplClass.rendererClass.Template_renderParts renderParts);
		
	}
	
}
