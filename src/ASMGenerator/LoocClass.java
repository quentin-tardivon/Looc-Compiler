package ASMGenerator;

import TDS.Entry;
import TDS.SymbolTable;
import org.antlr.runtime.tree.Tree;


public class LoocClass implements Generable {

    private SymbolTable globalTDS;
    private SymbolTable classTDS;

    private Tree tree;

    public LoocClass(Tree tree, SymbolTable tds) {
        this.tree = tree;
        this.globalTDS = tds;
        this.classTDS = tds.getClass(tree.getChild(0).getText());
    }

    @Override
    public String generate() {
        int size = 0;
        int nbMethods = 0;
        for(String key: this.classTDS.getKeyEntries()) {
            size += sizeof(this.classTDS.get(key));
            nbMethods += this.classTDS.get(key).getName().equals(Entry.METHOD) ? 1 : 0;
        }

        String asm =  ASMWriter.formatASM("\n\n//",  "Setup class descriptor for " + tree.getChild(0).getText(), "") +
                ASMWriter.formatASM("", "LDW", "R0, #" + size) +
                ASMWriter.formatASM("", "STW",  "R0, -(SC)", "// sizeof(" + tree.getChild(0) + ") = " + size) +
                ASMWriter.formatASM("", "LDW", "R0, #" + nbMethods) +
                ASMWriter.formatASM("", "STW",  "R0, -(SC)", "// count methods of " + tree.getChild(0) + " = " + nbMethods);

        for(int i = 1; i <= nbMethods; i++) {
//            Tree t  = this.tree.getChild()
        }

        return asm;
    }


    private int sizeof(Entry e) {
        switch(e.getName()) {
            case Entry.VARIABLE:
                switch(e.get(Entry.TYPE)) {
                    case "int":
                        return ASMWriter.INT_SIZE;
                    default:
                        return 0;
                }
            default:
                return 0;
        }
    }
}
