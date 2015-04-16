package $$.$.templateClass.templateClass.paramsInterface;

import cutout.java.Renderer;
import cutout.java.TemplateBase;
import cutout.java.TextTemplate;


public abstract class Template_members extends TemplateBase<Template_members.Parts,Template_members.Params> {

	protected Template_members(Parts parts) {
		
		super(parts);
	}
	
	
	static public final class Parts {
		
		public final TextTemplate name;
		public final TextTemplate paramType;
		public final TextTemplate returnType;
		
		
		
		public Parts(
		    TextTemplate name,TextTemplate paramType,TextTemplate returnType) {
			
			this.name = name;
			this.paramType = paramType;
			this.returnType = returnType;
			
		}
		
	}
	
	
	
	static public interface Params {
		
		String name(TextTemplate name);
		String paramType(TextTemplate paramType);
		String returnType(TextTemplate returnType);
		
	}
	
}
