package $$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.arg;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_part extends Template_part {

	static public final Template_part INSTANCE = new TemplateImpl_part();

    
	private TemplateImpl_part() {
		
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
        
            String _className = params.className(parts.className);
            
            
            out.append(_className);out.append(".INSTANCE");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
