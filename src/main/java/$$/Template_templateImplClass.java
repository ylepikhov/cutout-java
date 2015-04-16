package $$;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_templateImplClass extends TemplateBase<Template_templateImplClass.Parts,Template_templateImplClass.Params> {

	protected Template_templateImplClass(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final $$.$.templateImplClass.Template_templateImplClass templateImplClass;
		public final TextTemplate packageName;
		
		
		
		public Parts(
		    $$.$.templateImplClass.Template_templateImplClass templateImplClass,TextTemplate packageName) {
			
			this.templateImplClass = templateImplClass;
			this.packageName = packageName;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		Renderer templateImplClass($$.$.templateImplClass.Template_templateImplClass templateImplClass);
		String packageName(TextTemplate packageName);
		
	}
	
}
