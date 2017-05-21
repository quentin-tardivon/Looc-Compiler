package ASMGenerator.instructions;

import ASMGenerator.ASMUtils;
import ASMGenerator.Block;
import ASMGenerator.Generable;
import ASMGenerator.Receiver;
import ASMGenerator.expressions.ConstantInteger;
import ASMGenerator.expressions.binaries.Plus;
import TDS.SymbolTable;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class For implements Generable {

    private Block block;
    private ConditionFor cond;
    private Affectation a;

    public For(ConditionFor cond, Block b, SymbolTable tds) {
        this.block = b;
        this.cond = cond;
        this.a = new Affectation(new Receiver(this.cond.getVariable(), tds), tds, new Plus(this.cond.getVariable(), new ConstantInteger(1)));
    }

    @Override
    public String generate() {
        return ASMUtils.generateFor(this.cond, this.block, this.a);
    }
}
