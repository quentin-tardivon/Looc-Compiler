package ASMGenerator.instructions;

import ASMGenerator.ASMUtils;
import ASMGenerator.Generable;
import ASMGenerator.expressions.Expression;
import ASMGenerator.expressions.Variable;
import TDS.SymbolTable;


public class Affectation implements Generable {

    private Variable v;
    private Expression e;
    private SymbolTable localTDS;
    public Affectation(Variable v, SymbolTable localTDS, Expression b) {
        this.v = v;
        this.localTDS = localTDS;
        this.e = b;
    }

    @Override
    public String generate() {
        TDS.entries.Variable varEntry = this.v.getVariableEntry();

        if(this.localTDS.contains(varEntry))
            return ASMUtils.generateAffection(this.v.getVariableEntry().getDepl(), this.e);
        else
            return ASMUtils.generateAffectionWithStaticLink(this.localTDS.getImbricationLevel(), this.localTDS.getSymbolTable(varEntry).getImbricationLevel());
    }

    public Variable getVariable() {
        return this.v;
    }

    public Expression getExpression() {
        return this.e;
    }
}
