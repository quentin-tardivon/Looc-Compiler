package ASMGenerator.instructions;

import ASMGenerator.ASMUtils;
import ASMGenerator.Generable;
import TDS.entries.Variable;

/**
 * Created by tld on 14/05/2017.
 */
public class Read implements Generable{

    private Variable v;

    public Read(Variable v){
        this.v=v;
    }

    @Override
    public String generate() {
        return ASMUtils.generateRead(this.v.getDepl());
    }
}
