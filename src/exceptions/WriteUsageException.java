package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class WriteUsageException extends LoocException {
	public WriteUsageException(String filename, Tree t, String message) {
		super(filename, t, "Cannot use WRITE with a '"+message+"' type");
	}
}
