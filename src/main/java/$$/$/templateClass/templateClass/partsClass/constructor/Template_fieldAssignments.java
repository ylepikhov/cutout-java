package $$.$.templateClass.templateClass.partsClass.constructor;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_fieldAssignments extends TemplateBase<Template_fieldAssignments.Parts,Template_fieldAssignments.Params> {

	protected Template_fieldAssignments(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final TextTemplate name;
		
		
		
		public Parts(
		    TextTemplate name) {
			
			this.name = name;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		String name(TextTemplate name);
		
	}
	
}
