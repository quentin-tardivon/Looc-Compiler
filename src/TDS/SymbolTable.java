package TDS;

import exceptions.*;

import java.util.HashMap;

/** A symbol table is described by a Hashmap.
 *  A symbol table associate to a symbol (String) a entry.
 *
 *      "a"             -> Entry
 *      "constructor    -> Entry
 *      ...
 *
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class SymbolTable {

	/**
	 * An entry can be a function, variable, anonymous bloc
	 */
    private HashMap<String, Entry> entries;
	/** Imbrication level, root is 0 */
	private final int imbricationLevel;
	/** The parent Symbol Table */
    private final SymbolTable father;
	/** Links between symbol tables (used to access symbol table of a function for example) */
	private HashMap<String, SymbolTable> links;
	/** Number of for statement in this block **/
	private int numberFor = 0;
	/** Number of if statement in this block **/
	private int numberIf = 0;
	/** Number of block statement statement in this block **/
	private int numberBlock = 0;
	private String name;

	/**
	 * Default constructor
	 */
	public SymbolTable() {
		this.entries = new HashMap<String, Entry>();
		this.links = new HashMap<String, SymbolTable>();
		this.imbricationLevel = 0;
		this.father = null;
		this.name = "ROOT";
	}

	/**
	 * @param imbricationLevel The final imbrication level
	 * @param father The final Symbol table parent
	 */
	public SymbolTable(int imbricationLevel, SymbolTable father, String name) {
        this.entries = new HashMap<String, Entry>();
		this.links = new HashMap<String, SymbolTable>();
        this.imbricationLevel = imbricationLevel;
        this.father = father;
        this.name = name;
    }

	/**
	 * Add a new entry to the symbol table
	 * @param symbol Uniq ID for this symbol table
	 * @param entry The entry corresponding to the symbol
	 * @return
	 */
	public Object put(String symbol, Entry entry) throws SymbolAlreadyDeclaredException {
        if(this.entries.containsKey(symbol)) {
	        throw new SymbolAlreadyDeclaredException("",null, symbol);
	    }
        else {
	        return this.entries.put(symbol, entry);
        }
	}

	/**
	 * Add a new entry to the symbol table (For Statement and Anonymous Block)
	 * @param symbol Uniq ID for this symbol table
	 * @param entry The entry corresponding to the symbol
	 * @param type type of entry added
	 * @return
	 * @throws SymbolAlreadyDeclaredException
	 */
	public Object put(String symbol, Entry entry, String type) throws SymbolAlreadyDeclaredException {
		if(this.entries.containsKey(symbol)) {
			throw new SymbolAlreadyDeclaredException("", null, symbol);
		}
		else {
			if (type == "For") {
				numberFor += 1;
			}
			else {
				numberBlock +=1;
			}


			return this.entries.put(symbol, entry);
		}
	}

	/**
	 * @param symbol
	 * @param tds Table symbol to link
	 * @return The added table symbol
	 */
	public SymbolTable putLink(String symbol, SymbolTable tds) {  return this.links.put(symbol, tds);  }

	/**
	 * @param symbol
	 * @return tds
	 */
	public SymbolTable getLink(String symbol) {
		return this.links.get(symbol);
	}

	/**
	 * @param s Symbol to find
	 * @return Entry associated to the given symbol
	 */
    public Entry get(String s) {
        return this.entries.get(s);
    }

	/**
	 * @return The imbrication level of this Symbol table
	 */
	public int getImbricationLevel(){  return this.imbricationLevel;  }


	/**
	 * @param idf key
	 * @return Returns the entries of the idf or throw an UndeclaredException
	 */
	public Entry getInfo(String idf) throws Exception {

		if (this.entries.containsKey(idf)) {
			return this.entries.get(idf);
		}
		else {
			//System.out.println(this.toString());

			//System.out.println(this.father.toString());

			if (this.father != null) {
				//System.out.println(this.father.getInfo(idf).toString());
				return this.father.getInfo(idf);
			} else {
				//System.out.println("idf : " + idf + " entries : " + this.entries.get(idf));
				return null;
			}
		}
	}

	/**
	 * @return The symbol table parent of table
	 */
    public SymbolTable getFather(){return this.father;}

	/**
	 *
	 * @return The number of for statement
	 */
	public int getNumberFor() {
		return numberFor;
	}

	/**
	 *
	 * @return The number of if statement
	 */
	public int getNumberIf() {
		return numberIf;
	}

	/**
	 *
	 * @return The number of block
	 */
	public int getNumberBlock() {
		return numberBlock;
	}

	/**
	 *
	 * @param numberIf
	 */
	public void setNumberIf(int numberIf) {
		this.numberIf = numberIf;
	}

	public String getName() {
		return this.name;
	}


    public String toString() {
	    String s = String.format("==== %d ====\n", this.getImbricationLevel());
	    for(String symbol: this.entries.keySet()) {
	    	s += String.format(" - %-10s -> %s\n", symbol, this.entries.get(symbol));
	    }
	    for (String symbol: this.links.keySet()) {
		    s += String.format(" - %-10s -> %s\n", symbol, this.links.get(symbol));
	    }
    	return s;
    }
}
