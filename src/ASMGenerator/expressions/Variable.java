package ASMGenerator.expressions;

import ASMGenerator.ASMUtils;


public class Variable extends Expression {

    private TDS.entries.Variable v;
    public Variable (TDS.entries.Variable v) {
        this.v = v;
    }

    @Override
    public String generate(){
        return ASMUtils.generateVariable(this.v.getDepl());
    }

    public TDS.entries.Variable getVariableEntry() {
        return this.v;
    }
}
