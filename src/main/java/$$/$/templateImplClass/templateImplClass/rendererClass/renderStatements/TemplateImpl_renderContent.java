package $$.$.templateImplClass.templateImplClass.rendererClass.renderStatements;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_renderContent extends Template_renderContent {

	static public final Template_renderContent INSTANCE = new TemplateImpl_renderContent();

    
	private TemplateImpl_renderContent() {
		
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
        
            String _stringValue = params.stringValue(parts.stringValue);
            
            
            out.append("out.append(");out.append(_stringValue);out.append(");");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
