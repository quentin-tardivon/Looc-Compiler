package ASMGenerator.instructions;

import ASMGenerator.ASMUtils;
import ASMGenerator.ASMWriter;
import ASMGenerator.Block;
import ASMGenerator.Generable;
import ASMGenerator.expressions.binaries.Comparison;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class For implements Generable {

    private Block block;
    private Comparison cond;

    public For(Comparison c, Block b) {
        this.block = b;
        this.cond = c;
    }

    @Override
    public String generate() {
        return ASMUtils.generateFor();
    }
}
