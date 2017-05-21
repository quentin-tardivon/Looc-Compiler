package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class ReadUsageException extends LoocException {

	public ReadUsageException(String filename, Tree t, String message) {
		super(filename, t, "Cannot use READ with a '"+message+"' type");
	}
}
