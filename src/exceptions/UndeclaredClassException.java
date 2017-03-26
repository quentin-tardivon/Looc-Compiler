package exceptions;


import org.antlr.runtime.tree.Tree;

/**
 * Created by madmax on 23/03/2017.
 */
public class UndeclaredClassException extends LoocException {

    public UndeclaredClassException(String filename, Tree t, String idf) {
        super(filename, t, "The class '" + idf + "' is not declared");
    }
}
