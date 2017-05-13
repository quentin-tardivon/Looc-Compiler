package ASMGenerator.instructions;

import ASMGenerator.ASMUtils;
import ASMGenerator.Generable;
import TDS.entries.Variable;


public class Return implements Generable {

    private Variable v;
    public Return(Variable v) {
        this.v = v;
    }

    @Override
    public String generate() {
        return ASMUtils.generateReturn(this.v.getDepl());
    }
}
