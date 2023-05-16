package dsl.expression;

import dsl.memory.BuildEnvironment;
import dsl.util.PrimitiveType;
import dsl.util.Type;

public class StringValue extends ConcreteValue<String> {

    public StringValue(String value) {
        super(value);
    }

    public Type getType(BuildEnvironment buildEnvironment) {
        return PrimitiveType.STRING;
    }

    @Override
    public String toString() {
        return String.format("\"%s\"", super.toString());
    }
}
