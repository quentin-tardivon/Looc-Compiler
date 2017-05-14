package ASMGenerator.expressions;

import ASMGenerator.ASMUtils;
import TDS.Entry;
import TDS.SymbolTable;


public class Variable extends Expression {

    private TDS.entries.Variable v;
    private SymbolTable localTDS;
    public Variable (TDS.entries.Variable v, SymbolTable TDS) {
        this.v = v;
        this.localTDS = TDS;
    }

    @Override
    public String generate(){
        if(this.localTDS.contains(this.v))
            return ASMUtils.generateVariable(this.v.getDepl());
        else
            return ASMUtils.generateVariableStaticLink(this.localTDS.getImbricationLevel(), this.localTDS.getSymbolTable(this.v).getImbricationLevel(), this.v.getDepl());
    }

    public TDS.entries.Variable getVariableEntry() {
        return this.v;
    }

    @Override
    public String getType() {
        return this.v.get(Entry.TYPE);
    }
}
