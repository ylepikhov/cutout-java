package cutout.java;

import java.io.IOException;

public class ConstRenderer extends Renderer {
	
	private final CharSequence value;
	
	public ConstRenderer(CharSequence value) {
		this.value = value;
	}

	public void render(Appendable out) throws IOException {
		
		out.append(value);
	}
}