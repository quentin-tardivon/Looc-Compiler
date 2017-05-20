package ASMGenerator.expressions.binaries;

import ASMGenerator.ASMUtils;
import ASMGenerator.expressions.Expression;


public class NotEqual extends Comparison {

    public NotEqual(Expression left, Expression right) {
        super(left, right, ASMUtils.NE, "!=");
    }

}
