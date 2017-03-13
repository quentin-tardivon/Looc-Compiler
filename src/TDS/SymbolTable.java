package TDS;

import java.util.HashMap;

/** Table of symbols
 *
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class SymbolTable {

    private HashMap<String, Object> entries;
    private int imbricationLevel;
    private SymbolTable father;

    public SymbolTable() {
        this.entries = new HashMap<String, Object>();
        this.imbricationLevel = 0;
        this.father = null;
    }

    public Object put(String symbol, Object o) {
        return this.entries.put(symbol, o);
    }

    public Object get(String s) {
        return this.entries.get(s);
    }

    public String toString() {
        return this.entries.toString();
    }
}
