package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by tld on 30/03/2017.
 */
public class MethodNonVoidException extends LoocException {

    public MethodNonVoidException(String filename, Tree node, String method){
        super( filename,node,"Method '" + method +"'is non-void");
    }
}
