package ASMGenerator.expressions.binaries;

import ASMGenerator.ASMUtils;
import ASMGenerator.expressions.Binary;
import ASMGenerator.expressions.Expression;


public class Div extends Operation {

    public Div(Expression left, Expression right) {
        super(left, right, ASMUtils.DIV);
    }

}
