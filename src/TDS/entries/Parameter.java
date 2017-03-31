package TDS.entries;

import TDS.Entry;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class Parameter extends Variable {

	public Parameter(String type) {
		super(Entry.PARAMETER, type);
	}

}