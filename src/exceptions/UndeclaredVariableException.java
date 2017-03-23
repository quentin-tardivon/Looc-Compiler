package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by tld on 22/03/2017.
 */
public class UndeclaredVariableException extends LoocException {

    public UndeclaredVariableException(String filename, Tree t, String idf) {
        super(filename, t, "The variable '" + idf + "' is not declared");
    }

}
