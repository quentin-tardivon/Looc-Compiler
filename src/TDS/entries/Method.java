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
		super("Method");
	}

	public Method(String returnType) {
		super("Method");
		this.info.put("returnType", returnType);

	}
}
