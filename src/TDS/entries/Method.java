package TDS.entries;

import TDS.Entry;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class Method extends Entry {

	public Method() {
		super(Entry.METHOD);
	}

	public Method(String returnType) {
		super(Entry.METHOD);
		this.info.put(Entry.RETURN_TYPE, returnType);
	}
}