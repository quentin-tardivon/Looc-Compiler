package ASMGenerator.expressions;

import ASMGenerator.Generable;
import TDS.SymbolTable;

/**
 * Created by mcdostone on 20/05/17.
 */
public class Attribute extends Variable implements Generable {

    public Attribute (TDS.entries.Attribute v, SymbolTable TDS) {
        super(v, TDS);
    }

    @Override
    public String generate() {
        //return ASMUtils.generateAttribute();
        return null;
    }

    @Override
    public String getType() {
        return null;
    }
}
