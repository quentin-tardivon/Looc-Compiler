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
		return ASMUtils.generateCallMethod(labelMethod, this.receiver.getVariableEntry(), this.params, this.tds, this.getType());
	}

	@Override
	public String getType() {
		String className= this.receiver.getVariableEntry().get(Entry.TYPE);
		SymbolTable classTDS = this.tds.getClass(className);
		return classTDS.get(this.nameMeth).get(Entry.RETURN_TYPE);
	}
}
