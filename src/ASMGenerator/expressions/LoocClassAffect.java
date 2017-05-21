package ASMGenerator.expressions;

import ASMGenerator.ASMUtils;
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

	private int numClass;
	private String name;
	private SymbolTable classTDS;

	public LoocClassAffect(String name, int num, SymbolTable tds) {
		this.numClass = num;
		this.name = name;
		this.classTDS = tds.getClass(name);
	}

	@Override
	public String generate() {
		return ASMUtils.generateLoocClassAffectation(this.classTDS, this.numClass);
	}

	@Override
	public String getType() {
		return this.name;
	}

	@Override
	public String toString() {
		return "new "+ this.name;
	}
}
