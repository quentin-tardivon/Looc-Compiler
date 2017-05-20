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

	protected int depl;
	protected String nameVariable;

	public Variable(String type, String nameVariable) {
		super(Entry.VARIABLE);
		this.put(Entry.TYPE, type);
		this.nameVariable = nameVariable;
	}

	public Variable(String type,int depl, String nameVariable) {
		super(Entry.VARIABLE);
		this.put(Entry.TYPE, type);
		this.depl=depl;
		this.nameVariable = nameVariable;
	}

	protected Variable(String entryType, String type, int depl, String nameVariable) {
		super(entryType);
		this.put(Entry.TYPE, type);
		this.depl = depl;
		this.nameVariable = nameVariable;
	}

	public int getDepl(){
		return this.depl;
	}

	public String getNameVariable() {
		return this.nameVariable;
	}

	public String toString() {
		return super.toString() + " Depl : " + this.depl;
	}

}


