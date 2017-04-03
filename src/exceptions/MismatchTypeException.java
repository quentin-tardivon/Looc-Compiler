package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by tld on 22/03/2017.
 */
public class MismatchTypeException extends LoocException {


    public MismatchTypeException(String filename, Tree node, String type1 , String type2, String idf1) {
        super(filename, node, "Cannot assign '" + idf1 + " : " + type1 + "' to " + type2  );
    }

}
