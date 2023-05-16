package dsl.util;

public interface Type {

    String getText();

    boolean isEquals(Type type);

    boolean isValid();

    boolean isString();

}
