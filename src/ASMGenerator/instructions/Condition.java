package ASMGenerator.instructions;

import ASMGenerator.Block;
import ASMGenerator.Generable;
import ASMGenerator.expressions.binaries.Comparison;


public class Condition implements Generable {

    private Comparison condition;
    private Block then;
    private Block otherwise;

    public Condition(Comparison c, Block then, Block otherwise) {
        this.condition = c;
        this.then = then;
        this.otherwise = otherwise;
    }

    @Override
    public String generate() {
        return null;
    }
}
