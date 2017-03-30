package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by quentin on 30/03/2017.
 */
public class UndeclaredInheritanceException extends LoocException {

	public UndeclaredInheritanceException(String filename, Tree t, String message) {
		super(filename, t, message);
	}
}
