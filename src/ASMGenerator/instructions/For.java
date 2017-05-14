package ASMGenerator.instructions;

import ASMGenerator.ASMUtils;
import ASMGenerator.ASMWriter;
import ASMGenerator.Block;
import ASMGenerator.Generable;
import ASMGenerator.expressions.Variable;
import ASMGenerator.expressions.binaries.Comparison;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class For implements Generable {

    private Block block;
    private ConditionFor cond;

    public For(ConditionFor cond,  Block b) {
        this.block = b;
        this.cond = cond;
    }

    @Override
    public String generate() {
        return ASMUtils.generateFor(this.cond, this.block);
    }
}
