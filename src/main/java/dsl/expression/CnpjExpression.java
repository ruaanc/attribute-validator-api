package dsl.expression;

import dsl.memory.BuildEnvironment;
import dsl.memory.ExecutionEnvironment;
import dsl.util.PrimitiveType;
import dsl.util.Type;

public class CnpjExpression extends UnaryExpression {

    public CnpjExpression(Expression expression) {
        super(expression, "cnpj:");
    }

    public Value evaluate(ExecutionEnvironment executionEnvironment) {
        return new StringValue("cnpj: " + ((StringValue) getExpression().evaluate(executionEnvironment)).value());
    }

    protected boolean checkTerminalElementType(BuildEnvironment buildEnvironment) {
        return getExpression().getType(buildEnvironment).isString();
    }

    public Type getType(BuildEnvironment buildEnvironment) {
        return PrimitiveType.STRING;
    }

}
