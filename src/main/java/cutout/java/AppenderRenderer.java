package cutout.java;

import java.io.IOException;

public abstract class AppenderRenderer extends Renderer {
	
	static public final class Appender {
		
		private final Appendable out;
		
		private Appender(Appendable out) {
			
			this.out = out;
		}
		
		public void append(Renderer renderer) throws IOException {
			
			renderer.render(out);
		}
	}
	
	public final void render(Appendable out) throws IOException {

		render(new Appender(out));
	}
	
	public abstract void render(Appender appender) throws IOException;
}
