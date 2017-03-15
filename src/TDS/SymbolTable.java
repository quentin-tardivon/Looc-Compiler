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

    public Object getEntries(String s) {
        return this.entries.get(s);
    }

    public int getImbricationLevel(SymbolTable s){ return s.imbricationLevel;}

    public SymbolTable getFather(SymbolTable s){return s.father;}

    public void setFather( SymbolTable f){ this.father=f;}

    public void update_imbrication(){this.imbricationLevel=this.father.imbricationLevel++;}

    public String toString() {
        return this.entries.toString();
    }
}
