package ASMGenerator.expressions.binaries;

import ASMGenerator.ASMUtils;
import ASMGenerator.expressions.Binary;
import ASMGenerator.expressions.Expression;


public class Diff extends Operation {

    public Diff(Expression left, Expression right) {
        super(left, right, ASMUtils.DIFF);
    }
}
