package ASMGenerator;

import TDS.SymbolTable;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class LoocClass implements Generable {

    private SymbolTable globalTDS;
    private SymbolTable classTDS;
    private String name;
    private int nbClass;

    public LoocClass(String name, SymbolTable tds, int nbClass) {
        this.globalTDS = tds;
        this.classTDS = tds.getClass(name);
        this.name = name;
        this.nbClass = nbClass;
    }

    @Override
    public String generate() {
        return ASMUtils.generateLoocClassDescriptor(this.name, this.classTDS, this.nbClass);
    }

}
