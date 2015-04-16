package $$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.arg;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_value extends Template_value {

	static public final Template_value INSTANCE = new TemplateImpl_value();

    
	private TemplateImpl_value() {
		
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
            
            
            out.append("new TextTemplate(");out.append(_stringValue);out.append(")");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
