package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by tld on 02/04/2017.
 */
public class InheritanceTypeMismatchException extends LoocException {

    public InheritanceTypeMismatchException (String filename, Tree node, String rightNode,String leftNode){
        super( filename,node,"Cannot assign " + leftNode +"to" +rightNode);
    }


}