package com.plp.attributevalidatorapi.dsl.util;

public enum PrimitiveType implements Type {

    STRING("STRING");

    protected String name;

    PrimitiveType(String name) {
        this.name = name;
    }

    public boolean isString() {

        return this.isEquals(STRING);
    }

    public String getText() {
        return name;
    }

    public boolean isEquals(Type type) {
        boolean ret = false;
        if(isValid()) {
            ret = type.isValid() ? this.name.equals(type.getText()) : type.isEquals(this);
        }
        return ret;
    }

    public boolean isValid() {
        return this.name != null && name.length() > 0;
    }

    @Override
    public boolean isCnpj() {
        return false;
    }

    @Override
    public boolean isCpf() {
        return false;
    }

    @Override
    public boolean isZipCode() {
        return false;
    }

    @Override
    public boolean isName() {
        return false;
    }

    @Override
    public boolean isEmail() {
        return false;
    }

    public PrimitiveType intersection(Type otherType) {
        return otherType.isEquals(this) ? this : null;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
