package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by tld on 30/03/2017.
 */
public class InexactDoCallException extends LoocException {

    public InexactDoCallException(String filename, Tree node, String call){ super( filename,node,"Cannot call '" + call +"'after DO");}

}
