package com.plp.attributevalidatorapi.dsl.expression;

import com.plp.attributevalidatorapi.dsl.memory.BuildEnvironment;
import com.plp.attributevalidatorapi.dsl.memory.ExecutionEnvironment;
import com.plp.attributevalidatorapi.dsl.util.PrimitiveType;
import com.plp.attributevalidatorapi.dsl.util.Type;

public class ValidateEmail extends UnaryExpression {


    public ValidateEmail(Expression expression) {
        super(expression, "email");
    }

    @Override
    public Value evaluate(ExecutionEnvironment executionEnvironment) {
        String email = ((StringValue) getExpression().evaluate(executionEnvironment)).value();
        String regex = "^[\\w.-]+@[a-z]+\\.[a-z]{2,3}$";
        boolean isEmailValid = email.matches(regex);
        if(!isEmailValid) {
            return new StringValue("Email inválido.");
        }
        return new StringValue("Email é válido.");
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
