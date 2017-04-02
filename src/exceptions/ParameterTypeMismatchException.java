package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by madmax on 02/04/2017.
 */

public class ParameterTypeMismatchException extends LoocException {

    public ParameterTypeMismatchException(String filename, Tree node, String type1 , String type2, String idf1) {
        super(filename, node, "Parameter '" + idf1 + " is " + type1 + " but it should be " + type2  );
    }
}
