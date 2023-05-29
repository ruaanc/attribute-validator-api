package com.plp.attributevalidatorapi.dsl.expression;

import com.plp.attributevalidatorapi.dsl.memory.BuildEnvironment;
import com.plp.attributevalidatorapi.dsl.memory.ExecutionEnvironment;
import com.plp.attributevalidatorapi.dsl.util.Type;

public interface Expression {

    Value evaluate(ExecutionEnvironment executionEnvironment);

    boolean checkType(BuildEnvironment buildEnvironment);

    Type getType(BuildEnvironment buildEnvironment);

}
