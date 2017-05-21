package ASMGenerator.expressions;

import ASMGenerator.ASMUtils;
import ASMGenerator.Generable;
import TDS.Entry;
import TDS.SymbolTable;


public class Attribute extends Variable implements Generable {

    public Attribute (TDS.entries.Attribute v, SymbolTable TDS) {
        super(v, TDS);
    }

    @Override
    public String generate() {
        return ASMUtils.generateAttribute((TDS.entries.Attribute) this.v, this.localTDS);
    }

    @Override
    public String getType() {
        return v.get(Entry.TYPE);
    }
}
