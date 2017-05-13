package ASMGenerator.expressions.binaries;

import ASMGenerator.ASMUtils;
import ASMGenerator.expressions.Binary;
import ASMGenerator.expressions.Expression;

/**
 * Created by mcdostone on 13/05/17.
 */
public class Multiplication extends Binary {

    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String generateOperation() {
        return ASMUtils.generateMultiplication();
    }
}
