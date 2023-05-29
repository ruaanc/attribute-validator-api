package com.plp.attributevalidatorapi.dsl.expression;

import com.plp.attributevalidatorapi.dsl.memory.BuildEnvironment;
import com.plp.attributevalidatorapi.dsl.memory.ExecutionEnvironment;
import com.plp.attributevalidatorapi.dsl.util.PrimitiveType;
import com.plp.attributevalidatorapi.dsl.util.Type;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ValidateZipCode extends UnaryExpression {

    public ValidateZipCode(Expression expression) {
        super(expression, "cep");
    }

    @Override
    public Value evaluate(ExecutionEnvironment executionEnvironment) {
        try {
            String cep = ((StringValue) getExpression().evaluate(executionEnvironment)).value();
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            Scanner scanner = new Scanner(conn.getInputStream());
            StringBuffer buffer = new StringBuffer();
            while (scanner.hasNextLine()) {
                buffer.append(scanner.nextLine());
            }
            scanner.close();
            String value = buffer.toString();
            if(value.contains("erro")) {
                return new StringValue("CEP inválido.");
            }
            return new StringValue("CEP é válido.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new StringValue("");
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
