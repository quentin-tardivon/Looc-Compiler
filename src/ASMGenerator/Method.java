package ASMGenerator;


import TDS.Entry;
import TDS.SymbolTable;
import TDS.entries.Parameter;
import TDS.entries.Variable;

public class Method extends Block implements Generable {

    private SymbolTable tds;

    public Method(SymbolTable tds) {
        this.tds = tds;
    }

    @Override
    public String generate() {
        return ASMUtils.generateMethod(this.tds, this.instructions);
    }

    private int countParameters() {
        int count = 0;
        for(String e: this.tds.getKeyEntries()) {
            Entry tmp = this.tds.get(e);
            count += tmp instanceof Variable && !(tmp instanceof Parameter) ? 1 : 0;
        }
        return count;
    }
}
