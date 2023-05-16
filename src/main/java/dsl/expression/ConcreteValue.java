package dsl.expression;

import dsl.memory.BuildEnvironment;
import dsl.memory.ExecutionEnvironment;

public abstract class ConcreteValue<T> implements Value {

    private T value;

    public ConcreteValue(T value) {
        this.value = value;
    }

    public String toString() {
        return String.valueOf(value);
    }

    public T value() {
        return value;
    }

    public boolean isEquals(ConcreteValue<T> obj) {
        return value().equals(obj.value());
    }

    public Value evaluate(ExecutionEnvironment executionEnvironment) {
        return this;
    }

    public boolean checkType(BuildEnvironment buildEnvironment) {
        return true;
    }
}
