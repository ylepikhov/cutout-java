package $$;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_templateImplClass extends Template_templateImplClass {

	static public final Template_templateImplClass INSTANCE = new TemplateImpl_templateImplClass();

    
	private TemplateImpl_templateImplClass() {
		
		super(new Parts($$.$.templateImplClass.TemplateImpl_templateImplClass.INSTANCE
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
        
            Renderer _templateImplClass = params.templateImplClass(parts.templateImplClass);
            String _packageName = params.packageName(parts.packageName);
            
            
            out.append("package ");out.append(_packageName);out.append(";\r\n\r\nimport cutout.java.Renderer;\r\nimport cutout.java.TextTemplate;\r\n\r\nimport java.io.IOException;\r\n\r\n");_templateImplClass.render(out);
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
