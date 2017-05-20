package TDS.entries;

import TDS.Entry;
import core.Keywords;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class Parameter extends Variable {

	public Parameter(String type, int depl, String nameParameter) {
		super(Entry.PARAMETER, type, depl, nameParameter);
	}

}