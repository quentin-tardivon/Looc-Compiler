package ASMGenerator;


import ASMGenerator.instructions.Return;
import TDS.SymbolTable;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class Method extends Block implements Generable {

    private SymbolTable tds;
    private boolean hasReturn;

    public Method(SymbolTable tds, boolean hasReturn) {
        this.tds = tds;
        this.hasReturn = hasReturn;
    }

    @Override
    public String generate() {
        if(!hasReturn)
            this.addInstruction(new Return());
        return ASMUtils.generateMethod(this.tds, this.instructions);
    }

}
