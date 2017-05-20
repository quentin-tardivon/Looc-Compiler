package ASMGenerator.instructions;

import ASMGenerator.ASMUtils;
import ASMGenerator.Generable;
import ASMGenerator.expressions.Variable;
import TDS.SymbolTable;
import TDS.entries.Parameter;


public class EffectiveParam extends Variable implements Generable {

    public EffectiveParam(Parameter p, SymbolTable tds) {
        super(p, tds);
    }

    @Override
    public String generate() {
        return ASMUtils.generateEffectiveParam((Parameter) this.v);
    }

}
