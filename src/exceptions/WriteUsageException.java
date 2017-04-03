package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by quentin on 02/04/2017.
 */
public class WriteUsageException extends LoocException {
	public WriteUsageException(String filename, Tree t, String message) {
		super(filename, t, "Cannot use WRITE with a '"+message+"' type");
	}
}
