package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by tld on 23/03/2017.
 */
public class StringOperationException extends LoocException {

    public StringOperationException(String filename, Tree node){
        super(filename, node,"Cannot operate on strings ");
    }
    
}
