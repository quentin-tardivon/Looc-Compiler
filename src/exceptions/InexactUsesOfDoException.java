package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * Created by tld on 02/04/2017.
 */
public class InexactUsesOfDoException extends LoocException {

    public InexactUsesOfDoException(String filename, Tree node, String call){ super( filename,node,"Only a void method is expected after DO");}


}
