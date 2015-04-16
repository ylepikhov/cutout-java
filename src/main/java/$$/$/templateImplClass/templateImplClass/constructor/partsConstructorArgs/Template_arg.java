package $$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_arg extends TemplateBase<Template_arg.Parts,Template_arg.Params> {

	protected Template_arg(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final $$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.arg.Template_value value;
		public final $$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.arg.Template_part part;
		public final TextTemplate empty;
		
		
		
		public Parts(
		    $$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.arg.Template_value value,$$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.arg.Template_part part,TextTemplate empty) {
			
			this.value = value;
			this.part = part;
			this.empty = empty;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		Renderer value($$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.arg.Template_value value);
		Renderer part($$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.arg.Template_part part);
		String empty(TextTemplate empty);
		
	}
	
}
