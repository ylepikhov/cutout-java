package $$.$.templateClass.templateClass.partsClass;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_fields extends Template_fields {

	static public final Template_fields INSTANCE = new TemplateImpl_fields();

    
	private TemplateImpl_fields() {
		
		super(new Parts(TextTemplate.EMPTY
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
        
            String _type = params.type(parts.type);
            String _name = params.name(parts.name);
            
            
            out.append("public final ");out.append(_type);out.append(" ");out.append(_name);out.append(";\r\n\t\t");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
