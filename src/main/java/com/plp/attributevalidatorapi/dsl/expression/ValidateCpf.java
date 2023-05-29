package com.plp.attributevalidatorapi.dsl.expression;

import com.plp.attributevalidatorapi.dsl.memory.BuildEnvironment;
import com.plp.attributevalidatorapi.dsl.memory.ExecutionEnvironment;
import com.plp.attributevalidatorapi.dsl.util.PrimitiveType;
import com.plp.attributevalidatorapi.dsl.util.Type;

public class ValidateCpf extends UnaryExpression {


    public ValidateCpf(Expression expression) {
        super(expression, "cpf");
    }

    @Override
    public Value evaluate(ExecutionEnvironment executionEnvironment) {
        String cpf = ((StringValue) getExpression().evaluate(executionEnvironment)).value();
        cpf = cpf.replaceAll("[^0-9]+", "");
        boolean isAllDigitsSame = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                isAllDigitsSame = false;
                break;
            }
        }
        if (isAllDigitsSame) {
            return new StringValue("CPF inválido: Todos os dígitos são iguais.");
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Integer.parseInt(cpf.substring(i, i+1));
            sum += digit * (10 - i);
        }
        int rest = sum % 11;
        int verifyingDigit1 = (rest < 2) ? 0 : (11 - rest);
        if ((verifyingDigit1 != Integer.parseInt(cpf.substring(9, 10)) || verifyingDigit1 == 0)) {
            return new StringValue("CPF inválido: Dígito verificador incorreto.");
        }

        return new StringValue("CPF é válido.");
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
