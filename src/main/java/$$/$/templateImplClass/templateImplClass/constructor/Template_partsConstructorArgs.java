package $$.$.templateImplClass.templateImplClass.constructor;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_partsConstructorArgs extends TemplateBase<Template_partsConstructorArgs.Parts,Template_partsConstructorArgs.Params> {

	protected Template_partsConstructorArgs(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final $$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.Template_arg arg;
		public final TextTemplate delimiter;
		
		
		
		public Parts(
		    $$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.Template_arg arg,TextTemplate delimiter) {
			
			this.arg = arg;
			this.delimiter = delimiter;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		Renderer arg($$.$.templateImplClass.templateImplClass.constructor.partsConstructorArgs.Template_arg arg);
		String delimiter(TextTemplate delimiter);
		
	}
	
}
