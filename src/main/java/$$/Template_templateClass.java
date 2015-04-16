package $$;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_templateClass extends TemplateBase<Template_templateClass.Parts,Template_templateClass.Params> {

	protected Template_templateClass(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final $$.$.templateClass.Template_templateClass templateClass;
		public final TextTemplate packageName;
		
		
		
		public Parts(
		    $$.$.templateClass.Template_templateClass templateClass,TextTemplate packageName) {
			
			this.templateClass = templateClass;
			this.packageName = packageName;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		Renderer templateClass($$.$.templateClass.Template_templateClass templateClass);
		String packageName(TextTemplate packageName);
		
	}
	
}
