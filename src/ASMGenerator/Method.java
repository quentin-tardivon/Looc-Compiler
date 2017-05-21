package ASMGenerator;


import TDS.Entry;
import TDS.SymbolTable;
import TDS.entries.Parameter;
import TDS.entries.Variable;

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
        StringBuffer asm = new StringBuffer();
        asm.append(ASMUtils.formatASM("\n\n //Method " + tds.getFather().getName() + tds.getName(), "", ""));
	    asm.append(ASMUtils.formatASM("" + tds.getFather().getName() + tds.getName(), "NOP" , ""));
        asm.append(ASMUtils.stackStaticAndDynamic(""));
        for(Generable g: this.instructions) {
            asm.append(g.generate());
        }
		asm.append(ASMUtils.formatASM("", "LDW", "SP, BP")
				+ ASMUtils.formatASM("", "LDW", "BP, (SP)+"));
        asm.append(ASMUtils.formatASM("", "RTS", ""));

        return asm.toString();
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
