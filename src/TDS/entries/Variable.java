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

	private int depl;

	public Variable(String type) {
		super(Entry.VARIABLE);
		this.put(Entry.TYPE, type);
	}

	public Variable(String type,int depl) {
		super(Entry.VARIABLE);
		this.put(Entry.TYPE, type);
		this.depl=depl;
	}

	protected Variable(String name, String type) {
		super(name);
		this.put(Entry.TYPE, type);
	}

	public String toString() {
		return super.toString() + " Depl : " + this.depl;
	}

}


