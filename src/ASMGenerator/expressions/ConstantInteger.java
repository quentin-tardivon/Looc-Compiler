package ASMGenerator.expressions;

import ASMGenerator.ASMUtils;
import core.Keywords;


public class ConstantInteger extends Expression {

    private int v;

    public ConstantInteger(int v) {
        this.v = v;
    }

    @Override
    public String generate() {
        return ASMUtils.generateConstantInteger(this.v);
    }

    @Override
    public String getType() {
        return Keywords.INTEGER;
    }

    public String toString() {
        return Integer.toString(this.v);
    }
}
