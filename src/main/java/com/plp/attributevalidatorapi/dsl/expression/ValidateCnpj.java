package com.plp.attributevalidatorapi.dsl.expression;

import com.plp.attributevalidatorapi.dsl.memory.BuildEnvironment;
import com.plp.attributevalidatorapi.dsl.memory.ExecutionEnvironment;
import com.plp.attributevalidatorapi.dsl.util.PrimitiveType;
import com.plp.attributevalidatorapi.dsl.util.Type;

public class ValidateCnpj extends UnaryExpression {

    public ValidateCnpj(Expression expression) {
        super(expression, "cnpj");
    }

    @Override
    public Value evaluate(ExecutionEnvironment executionEnvironment) {

        String cnpj = ((StringValue) getExpression().evaluate(executionEnvironment)).value();
        cnpj = cnpj.replaceAll("\\D", "");

        if (cnpj.length() != 14) {
            return new StringValue("CNPJ inválido: Não contém 14 dígitos");
        }

        if (cnpj.matches("(\\d)\\1{13}")) {
            return new StringValue("CNPJ inválido: Todos os dígitos são iguais.");
        }

        int sum = 0;
        int weight = 5;
        for (int i = 0; i < 12; i++) {
            int num = Character.getNumericValue(cnpj.charAt(i));
            sum += num * weight;
            weight = weight == 2 ? 9 : weight - 1;
        }
        int digit1 = sum % 11 < 2 ? 0 : 11 - sum % 11;

        if (Character.getNumericValue(cnpj.charAt(12)) != digit1) {
            return new StringValue("CNPJ inválido: Dígito verificador incorreto.");
        }

        sum = 0;
        weight = 6;
        for (int i = 0; i < 13; i++) {
            int num = Character.getNumericValue(cnpj.charAt(i));
            sum += num * weight;
            weight = weight == 2 ? 9 : weight - 1;
        }
        int digit2 = sum % 11 < 2 ? 0 : 11 - sum % 11;

        if (Character.getNumericValue(cnpj.charAt(13)) != digit2) {
            return new StringValue("CNPJ inválido: Dígito verificador incorreto.");
        }

        return new StringValue("CNPJ é válido.");
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
