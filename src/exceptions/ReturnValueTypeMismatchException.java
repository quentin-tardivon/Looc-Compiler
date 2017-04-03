package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by madmax on 29/03/2017.
 */
public class ReturnValueTypeMismatchException extends LoocException {

    public ReturnValueTypeMismatchException(String filename, Tree node, String expected, String real) {
        super(filename, node, "Return value type is: "+real+" expected: "+expected);
    }
}