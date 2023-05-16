package dsl.expression;

import dsl.memory.BuildEnvironment;
import dsl.memory.ExecutionEnvironment;
import dsl.util.PrimitiveType;
import dsl.util.Type;

public class EmailExpression extends UnaryExpression {

    public EmailExpression(Expression expression) {
        super(expression, "email:");
    }

    public Value evaluate(ExecutionEnvironment executionEnvironment) {
        return new StringValue("email: " + ((StringValue) getExpression().evaluate(executionEnvironment)).value());
    }

    protected boolean checkTerminalElementType(BuildEnvironment buildEnvironment) {
        return getExpression().getType(buildEnvironment).isString();
    }

    public Type getType(BuildEnvironment buildEnvironment) {
        return PrimitiveType.STRING;
    }

}
