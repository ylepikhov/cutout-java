package cutout.java;

public abstract class TemplateBase<Parts, Params> {

    public final Parts parts;

    protected TemplateBase(final Parts parts) {

        this.parts = parts;
    }

    public abstract Renderer apply(final Params params);
}