package dsl;

import dsl.expression.Expression;
import dsl.expression.Value;
import dsl.memory.BuildContext;
import dsl.memory.BuildEnvironment;
import dsl.memory.ExecutionContext;
import dsl.memory.ExecutionEnvironment;

public class Program {

    private Expression expression;

    public Value execute() {
        ExecutionEnvironment executionEnvironment = new ExecutionContext();
        Value result = expression.evaluate(executionEnvironment);
        System.out.println(result);
        return result;
    }

    public boolean checkType() {
        BuildEnvironment buildEnvironment = new BuildContext();
        return expression.checkType(buildEnvironment);
    }

    public Program(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

}
