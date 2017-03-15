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
	}

	public Variable(String type) {
		super("Variable");
		this.info.put("type", type);
	}

}
