package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class InexactParamsNumberException extends LoocException {

	public InexactParamsNumberException(String filename, Tree t, String method) {
		super(filename, t, "The method '" + method + "' is called with a wrong number of parameters");
	}
}
