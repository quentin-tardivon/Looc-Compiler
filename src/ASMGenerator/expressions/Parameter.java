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
	private Expression expression;


	public Parameter(TDS.entries.Parameter p, Expression expression) {
		this.p = p;
		this.expression = expression;
	}

	@Override
	public String generate(){
		return ASMUtils.generateParameter(this.p, this.expression);
	}


	public String toString() {
		return this.p.getNameVariable();
	}

	@Override
	public String getType() {
		return this.p.get(Entry.TYPE);
	}
}
