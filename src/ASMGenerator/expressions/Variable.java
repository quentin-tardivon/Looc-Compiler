package ASMGenerator.expressions;

import ASMGenerator.ASMUtils;

/**
 * Created by mcdostone on 13/05/17.
 */
public class Variable extends Expression {

    private TDS.entries.Variable v;
    public Variable (TDS.entries.Variable v) {
        this.v = v;
    }

    @Override
    public String generate() {
        return ASMUtils.generateVariable(this.v.getDepl());
    }
}
