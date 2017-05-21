package ASMGenerator.expressions;

import ASMGenerator.ASMUtils;
import TDS.Entry;
import TDS.SymbolTable;

import java.util.ArrayList;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class MethodCall extends Expression {
	private String nameMeth;
	private SymbolTable tds;
	private Variable receiver;
	private ArrayList<Parameter> params;


	public MethodCall(Variable receiver, String nameMeth, SymbolTable tds, ArrayList<Parameter> p) {
		this.nameMeth = nameMeth;
		this.receiver = receiver;
		this.tds = tds;
		this.params = p;
	}

	@Override
	public String generate() {
		String labelMethod = this.receiver.getVariableEntry().get(Entry.TYPE) + this.nameMeth;
		return ASMUtils.generateCallMethod(labelMethod, this.receiver.getVariableEntry(), this.params, this.tds);
	}

	@Override
	public String getType() {
		return null;
	}
}
