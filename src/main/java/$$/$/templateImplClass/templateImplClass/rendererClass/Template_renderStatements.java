package $$.$.templateImplClass.templateImplClass.rendererClass;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_renderStatements extends TemplateBase<Template_renderStatements.Parts,Template_renderStatements.Params> {

	protected Template_renderStatements(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final $$.$.templateImplClass.templateImplClass.rendererClass.renderStatements.Template_renderTemplate renderTemplate;
		public final $$.$.templateImplClass.templateImplClass.rendererClass.renderStatements.Template_renderContent renderContent;
		public final $$.$.templateImplClass.templateImplClass.rendererClass.renderStatements.Template_renderValue renderValue;
		
		
		
		public Parts(
		    $$.$.templateImplClass.templateImplClass.rendererClass.renderStatements.Template_renderTemplate renderTemplate,$$.$.templateImplClass.templateImplClass.rendererClass.renderStatements.Template_renderContent renderContent,$$.$.templateImplClass.templateImplClass.rendererClass.renderStatements.Template_renderValue renderValue) {
			
			this.renderTemplate = renderTemplate;
			this.renderContent = renderContent;
			this.renderValue = renderValue;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		Renderer renderTemplate($$.$.templateImplClass.templateImplClass.rendererClass.renderStatements.Template_renderTemplate renderTemplate);
		Renderer renderContent($$.$.templateImplClass.templateImplClass.rendererClass.renderStatements.Template_renderContent renderContent);
		Renderer renderValue($$.$.templateImplClass.templateImplClass.rendererClass.renderStatements.Template_renderValue renderValue);
		
	}
	
}
