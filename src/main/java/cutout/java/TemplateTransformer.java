package cutout.java;

public interface TemplateTransformer<T, R> {

    R transform(T template);
}