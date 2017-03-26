package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Throw this exception if a symbol is already declared in the current Symbol table !
 * TODO improve ....!
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class SymbolAlreadyDeclaredException extends LoocException {

	public SymbolAlreadyDeclaredException(String filename, Tree node, String doublonSymbol) {
		super(filename, node, "The symbol '" + doublonSymbol + "' is already declared in the current symbol table");
	}

/*	public SymbolAlreadyDeclaredException() {
		super("A symbol is already declared in the current symbol table");
	}*/
}
