package com.plp.attributevalidatorapi.dsl;

import com.plp.attributevalidatorapi.dsl.expression.Expression;
import com.plp.attributevalidatorapi.dsl.expression.Value;
import com.plp.attributevalidatorapi.dsl.memory.BuildContext;
import com.plp.attributevalidatorapi.dsl.memory.BuildEnvironment;
import com.plp.attributevalidatorapi.dsl.memory.ExecutionContext;
import com.plp.attributevalidatorapi.dsl.memory.ExecutionEnvironment;

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
