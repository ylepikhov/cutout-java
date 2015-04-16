package $$.$.templateClass.templateClass.partsClass;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_constructor extends Template_constructor {

	static public final Template_constructor INSTANCE = new TemplateImpl_constructor();

    
	private TemplateImpl_constructor() {
		
		super(new Parts($$.$.templateClass.templateClass.partsClass.constructor.TemplateImpl_params.INSTANCE
		,$$.$.templateClass.templateClass.partsClass.constructor.TemplateImpl_fieldAssignments.INSTANCE
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
        
            Renderer _params = params.params(parts.params);
            Renderer _fieldAssignments = params.fieldAssignments(parts.fieldAssignments);
            
            
            out.append("\r\n\t\tpublic Parts(\r\n\t\t    ");_params.render(out);out.append(") {\r\n\t\t\t\r\n\t\t\t");_fieldAssignments.render(out);out.append("\r\n\t\t}\r\n\t\t");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
