package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by quentin on 02/04/2017.
 */
public class VarUninitializedException extends LoocException {

	public VarUninitializedException(String filename, Tree t, String message) {
		super(filename, t, message);
	}
}
