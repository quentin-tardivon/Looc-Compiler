package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by madmax on 23/03/2017.
 */
public class UndeclaredMethodException extends LoocException {

    public UndeclaredMethodException(String filename, Tree t, String idf) {
        super(filename, t, "The method '" + idf + "' is not declared");
    }
}

