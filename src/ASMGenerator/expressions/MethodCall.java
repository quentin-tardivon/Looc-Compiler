package ASMGenerator.expressions;

import ASMGenerator.ASMUtils;
import TDS.Entry;
import TDS.SymbolTable;
import TDS.entries.*;

/**
 * Created by quentin on 14/05/2017.
 */
public class MethodCall extends Expression{
	public static final int OFFSET_ENV = 4;
	String nameMeth;
	SymbolTable tds;
	String nameCaller;

	public MethodCall(String nameMeth, SymbolTable tds, String nameCaller) {
		this.tds = tds;
		this.nameMeth = nameMeth;
		this.nameCaller = nameCaller;
	}

	@Override
	public String generate() {
		return ASMUtils.formatASM("", "LDW", "R0, #-" + ((TDS.entries.Variable) this.tds.get(this.nameCaller)).getDepl() + OFFSET_ENV)
				+ ASMUtils.formatASM("", "STW", "R0, -(SP)") //TODO finir d'empiler l'env là
				+ ASMUtils.formatASM("", "JSR", "@"+this.tds.getInfo(this.nameCaller).get(Entry.TYPE) + this.nameMeth)
				+ ASMUtils.formatASM("", "ADI", "SP, SP, #2");
	}
}
