package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by madmax on 29/03/2017.
 */
public class ReturnValueTypeMismatchException extends Exception {

    public ReturnValueTypeMismatchException(String expected, String real) {
        super("Return value type is: "+real+" expected: "+expected);
    }
}