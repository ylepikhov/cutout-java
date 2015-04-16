package $$;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_templateClass extends Template_templateClass {

	static public final Template_templateClass INSTANCE = new TemplateImpl_templateClass();

    
	private TemplateImpl_templateClass() {
		
		super(new Parts($$.$.templateClass.TemplateImpl_templateClass.INSTANCE
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
        
            Renderer _templateClass = params.templateClass(parts.templateClass);
            String _packageName = params.packageName(parts.packageName);
            
            
            out.append("package ");out.append(_packageName);out.append(";\r\n\r\nimport cutout.java.Renderer;\r\nimport cutout.java.TemplateBase;\r\nimport cutout.java.TextTemplate;\r\n\r\n");_templateClass.render(out);
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
