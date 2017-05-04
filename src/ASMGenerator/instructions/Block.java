package ASMGenerator.instructions;

import ASMGenerator.ASMWriter;
import ASMGenerator.Generable;

/**
 * Created by mcdostone on 04/05/17.
 */
public class Block implements Generable {

    @Override
    public String generate() {
        return ASMWriter.formatASM("BLOCK", "EQU", "$");
    }
}
