package ASMGenerator.expressions.binaries;

import ASMGenerator.ASMUtils;
import ASMGenerator.expressions.Binary;
import ASMGenerator.expressions.Expression;


public abstract class Operation extends Binary {

    protected String operator;

    public Operation(Expression left, Expression right, String operator) {
        super(left, right);
        this.operator = operator;
    }

    @Override
    public String generateOperation() {
        return ASMUtils.generateOperator(this.operator);
    }
}
