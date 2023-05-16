package dsl.util;

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

    public PrimitiveType intersection(Type otherType) {
        return otherType.isEquals(this) ? this : null;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
