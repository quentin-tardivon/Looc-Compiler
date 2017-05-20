package ASMGenerator.expressions.binaries;

import ASMGenerator.ASMUtils;
import ASMGenerator.expressions.Binary;
import ASMGenerator.expressions.Expression;


public class Mul extends Operation {

    public Mul(Expression left, Expression right) {
        super(left, right, ASMUtils.MUL, "*");
    }

}
