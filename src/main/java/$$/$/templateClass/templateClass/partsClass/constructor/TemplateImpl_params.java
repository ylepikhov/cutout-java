package $$.$.templateClass.templateClass.partsClass.constructor;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_params extends Template_params {

	static public final Template_params INSTANCE = new TemplateImpl_params();

    
	private TemplateImpl_params() {
		
		super(new Parts(TextTemplate.EMPTY
		,TextTemplate.EMPTY
		,new TextTemplate(" ,")
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
        
            String _type = params.type(parts.type);
            String _name = params.name(parts.name);
            String _delimiter = params.delimiter(parts.delimiter);
            
            
            out.append(_delimiter);out.append(_type);out.append(" ");out.append(_name);
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
