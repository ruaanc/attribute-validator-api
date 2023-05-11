package dsl.expression;

import dsl.memory.BuildEnvironment;
import dsl.memory.ExecutionEnvironment;
import dsl.util.Type;

public interface Expression {

    Value evaluate(ExecutionEnvironment executionEnvironment);

    boolean checkType(BuildEnvironment buildEnvironment);

    Type getType(BuildEnvironment buildEnvironment);

}
