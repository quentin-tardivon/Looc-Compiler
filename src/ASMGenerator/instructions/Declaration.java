package ASMGenerator.instructions;

import ASMGenerator.Generable;
import TDS.Entry;
import TDS.entries.Variable;

/**
 * Created by mcdostone on 29/04/17.
 */
public class Declaration implements Generable {

    private Variable variable;

    public Declaration(Variable v) {
        this.variable = v;
    }
    @Override
    public String generate() {
        if(this.variable.get(Entry.TYPE).equals("int"))
            return "// Declaration of int\n" +
                    "ADQ -INT_SIZE, SP\n";
        return "";
    }
}
