package ASMGenerator;

import TDS.Entry;
import TDS.SymbolTable;


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
        int size = 0;
        int nbMethods = 0;
        for(String key: this.classTDS.getKeyEntries()) {
            size += ASMUtils.sizeof(this.classTDS.get(key));
            nbMethods += this.classTDS.get(key).getName().equals(Entry.METHOD) ? 1 : 0;
        }

        String asm =  ASMWriter.formatASM("\n\n//",  "Setup class descriptor for " + this.name, "") +
                ASMWriter.formatASM("", "LDW", "R0, #" + size) +
                ASMWriter.formatASM("", "STW",  "R0, (SC)"+ this.nbClass, "// sizeof(" + this.name + ") = " + size) +
                ASMWriter.formatASM("", "LDW", "R0, #" + nbMethods) +
                ASMWriter.formatASM("", "STW",  "R0, (SC)"+ (this.nbClass + 2), "// count methods of " + this.name + " = " + nbMethods); //TODO change 2

        for(int i = 1; i <= nbMethods; i++) {
//            Tree t  = this.tree.getChild()
        }

        return asm;
    }

}
