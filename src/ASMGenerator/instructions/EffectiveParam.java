package ASMGenerator.instructions;

import ASMGenerator.ASMUtils;
import ASMGenerator.Generable;
import ASMGenerator.expressions.Expression;
import TDS.Entry;
import TDS.SymbolTable;
import TDS.entries.Parameter;


public class EffectiveParam extends Expression implements Generable {

    private Parameter p;
    private SymbolTable tds;

    public EffectiveParam(Parameter p, SymbolTable tds) {
        this.p = p;
        this.tds = tds;
    }

    @Override
    public String generate() {
        return ASMUtils.generateEffectiveParam(this.p);
    }

    @Override
    public String getType() {
        return p.get(Entry.TYPE);
    }
}
