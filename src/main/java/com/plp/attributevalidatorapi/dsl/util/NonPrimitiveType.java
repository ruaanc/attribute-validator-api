package com.plp.attributevalidatorapi.dsl.util;

public enum NonPrimitiveType implements Type {

    CNPJ("CNPJ"),
    CPF("CPF"),
    ZIP_CODE("ZIP_CODE"),
    NAME("NAME"),
    EMAIL("EMAIL");

    protected String name;

    NonPrimitiveType(String name) {
        this.name = name;
    }

    @Override
    public String getText() {
        return name;
    }

    @Override
    public boolean isEquals(Type type) {
        boolean ret = false;
        if(isValid()) {
            ret = type.isValid() ? this.name.equals(type.getText()) : type.isEquals(this);
        }
        return ret;
    }

    @Override
    public boolean isValid() {
        return this.name != null && name.length() > 0;
    }

    @Override
    public boolean isString() {
        return false;
    }

    public NonPrimitiveType intersection(Type otherType) {
        return otherType.isEquals(this) ? this : null;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean isCnpj() {
        return this.isEquals(CNPJ);
    }

    @Override
    public boolean isCpf() {
        return this.isEquals(CPF);
    }

    @Override
    public boolean isZipCode() {
        return this.isEquals(ZIP_CODE);
    }

    @Override
    public boolean isName() {
        return this.isEquals(NAME);
    }

    @Override
    public boolean isEmail() {
        return this.isEquals(EMAIL);
    }
}
