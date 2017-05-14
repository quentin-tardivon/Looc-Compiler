package ASMGenerator.expressions;

import ASMGenerator.ASMUtils;


public class ConstantInteger extends Expression {

    private int v;

    public ConstantInteger(int v) {
        this.v = v;
    }

    @Override
    public String generate() {
        return ASMUtils.generateConstantInteger(this.v);
    }
}
