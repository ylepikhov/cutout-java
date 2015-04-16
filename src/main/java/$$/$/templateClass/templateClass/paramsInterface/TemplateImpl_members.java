package $$.$.templateClass.templateClass.paramsInterface;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_members extends Template_members {

	static public final Template_members INSTANCE = new TemplateImpl_members();

    
	private TemplateImpl_members() {
		
		super(new Parts(TextTemplate.EMPTY
		,TextTemplate.EMPTY
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
        
            String _name = params.name(parts.name);
            String _paramType = params.paramType(parts.paramType);
            String _returnType = params.returnType(parts.returnType);
            
            
            out.append(_returnType);out.append(" ");out.append(_name);out.append("(");out.append(_paramType);out.append(" ");out.append(_name);out.append(");\r\n\t\t");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
