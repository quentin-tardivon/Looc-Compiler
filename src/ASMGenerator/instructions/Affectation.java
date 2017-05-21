package ASMGenerator.instructions;

import ASMGenerator.ASMUtils;
import ASMGenerator.Generable;
import ASMGenerator.Receiver;
import ASMGenerator.expressions.Expression;
import ASMGenerator.expressions.Variable;
import TDS.SymbolTable;


public class Affectation implements Generable {

    private Receiver r;
    private Expression e;
    private SymbolTable localTDS;
    public Affectation(Receiver r, SymbolTable localTDS, Expression b) {
        this.r = r;
        this.localTDS = localTDS;
        this.e = b;
    }

    @Override
    public String generate() {
        return ASMUtils.generateAffection(this.r, this.localTDS, this.e);
    }

    public Variable getVariable() {
        return this.r.getVariable();
    }

    public Expression getExpression() {
        return this.e;
    }
}
