package ASMGenerator.instructions;

import ASMGenerator.ASMWriter;
import ASMGenerator.Block;
import ASMGenerator.Generable;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class For implements Generable {

    private Block block;
    private Condition cond;

    public For(Condition c, Block b) {
        this.block = b;
        this.cond = c;
    }

    @Override
    public String generate() {
        String labelFor = "LOOP";
        return ASMWriter.formatASM(labelFor, "EQU", "$") +
                this.block.generate() +
                this.cond.generate();

    }
}
