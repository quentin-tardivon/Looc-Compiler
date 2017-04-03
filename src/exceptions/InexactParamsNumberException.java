package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by quentin on 30/03/2017.
 */
public class InexactParamsNumberException extends LoocException {

	public InexactParamsNumberException(String filename, Tree t, String method) {
		super(filename, t, "The method " + method + " is called with a wrong number of parameters");
	}
}
