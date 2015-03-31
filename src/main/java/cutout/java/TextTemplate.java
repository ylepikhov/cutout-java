package cutout.java;

public class TextTemplate {
	
	public final String value;

	static public final TextTemplate EMPTY = new TextTemplate("");
	
	public TextTemplate(String value) {
		this.value = value;
	}
	
	private Renderer renderer = null;
	
	public Renderer apply() {
		
		if (renderer == null)
			renderer = Renderer.of(value);
		
		return renderer;
	}
}