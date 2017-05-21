package ASMGenerator;

import ASMGenerator.expressions.Variable;
import TDS.SymbolTable;

/**
 * Created by mcdostone on 21/05/17.
 */
public class Receiver implements Generable {


    protected Variable v;
    protected SymbolTable localTDS;
    public Receiver(Variable v, SymbolTable localTDS) {
        this.v = v;
        this.localTDS = localTDS;
    }

    public Variable getVariable() {
        return this.v;
    }

    @Override
    public String generate() {
        return ASMUtils.generateReceiver(this.v, this.localTDS);
    }
}
