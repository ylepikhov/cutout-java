package cutout.java;

import java.io.IOException;

public abstract class Renderer {
	
	public abstract void render(Appendable out) throws IOException;

	static public final Renderer EMPTY = new EmptyRenderer();

    static class EmptyRenderer extends Renderer {

        @Override
        public void render(Appendable out) throws IOException { }
    }

    static class ConcatRenderer extends Renderer {

        private final Renderer first;
        private final Renderer second;

        public ConcatRenderer(Renderer first, Renderer second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public void render(Appendable out) throws IOException {

            first.render(out);
            second.render(out);
        }
    }

    static class ConstRenderer extends Renderer {

        private CharSequence value;

        public ConstRenderer(CharSequence value) {
            this.value = value;
        }

        @Override
        public void render(Appendable out) throws IOException {

            out.append(value);
        }
    }

    static public Renderer of(CharSequence value) {

        return new ConstRenderer(value);
    }

    public Renderer append(Renderer other) {

        if (this instanceof EmptyRenderer) return other;
        if (other instanceof  EmptyRenderer) return this;
        return new ConcatRenderer(this, other);
    }
}