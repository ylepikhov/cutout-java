package $$.$.templateImplClass.templateImplClass;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_constructor extends Template_constructor {

	static public final Template_constructor INSTANCE = new TemplateImpl_constructor();

    
	private TemplateImpl_constructor() {
		
		super(new Parts($$.$.templateImplClass.templateImplClass.constructor.TemplateImpl_partsConstructorArgs.INSTANCE
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
        
            Renderer _partsConstructorArgs = params.partsConstructorArgs(parts.partsConstructorArgs);
            String _className = params.className(parts.className);
            
            
            out.append("\r\n\tprivate ");out.append(_className);out.append("() {\r\n\t\t\r\n\t\tsuper(new Parts(");_partsConstructorArgs.render(out);out.append("));\r\n\r\n\t}\r\n\t");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
