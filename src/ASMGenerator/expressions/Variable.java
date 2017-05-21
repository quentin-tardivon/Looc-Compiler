package ASMGenerator.expressions;

import ASMGenerator.ASMUtils;
import TDS.Entry;
import TDS.SymbolTable;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class Variable extends Expression {

    protected TDS.entries.Variable v;
    protected SymbolTable localTDS;

    public Variable (TDS.entries.Variable v, SymbolTable TDS) {
        this.v = v;
        this.localTDS = TDS;
    }

    @Override
    public String generate(){
        return ASMUtils.generateVariable(this.v, this.localTDS);
    }

    public TDS.entries.Variable getVariableEntry() {
        return this.v;
    }

    public String toString() {
        return this.v.getNameVariable();
    }

    @Override
    public String getType() {
        return this.v.get(Entry.TYPE);
    }
}
