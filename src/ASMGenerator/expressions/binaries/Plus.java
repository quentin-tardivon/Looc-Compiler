package ASMGenerator.expressions.binaries;

import ASMGenerator.ASMUtils;
import ASMGenerator.expressions.Binary;
import ASMGenerator.expressions.Expression;


public class Plus extends Operation {

    public Plus(Expression left, Expression right) {
        super(left, right, ASMUtils.ADD, "+");
    }

}
