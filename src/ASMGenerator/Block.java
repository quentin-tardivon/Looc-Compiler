package ASMGenerator;

import ASMGenerator.instructions.Declaration;

import java.util.ArrayList;
import java.util.List;

public class Block implements Generable {

    protected ArrayList<Generable> instructions;
    protected int countVariables;

    public Block() {
        this.instructions = new ArrayList<Generable>();
    }

    public void addInstruction(Generable g) {
        countVariables += (g instanceof Declaration) ? 1 : 0;
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
        asm.append(ASMUtils.unstackEnvironment());
        return asm.toString();
    }

}
