package dsl.expression;

import dsl.memory.BuildEnvironment;

public abstract class UnaryExpression implements Expression {

    private final Expression expression;

    private final String operator;

    public UnaryExpression(Expression expression, String operator) {
        this.expression = expression;
        this.operator = operator;
    }

    public Expression getExpression() {
        return expression;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return String.format(" %s %s", operator, expression);
    }

    public boolean checkType(BuildEnvironment buildEnvironment) {
        return getExpression().checkType(buildEnvironment) && checkTerminalElementType(buildEnvironment);
    }

    protected abstract boolean checkTerminalElementType(BuildEnvironment buildEnvironment);

}
