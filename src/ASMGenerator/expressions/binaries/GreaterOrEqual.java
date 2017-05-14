package ASMGenerator.expressions.binaries;

import ASMGenerator.ASMUtils;
import ASMGenerator.expressions.Expression;

/**
 * Created by mcdostone on 14/05/17.
 */
public class GreaterOrEqual extends Comparison {

    public GreaterOrEqual(Expression left, Expression right) {
        super(left, right, ASMUtils.GE);
    }

}
