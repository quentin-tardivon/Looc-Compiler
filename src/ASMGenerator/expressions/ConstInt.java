package ASMGenerator.expressions;

import ASMGenerator.ASMUtils;


public class ConstInt extends Expression {

    private int v;

    public ConstInt(int v) {
        this.v = v;
    }

    @Override
    public String generate() {
        return ASMUtils.generateIntegerConstant(this.v);
    }
}
