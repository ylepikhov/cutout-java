package $$.$.templateImplClass.templateImplClass.rendererClass.renderStatements;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_renderTemplate extends Template_renderTemplate {

	static public final Template_renderTemplate INSTANCE = new TemplateImpl_renderTemplate();

    
	private TemplateImpl_renderTemplate() {
		
		super(new Parts(TextTemplate.EMPTY
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
        
            String _name = params.name(parts.name);
            
            
            out.append("_");out.append(_name);out.append(".render(out);");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
