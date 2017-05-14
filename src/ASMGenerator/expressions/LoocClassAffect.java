package ASMGenerator.expressions;

import ASMGenerator.ASMUtils;
import ASMGenerator.ASMWriter;
import TDS.Entry;

/**
 * Created by quentin on 14/05/2017.
 */
public class LoocClassAffect extends Expression {
	public static final int OFFSET_ENV = 2;

	private int nbClass;
	private String name;

	public LoocClassAffect(String name, int nbClass) {
		this.nbClass = nbClass;
		this.name = name;
	}

	@Override
	public String generate() {
		String asm = ASMWriter.formatASM("\n\n//",  "Class affect for " + this.name, "") +
				ASMWriter.formatASM("", "LDW", "R0, SC") +
				ASMWriter.formatASM("", "STW",  "R0, -(ST)") +
				ASMWriter.formatASM("", "LDW", "R0, ST") +
				ASMWriter.formatASM("", "STW", "R0, -(SP)");

		return asm;
	}
}
