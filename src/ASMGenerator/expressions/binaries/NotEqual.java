package ASMGenerator.expressions.binaries;

import ASMGenerator.ASMUtils;
import ASMGenerator.expressions.Expression;

/**
 * Created by mcdostone on 14/05/17.
 */
public class NotEqual extends Comparison {

    public NotEqual(Expression left, Expression right) {
        super(left, right, ASMUtils.NE);
    }

}
