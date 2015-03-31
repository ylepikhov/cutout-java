package cutout.java;

public abstract class ParameterizedTemplate<T> {
	
	public abstract Renderer apply(T params);
}