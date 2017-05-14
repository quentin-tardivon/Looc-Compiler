package ASMGenerator.instructions;

import ASMGenerator.ASMUtils;
import ASMGenerator.Generable;
import ASMGenerator.expressions.Expression;


public class Write implements Generable {

    private Expression e;

    public Write(Expression e) {
        this.e = e;
    }

    @Override
    public String generate() {
        return ASMUtils.generateWrite(e);
    }
}
