package TDS.entries;

import TDS.Entry;

/**
 * All information about a variable in the symbol table.
 *
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class Variable extends Entry {


	public Variable() {
		super("Variable");
		System.out.println("DEPRECATED Variable constructor: TDS/entries/Variable.java");
	}

	public Variable(String type) {
		super("Variable");
		this.put("type", type);
	}

	protected Variable(String name, String type) {
		super(name);
		this.put("type", type);
	}
}
