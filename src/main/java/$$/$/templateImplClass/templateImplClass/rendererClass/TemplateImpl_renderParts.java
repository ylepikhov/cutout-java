package $$.$.templateImplClass.templateImplClass.rendererClass;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_renderParts extends Template_renderParts {

	static public final Template_renderParts INSTANCE = new TemplateImpl_renderParts();

    
	private TemplateImpl_renderParts() {
		
		super(new Parts($$.$.templateImplClass.templateImplClass.rendererClass.renderParts.TemplateImpl_type.INSTANCE
		,TextTemplate.EMPTY
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
        
            Renderer _type = params.type(parts.type);
            String _name = params.name(parts.name);
            
            
            _type.render(out);out.append(" _");out.append(_name);out.append(" = params.");out.append(_name);out.append("(parts.");out.append(_name);out.append(");\r\n            ");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
