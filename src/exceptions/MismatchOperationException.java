package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class MismatchOperationException extends LoocException {
	public MismatchOperationException(String filename, Tree node) {
		super(filename, node, "Cannot operate on these elements because of incompatible type");
	}
}
