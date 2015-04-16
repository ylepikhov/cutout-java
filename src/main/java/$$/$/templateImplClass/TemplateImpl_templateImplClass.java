package $$.$.templateImplClass;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;


public final class TemplateImpl_templateImplClass extends Template_templateImplClass {

	static public final Template_templateImplClass INSTANCE = new TemplateImpl_templateImplClass();

    
	private TemplateImpl_templateImplClass() {
		
		super(new Parts($$.$.templateImplClass.templateImplClass.TemplateImpl_constructor.INSTANCE
		,$$.$.templateImplClass.templateImplClass.TemplateImpl_rendererClass.INSTANCE
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
        
            Renderer _constructor = params.constructor(parts.constructor);
            Renderer _rendererClass = params.rendererClass(parts.rendererClass);
            String _className = params.className(parts.className);
            String _baseClassName = params.baseClassName(parts.baseClassName);
            
            
            out.append("\r\npublic final class ");out.append(_className);out.append(" extends ");out.append(_baseClassName);out.append(" {\r\n\r\n\tstatic public final ");out.append(_baseClassName);out.append(" INSTANCE = new ");out.append(_className);out.append("();\r\n\r\n    ");_constructor.render(out);out.append("\r\n\r\n    ");_rendererClass.render(out);out.append("\r\n\t\r\n\t@Override\r\n\tpublic Renderer apply(Params params) {\r\n\r\n\t\treturn new TemplateRenderer(parts, params);\r\n\t}\r\n}\r\n");
        }
    }
    
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(parts, params);
	}
}
