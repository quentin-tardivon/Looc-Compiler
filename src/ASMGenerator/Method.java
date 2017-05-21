package ASMGenerator;


import TDS.SymbolTable;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class Method extends Block implements Generable {

    private SymbolTable tds;

    public Method(SymbolTable tds) {
        this.tds = tds;
    }

    @Override
    public String generate() {
        return ASMUtils.generateMethod(this.tds, this.instructions);
    }

}
