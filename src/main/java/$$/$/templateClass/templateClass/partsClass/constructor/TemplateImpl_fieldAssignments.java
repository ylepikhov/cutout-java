package $$.$.templateClass.templateClass.partsClass.constructor;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_fieldAssignments extends Template_fieldAssignments {

	static public final Template_fieldAssignments INSTANCE = new TemplateImpl_fieldAssignments();

    
	private TemplateImpl_fieldAssignments() {
		
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
            
            
            out.append("this.");out.append(_name);out.append(" = ");out.append(_name);out.append(";\r\n\t\t\t");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
