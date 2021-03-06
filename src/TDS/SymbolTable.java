package TDS;

import ASMGenerator.expressions.Variable;
import core.CommonTreeParser;
import exceptions.SymbolAlreadyDeclaredException;

import java.util.HashMap;
import java.util.Set;

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
    private final HashMap<String, Entry> entries;
	/** Imbrication level, root is 0 */
	private final int imbricationLevel;
	/** The parent Symbol Table */
    private final SymbolTable father;
	/** Links between symbol tables (used to access symbol table of a function for example) */
	private final HashMap<String, SymbolTable> links;
	/** Number of for statement in this block **/
	/*private  int numberFor = 0;
	/** Number of if statement in this block **/
	//private int numberIf = 0;
	/** Number of block statement statement in this block **/
	//private int numberBlock = 0;

//	private EnvironmentCounter counter = new EnvironmentCounter();
	private final String name;

	private HashMap<String, SymbolTable> classList;
	private static int blockID;


	/**
	 * Default constructor
	 */
	public SymbolTable() {
		this.entries = new HashMap<>();
		this.links = new HashMap<>();
		this.imbricationLevel = 0;
		this.father = null;
		this.name = "ROOT";
		this.classList = new HashMap<>();
	}

	/**
	 * @param imbricationLevel The final imbrication level
	 * @param father The final Symbol table parent
	 */
	public SymbolTable(int imbricationLevel, SymbolTable father, String name) {
        this.entries = new HashMap<>();
		this.links = new HashMap<>();
        this.imbricationLevel = imbricationLevel;
        this.father = father;
        this.name = name;
		this.classList = new HashMap<>();
    }

	/**
	 * Add a new entry to the symbol table
	 * @param symbol Uniq ID for this symbol table
	 * @param entry The entry corresponding to the symbol
	 * @return
	 */
	public Object put(String symbol, Entry entry) throws SymbolAlreadyDeclaredException {
        if(this.entries.containsKey(symbol)) {
	        throw new SymbolAlreadyDeclaredException(CommonTreeParser.filename,CommonTreeParser.node, symbol);
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
		/*	if (type.equals(Entry.FOR)) {
				numberFor += 1;
			}
			else {
				numberBlock +=1;
			}

*/
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
	 * @param idf key
	 * @return Returns the entries of the idf or throw an UndeclaredException
	 */
	public SymbolTable getLinkRecursive(String idf) {
		if (this.links.containsKey(idf))
			return this.links.get(idf);
		else {
			if (this.father != null)
				return this.father.getLinkRecursive(idf);
			else
				return null;
		}
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
	public Entry getInfo(String idf) {
		if (this.entries.containsKey(idf)) {
			return this.entries.get(idf);
		}
		else {
			if (this.father != null) {
				return this.father.getInfo(idf);
			} else {
				return null;
			}
		}
	}

	public boolean contains(Entry e) {
		return this.entries.containsValue(e);
	}

	public SymbolTable getSymbolTable(Entry entry) {
		if(this.entries.containsValue(entry))
			return this;
		else
			return (this.father != null ? this.father.getSymbolTable(entry) : null);
	}

	/**
	 * @return The symbol table parent of table
	 */
    public SymbolTable getFather(){return this.father;}

	public SymbolTable getFather(int nth){
    	if(this.father == null)
    		return null;
    	else {
    		if(nth <= 0)
    			return this;
    		else
    			return this.father.getFather(nth - 1);
    	}
	}

    public String getNameOfSymbolTable() {
		if(this.father != null) {
			for(String key: this.father.links.keySet()) {
				if(this.father.links.get(key).equals(this))
					return key;
			}
		}
		return null;
	}

	/**
	 *
	 * @return The number of for statement
	 */
/*	public int getNumberFor() {
		return numberFor;
	}
*/
	/**
	 *
	 * @return The number of if statement
	 */
/*	public int getNumberIf() {
		return numberIf;
	}*/

	/**
	 *
	 * @return The number of block
	 */
/*	public int getNumberBlock() {
		return numberBlock;
	}
*/

/*	public void setNumberIf(int numberIf) {
		this.numberIf = numberIf;
	}
*/
	public String getName() {
		return this.name;
	}

	public Set<String> getKeyEntries() {
		return this.entries.keySet();
	}


    public String toString() {
		String s;
		String prefix = " - ";
		String entry = this.getNameOfSymbolTable();
		if(entry != null && this.father.get(entry).getName().equals(Entry.METHOD)) {
			s = String.format(" Imbrication: %d\n", this.getImbricationLevel());
			prefix = "              - ";
		}
		else
			s = String.format("==== %s[%d] ====\n", this.name, this.getImbricationLevel());

		for(String symbol: this.entries.keySet()) {
	    	s += String.format("%s%-10s -> %s", prefix, symbol, this.entries.get(symbol));
	    	if((this.entries.get(symbol).getName().equals(Entry.METHOD)))
				s+= this.links.get(symbol).toString() + "\n";
	    	else
	    		s += "\n";
		}
	    for (String symbol: this.links.keySet()) {
	    	if(!this.entries.get(symbol).getName().equals(Entry.METHOD))
		    	s += String.format("%s%-10s -> %s", prefix, symbol, this.links.get(symbol));
	    }
	    for(String cls: this.classList.keySet()) {
			s += "\n\n" + this.classList.get(cls).toString() + "\n\n";
		}
    	return s;
    }

	public SymbolTable findClass(String name) {
		SymbolTable res = null;
		if (classList.containsKey(name))
			return classList.get(name);
		else {
			for(String key: classList.keySet()) {
				res = classList.get(key).findClass(name);
			}
		}
		return res;
	}

	public SymbolTable putClass(String symbol, SymbolTable tds) {  return this.classList.put(symbol, tds);  }

	public SymbolTable getClass(String symbol) {
		return this.classList.get(symbol);
	}

}
