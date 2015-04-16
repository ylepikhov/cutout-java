package $$.$.templateClass.templateClass;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_partsClass extends Template_partsClass {

	static public final Template_partsClass INSTANCE = new TemplateImpl_partsClass();

    
	private TemplateImpl_partsClass() {
		
		super(new Parts($$.$.templateClass.templateClass.partsClass.TemplateImpl_fields.INSTANCE
		,$$.$.templateClass.templateClass.partsClass.TemplateImpl_constructor.INSTANCE
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
        
            Renderer _fields = params.fields(parts.fields);
            Renderer _constructor = params.constructor(parts.constructor);
            
            
            out.append("\r\n\tstatic public final class Parts {\r\n\t\t\r\n\t\t");_fields.render(out);out.append("\r\n\t\t\r\n\t\t");_constructor.render(out);out.append("\r\n\t}\r\n\t");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
