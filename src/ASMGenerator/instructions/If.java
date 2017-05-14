package ASMGenerator.instructions;

import ASMGenerator.ASMUtils;
import ASMGenerator.Block;
import ASMGenerator.Generable;
import ASMGenerator.expressions.binaries.Comparison;


public class If implements Generable {

    private Comparison c;
    private Block then;
    private Block elseBlock;

    public If(Comparison c, Block b, Block elseBlock) {
        this.c = c;
        this.then = b;
        this.elseBlock = b;
    }
    @Override
    public String generate() {
        return ASMUtils.generateIf(this.c, this.then, this.elseBlock);
    }
}
