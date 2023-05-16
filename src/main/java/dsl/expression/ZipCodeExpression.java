package dsl.expression;

import dsl.memory.BuildEnvironment;
import dsl.memory.ExecutionEnvironment;
import dsl.util.PrimitiveType;
import dsl.util.Type;

public class ZipCodeExpression extends UnaryExpression {

    public ZipCodeExpression(Expression expression) {
        super(expression, "cep:");
    }

    public Value evaluate(ExecutionEnvironment executionEnvironment) {
        return new StringValue("cep: " + ((StringValue) getExpression().evaluate(executionEnvironment)).value());
    }

    protected boolean checkTerminalElementType(BuildEnvironment buildEnvironment) {
        return getExpression().getType(buildEnvironment).isString();
    }

    public Type getType(BuildEnvironment buildEnvironment) {
        return PrimitiveType.STRING;
    }

}
