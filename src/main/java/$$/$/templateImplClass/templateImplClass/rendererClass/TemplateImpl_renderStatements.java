package $$.$.templateImplClass.templateImplClass.rendererClass;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_renderStatements extends Template_renderStatements {

	static public final Template_renderStatements INSTANCE = new TemplateImpl_renderStatements();

    
	private TemplateImpl_renderStatements() {
		
		super(new Parts($$.$.templateImplClass.templateImplClass.rendererClass.renderStatements.TemplateImpl_renderTemplate.INSTANCE
		,$$.$.templateImplClass.templateImplClass.rendererClass.renderStatements.TemplateImpl_renderContent.INSTANCE
		,$$.$.templateImplClass.templateImplClass.rendererClass.renderStatements.TemplateImpl_renderValue.INSTANCE
		));

	}
	

    
    static public final class TemplateRenderer extends Renderer {

        private final Parts parts;
        private final Params params;

        private TemplateRenderer(Parts parts, Params params) {
        
            this.parts = parts;
            this.params = params;
        }
        
        public void render(Appendable out) throws IOException {
        
            Renderer _renderTemplate = params.renderTemplate(parts.renderTemplate);
            Renderer _renderContent = params.renderContent(parts.renderContent);
            Renderer _renderValue = params.renderValue(parts.renderValue);
            
            
            out.append("\r\n                ");_renderContent.render(out);out.append("\r\n                ");_renderValue.render(out);out.append("\r\n                ");_renderTemplate.render(out);out.append("\r\n            ");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
