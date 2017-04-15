package TDS;

import java.util.HashMap;

/**
 * Amazing conception thanks to TRS students, Love U <3
 * All kinds of entries of the symbol table must inherit from this class
 *
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public abstract class Entry {

	public static final String TYPE = 			"Type";
	public static final String RETURN_TYPE = 	"ReturnType";
	public static final String CLASS = 			"Class";
	public static final String INHERIT = 		"Inherit";
	public static final String METHOD = 		"Method";
	public static final String PARAMETER = 		"Parameter";
	public static final String VARIABLE = 		"Variable";
	public static final String IF = 			"If";
	public static final String ELSE = 			"Else";
	public static final String FOR = 			"For";
	public static final String ANONYMOUS_BLOC = "Anonymous Block";
	public static final String NIL = 			"Nil";
	public static final String ORDER = 			"Order";

	private boolean init = true;

	protected final HashMap<String, String> info;
	protected final String name;

	public Entry(String name) {
		this.info = new HashMap<>();
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
		String s = String.format("%s,", this.name);

		for(String symbol: this.info.keySet()) {
			s += String.format(" %s: %s,", symbol, this.info.get(symbol));
		}
		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Entry entry = (Entry) o;
		return (info != null ? info.equals(entry.info) : entry.info == null) && (name != null ? name.equals(entry.name) : entry.name == null);
	}

	public boolean isInit() {
		return init;
	}

	public void setInit(boolean init) {
		this.init = init;
	}


}
