package ASMGenerator.expressions;

import ASMGenerator.ASMUtils;
import TDS.Entry;


public class Variable extends Expression {

    private TDS.entries.Variable v;
    public Variable (TDS.entries.Variable v) {
        this.v = v;
    }

    @Override
    public String generate() {
        return ASMUtils.generateVariable(this.v.getDepl());
    }

    @Override
    public String getType() {
        return this.v.get(Entry.TYPE);
    }
}
