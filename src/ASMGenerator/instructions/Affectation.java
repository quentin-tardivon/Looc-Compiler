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
        return ASMUtils.generateAffection(this.v, this.localTDS, this.e);
        /*TDS.entries.Variable varEntry = this.v.getVariableEntry();
        ASMUtils.generateAffection(this.v, localTDS);

        if(this.localTDS.contains(varEntry))
            return ASMUtils.generateAffection(this.v, this.e);
        else
            return ASMUtils.generateAffectionWithStaticLink(this.localTDS.getImbricationLevel(), this.localTDS.getSymbolTable(varEntry).getImbricationLevel(), varEntry.getDepl(), this.e);
           */
    }

    public Variable getVariable() {
        return this.v;
    }

    public Expression getExpression() {
        return this.e;
    }
}
