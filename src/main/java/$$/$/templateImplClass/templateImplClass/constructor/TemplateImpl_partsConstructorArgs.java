package $$.$.templateImplClass.templateImplClass.constructor;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_partsConstructorArgs extends Template_partsConstructorArgs {

	static public final Template_partsConstructorArgs INSTANCE = new TemplateImpl_partsConstructorArgs();

    
	private TemplateImpl_partsConstructorArgs() {
		
		super(new Parts($$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.TemplateImpl_arg.INSTANCE
		,new TextTemplate(" ,")
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
        
            Renderer _arg = params.arg(parts.arg);
            String _delimiter = params.delimiter(parts.delimiter);
            
            
            out.append(_delimiter);_arg.render(out);out.append("\r\n\t\t");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
