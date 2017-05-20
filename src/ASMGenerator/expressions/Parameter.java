package ASMGenerator.expressions;

import ASMGenerator.ASMUtils;
import TDS.Entry;
import TDS.SymbolTable;

/**
 * Created by quentin on 20/05/2017.
 */
public class Parameter extends Expression {

	private TDS.entries.Parameter p;
	private SymbolTable localTDS;

	public Parameter (TDS.entries.Parameter p, SymbolTable TDS) {
		this.p = p;
		this.localTDS = TDS;
	}

	@Override
	public String generate(){
		if(this.localTDS.contains(this.p))
			return ASMUtils.generateParameter(this.p, this.localTDS);
		else
			return ASMUtils.generateParameterStaticLink(this.localTDS.getImbricationLevel(), this.localTDS.getSymbolTable(this.p).getImbricationLevel(), this.p.getDepl());
	}

	public TDS.entries.Parameter getParameterEntry() {
		return this.p;
	}

	public String toString() {
		return this.p.getNameVariable();
	}

	@Override
	public String getType() {
		return this.p.get(Entry.TYPE);
	}
}
