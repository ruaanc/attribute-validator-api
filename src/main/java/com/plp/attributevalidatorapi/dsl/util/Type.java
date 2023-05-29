package com.plp.attributevalidatorapi.dsl.util;

public interface Type {

    String getText();

    boolean isEquals(Type type);

    boolean isValid();

    boolean isString();

    boolean isCnpj();

    boolean isCpf();

    boolean isZipCode();

    boolean isName();

    boolean isEmail();

}
