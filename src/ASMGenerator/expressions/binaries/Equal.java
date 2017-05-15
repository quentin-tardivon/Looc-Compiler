package ASMGenerator.expressions.binaries;

import ASMGenerator.ASMUtils;
import ASMGenerator.expressions.Expression;


public class Equal extends Comparison {

    public Equal(Expression left, Expression right) {
        super(left, right, ASMUtils.EQ, "==");
    }

}
