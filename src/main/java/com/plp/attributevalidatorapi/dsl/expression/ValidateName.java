package com.plp.attributevalidatorapi.dsl.expression;

import com.plp.attributevalidatorapi.dsl.memory.BuildEnvironment;
import com.plp.attributevalidatorapi.dsl.memory.ExecutionEnvironment;
import com.plp.attributevalidatorapi.dsl.util.PrimitiveType;
import com.plp.attributevalidatorapi.dsl.util.Type;

public class ValidateName extends UnaryExpression {

    public ValidateName(Expression expression) {
        super(expression, "name");
    }

    @Override
    public Value evaluate(ExecutionEnvironment executionEnvironment) {
        String name = ((StringValue) getExpression().evaluate(executionEnvironment)).value();
        String regex = "^[a-zA-Z]+(([a-zA-Z ])?[a-zA-Z]*)*$";
        boolean isValid = name.matches(regex) && name.split(" ").length >= 2;
        if(!isValid) {
            return new StringValue("Nome inválido.");
        }
        return new StringValue("Nome é válido.");
    }

    @Override
    public Type getType(BuildEnvironment buildEnvironment) {
        return PrimitiveType.STRING;
    }

    @Override
    protected boolean checkTerminalElementType(BuildEnvironment buildEnvironment) {
        return getExpression().getType(buildEnvironment).isString();
    }
}
