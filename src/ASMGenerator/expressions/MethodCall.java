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
	private String className;


	public MethodCall(Variable receiver, String nameMeth, SymbolTable tds, ArrayList<Parameter> p, String className) {
		this.nameMeth = nameMeth;
		this.receiver = receiver;
		this.tds = tds;
		this.params = p;
		this.className = className;
	}

	@Override
	public String generate() {
		if (receiver != null) {
			return ASMUtils.generateCallMethod(this.className + this.nameMeth, this.receiver.getVariableEntry(), this.params, this.tds, this.getType());
		}
		else {
			return ASMUtils.generateCallMethod(this.className + this.nameMeth, null, this.params, this.tds, this.getType());
		}

	}

	@Override
	public String getType() {
		if (this.receiver == null) {
			return this.tds.getFather(this.tds.getImbricationLevel() - 1).get(this.nameMeth).get(Entry.RETURN_TYPE);
			//return this.tds.getFather().get(this.nameMeth).get(Entry.RETURN_TYPE);
		}
		else {
			SymbolTable classTDS = this.tds.getClass(this.className);
			return classTDS.get(this.nameMeth).get(Entry.RETURN_TYPE);
		}

	}
}
