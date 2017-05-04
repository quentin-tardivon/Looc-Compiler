package ASMGenerator.instructions;

import ASMGenerator.ASMWriter;
import ASMGenerator.Generable;

/**
 * Created by mcdostone on 04/05/17.
 */
public class Condition implements Generable {

    public Condition() {}

    @Override
    public String generate() {
        return ASMWriter.formatASM("", "CMP", "R0, R0") +
            ASMWriter.formatASM("", "BNE", "LOOP - ($ + 2)");
    }
}
