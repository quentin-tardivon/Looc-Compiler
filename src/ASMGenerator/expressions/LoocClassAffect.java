package ASMGenerator.expressions;

import ASMGenerator.ASMUtils;
import ASMGenerator.ASMWriter;
import TDS.Entry;
import TDS.SymbolTable;

/**
 * Created by quentin on 14/05/2017.
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
		return ASMUtils.generateLoocClassAffectation(this.name, this.classTDS, this.numClass);
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
