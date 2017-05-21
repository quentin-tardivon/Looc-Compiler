package ASMGenerator.instructions;

import ASMGenerator.ASMUtils;
import ASMGenerator.Generable;
import ASMGenerator.expressions.Expression;


public class Return implements Generable {

    private Expression e;

    public Return(Expression expression) {
        this.e = expression;
    }

    public Return() {}

    @Override
    public String generate() {
        return ASMUtils.generateReturn(this.e);
    }
}
