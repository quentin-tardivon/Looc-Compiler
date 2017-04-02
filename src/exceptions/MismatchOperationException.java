package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by quentin on 29/03/2017.
 */
public class MismatchOperationException extends LoocException {
	public MismatchOperationException(String filename, Tree node) {
		super(filename, node, "Cannot operate these elements");
	}
}
