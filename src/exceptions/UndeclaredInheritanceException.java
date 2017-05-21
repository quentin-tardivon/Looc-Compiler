package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class UndeclaredInheritanceException extends LoocException {

	public UndeclaredInheritanceException(String filename, Tree t, String message) {
		super(filename, t, "Cannot inherit from Class '"+message+"' because it has not been declared");
	}
}
