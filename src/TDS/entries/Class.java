package TDS.entries;

import TDS.Entry;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class Class extends Entry {

	public Class(String name) {
		super(Entry.CLASS);
	}

	public Class(String name, String inherit) {
		super(Entry.CLASS);
		this.put(Entry.INHERIT, inherit);
	}
}
