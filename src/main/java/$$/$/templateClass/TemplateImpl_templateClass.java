package $$.$.templateClass;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_templateClass extends Template_templateClass {

	static public final Template_templateClass INSTANCE = new TemplateImpl_templateClass();

    
	private TemplateImpl_templateClass() {
		
		super(new Parts($$.$.templateClass.templateClass.TemplateImpl_partsClass.INSTANCE
		,$$.$.templateClass.templateClass.TemplateImpl_paramsInterface.INSTANCE
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
        
            Renderer _partsClass = params.partsClass(parts.partsClass);
            Renderer _paramsInterface = params.paramsInterface(parts.paramsInterface);
            String _className = params.className(parts.className);
            
            
            out.append("\r\npublic abstract class ");out.append(_className);out.append(" extends TemplateBase<");out.append(_className);out.append(".Parts,");out.append(_className);out.append(".Params> {\r\n\r\n\tprotected ");out.append(_className);out.append("(Parts parts) {\r\n\t\t\r\n\t\tsuper(parts);\r\n\t}\r\n\t\r\n\t");_partsClass.render(out);out.append("\r\n\t\r\n\t");_paramsInterface.render(out);out.append("\r\n}\r\n");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
