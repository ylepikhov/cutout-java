package $$.$.templateImplClass.templateImplClass.rendererClass.renderParts;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_type extends Template_type {

	static public final Template_type INSTANCE = new TemplateImpl_type();

    
	private TemplateImpl_type() {
		
		super(new Parts(new TextTemplate(" String")
		,new TextTemplate(" Renderer")
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
        
            String _string = params.string(parts.string);
            String _renderer = params.renderer(parts.renderer);
            
            
            out.append("\r\n                    ");out.append(_string);out.append("\r\n                    ");out.append(_renderer);out.append("\r\n                ");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
