package $$.$.templateClass.templateClass;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_paramsInterface extends Template_paramsInterface {

	static public final Template_paramsInterface INSTANCE = new TemplateImpl_paramsInterface();

    
	private TemplateImpl_paramsInterface() {
		
		super(new Parts($$.$.templateClass.templateClass.paramsInterface.TemplateImpl_members.INSTANCE
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
        
            Renderer _members = params.members(parts.members);
            
            
            out.append("\r\n\tstatic public interface Params {\r\n\t\t\r\n\t\t");_members.render(out);out.append("\r\n\t}\r\n\t");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
