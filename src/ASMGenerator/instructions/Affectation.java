package ASMGenerator.instructions;

import ASMGenerator.ASMUtils;
import ASMGenerator.Generable;
import ASMGenerator.expressions.Expression;
import TDS.entries.Variable;


public class Affectation implements Generable {

    private Variable v;
    private Expression e;
    public Affectation(Variable v, Expression b) {
        this.v = v;
        this.e = b;
    }

    @Override
    public String generate() {
        return ASMUtils.generateAffection(v.getDepl(), e);
    }
}
