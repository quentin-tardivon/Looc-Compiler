package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by tld on 22/03/2017.
 */
public class UnknownNodeTypeException extends LoocException {

    public UnknownNodeTypeException(String filename, Tree t, String idf) {
            super(filename, t, "Type unknown '" + idf+ "'");
    }

}
