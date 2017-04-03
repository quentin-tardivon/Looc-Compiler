package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by quentin on 02/04/2017.
 */
public class ReadUsageException extends LoocException {

	public ReadUsageException(String filename, Tree t, String message) {
		super(filename, t, "Cannot use READ with a '"+message+"' type");
	}
}
