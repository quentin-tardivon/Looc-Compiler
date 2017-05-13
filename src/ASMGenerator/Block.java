package ASMGenerator;

import java.util.ArrayList;
import java.util.List;

public class Block implements Generable {

    protected ArrayList<Generable> instructions;

    public Block() {
        this.instructions = new ArrayList<Generable>();
    }

    public void addInstruction(Generable g) {
        this.instructions.add(g);
    }

    public void addAllInstructions(List<Generable> l) {
        this.instructions.addAll(l);
    }

    @Override
    public String generate() {
        StringBuffer asm = new StringBuffer();
        asm.append(ASMUtils.stackStaticAndDynamic());
        for(Generable g: this.instructions) {
            asm.append(g.generate());
        }

        return asm.toString();
    }

}
