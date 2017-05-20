package ASMGenerator.instructions;

import ASMGenerator.ASMUtils;
import ASMGenerator.Generable;
import ASMGenerator.expressions.Variable;
import TDS.SymbolTable;

/**
 * Created by tld on 14/05/2017.
 */
public class Read implements Generable{

    private Variable v;
    private SymbolTable TDS;
    public Read(Variable variable, SymbolTable TDS) {
        this.v = variable;
        this.TDS = TDS;
    }

    @Override
    public String generate() {
        return ASMUtils.generateRead(this.v.getVariableEntry(), this.TDS);
    }
}
