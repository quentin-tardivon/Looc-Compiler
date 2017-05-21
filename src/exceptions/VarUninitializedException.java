package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class VarUninitializedException extends LoocException {

	public VarUninitializedException(String filename, Tree t, String message) {
		super(filename, t, "Variable '"+message+"' is uninitialized");
	}
}
