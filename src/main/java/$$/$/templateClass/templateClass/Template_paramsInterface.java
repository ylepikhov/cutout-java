package $$.$.templateClass.templateClass;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_paramsInterface extends TemplateBase<Template_paramsInterface.Parts,Template_paramsInterface.Params> {

	protected Template_paramsInterface(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final $$.$.templateClass.templateClass.paramsInterface.Template_members members;
		
		
		
		public Parts(
		    $$.$.templateClass.templateClass.paramsInterface.Template_members members) {
			
			this.members = members;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		Renderer members($$.$.templateClass.templateClass.paramsInterface.Template_members members);
		
	}
	
}
