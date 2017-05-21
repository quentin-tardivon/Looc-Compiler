package ASMGenerator.expressions;

import ASMGenerator.ASMWriter;
import TDS.Entry;
import TDS.SymbolTable;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class LoocClassAffect extends Expression {

	private int nbClass;
	private String name;
	private SymbolTable classTDS;

	public LoocClassAffect(String name, int nbClass, SymbolTable tds) {
		this.nbClass = nbClass;
		this.name = name;
		this.classTDS = tds.getClass(name);
	}

	@Override
	public String generate() {
		String asm = ASMWriter.formatASM("\n\n//",  "Class affect for " + this.name, "") +
				ASMWriter.formatASM("", "LDW", "R0, SC") +
				ASMWriter.formatASM("", "STW",  "R0, -(ST)") +
				ASMWriter.formatASM("", "LDW", "R0, ST") +
				ASMWriter.formatASM("", "STW", "R0, -(SP)");

		for(String key: this.classTDS.getKeyEntries()) {
			if (this.classTDS.get(key).getName().equals(Entry.VARIABLE)) {
				asm += ASMWriter.formatASM("", "ADI", "ST, ST, #-2");
			}
		}

		return asm;
	}


	@Override
	public String getType() {
		return null;
	}
}
