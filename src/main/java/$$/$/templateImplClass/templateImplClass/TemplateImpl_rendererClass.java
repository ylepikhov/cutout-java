package $$.$.templateImplClass.templateImplClass;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_rendererClass extends Template_rendererClass {

	static public final Template_rendererClass INSTANCE = new TemplateImpl_rendererClass();

    
	private TemplateImpl_rendererClass() {
		
		super(new Parts($$.$.templateImplClass.templateImplClass.rendererClass.TemplateImpl_renderStatements.INSTANCE
		,$$.$.templateImplClass.templateImplClass.rendererClass.TemplateImpl_renderParts.INSTANCE
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
        
            Renderer _renderStatements = params.renderStatements(parts.renderStatements);
            Renderer _renderParts = params.renderParts(parts.renderParts);
            
            
            out.append("\r\n    static public final class TemplateRenderer extends Renderer {\r\n\r\n        private final Parts parts;\r\n        private final Params params;\r\n\r\n        private TemplateRenderer(Parts parts, Params params) {\r\n\r\n            this.parts = parts;\r\n            this.params = params;\r\n        }\r\n\r\n        public void render(Appendable out) throws IOException {\r\n\r\n            ");_renderParts.render(out);out.append("\r\n\r\n            ");_renderStatements.render(out);out.append("\r\n        }\r\n    }\r\n    ");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
