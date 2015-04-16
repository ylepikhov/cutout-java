package $$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_arg extends Template_arg {

	static public final Template_arg INSTANCE = new TemplateImpl_arg();

    
	private TemplateImpl_arg() {
		
		super(new Parts($$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.arg.TemplateImpl_value.INSTANCE
		,$$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.arg.TemplateImpl_part.INSTANCE
		,new TextTemplate(" TextTemplate.EMPTY")
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
        
            Renderer _value = params.value(parts.value);
            Renderer _part = params.part(parts.part);
            String _empty = params.empty(parts.empty);
            
            
            out.append("\r\n\t\t\t");_part.render(out);out.append("\r\n\t\t\t");out.append(_empty);out.append("\r\n\t\t\t");_value.render(out);out.append("\r\n\t\t");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
