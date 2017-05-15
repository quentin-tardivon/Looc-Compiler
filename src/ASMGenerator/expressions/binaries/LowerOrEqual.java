package ASMGenerator.expressions.binaries;

import ASMGenerator.ASMUtils;
import ASMGenerator.expressions.Expression;


public class LowerOrEqual extends Comparison {

    public LowerOrEqual(Expression left, Expression right) {
        super(left, right, ASMUtils.LE, "<=");
    }

}
