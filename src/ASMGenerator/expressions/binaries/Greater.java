package ASMGenerator.expressions.binaries;

import ASMGenerator.ASMUtils;
import ASMGenerator.expressions.Expression;


public class Greater extends Comparison {

    public Greater(Expression left, Expression right) {
        super(left, right, ASMUtils.GT, ">");
    }
}
