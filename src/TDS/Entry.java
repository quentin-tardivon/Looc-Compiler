package TDS;

import java.util.HashMap;

/**
 * Amazing conception thanks to TRS students, Love U <3
 * All kinds of entries of the symbol table must herit from this class
 *
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public abstract class Entry {

	protected HashMap<String, String> info;
	protected String name;

	public Entry(String name) {
		this.info = new HashMap<String, String>();
		this.name = name;
	}

	public String put(String k, String v) {
		return this.info.put(k,v);
	}

	public String get(String k) {
		return this.info.get(k);
	}

	public String getName() {  return this.name; }

	public String toString() {
		String s = String.format("### %s ###\n", this.name);
		for(String symbol: this.info.keySet()) {
			s += String.format(" - %-10s -> %s\n", symbol, this.info.get(symbol));
		}
		return s;
	}

}
