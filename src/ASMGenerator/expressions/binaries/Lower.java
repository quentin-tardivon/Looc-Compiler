package ASMGenerator.expressions.binaries;

import ASMGenerator.ASMUtils;
import ASMGenerator.expressions.Expression;

public class Lower extends Comparison {

    public Lower(Expression left, Expression right) {
        super(left, right, ASMUtils.LT, "<");
    }

}
