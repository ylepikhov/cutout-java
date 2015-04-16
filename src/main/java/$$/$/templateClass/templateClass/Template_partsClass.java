package $$.$.templateClass.templateClass;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_partsClass extends TemplateBase<Template_partsClass.Parts,Template_partsClass.Params> {

	protected Template_partsClass(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final $$.$.templateClass.templateClass.partsClass.Template_fields fields;
		public final $$.$.templateClass.templateClass.partsClass.Template_constructor constructor;
		
		
		
		public Parts(
		    $$.$.templateClass.templateClass.partsClass.Template_fields fields,$$.$.templateClass.templateClass.partsClass.Template_constructor constructor) {
			
			this.fields = fields;
			this.constructor = constructor;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		Renderer fields($$.$.templateClass.templateClass.partsClass.Template_fields fields);
		Renderer constructor($$.$.templateClass.templateClass.partsClass.Template_constructor constructor);
		
	}
	
}
