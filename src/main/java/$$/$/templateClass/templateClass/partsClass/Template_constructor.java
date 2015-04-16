package $$.$.templateClass.templateClass.partsClass;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_constructor extends TemplateBase<Template_constructor.Parts,Template_constructor.Params> {

	protected Template_constructor(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final $$.$.templateClass.templateClass.partsClass.constructor.Template_params params;
		public final $$.$.templateClass.templateClass.partsClass.constructor.Template_fieldAssignments fieldAssignments;
		
		
		
		public Parts(
		    $$.$.templateClass.templateClass.partsClass.constructor.Template_params params,$$.$.templateClass.templateClass.partsClass.constructor.Template_fieldAssignments fieldAssignments) {
			
			this.params = params;
			this.fieldAssignments = fieldAssignments;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		Renderer params($$.$.templateClass.templateClass.partsClass.constructor.Template_params params);
		Renderer fieldAssignments($$.$.templateClass.templateClass.partsClass.constructor.Template_fieldAssignments fieldAssignments);
		
	}
	
}
