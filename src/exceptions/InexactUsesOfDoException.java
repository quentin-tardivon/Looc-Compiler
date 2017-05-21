package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class InexactUsesOfDoException extends LoocException {

    public InexactUsesOfDoException(String filename, Tree node, String call){ super( filename,node,"Only a void method is expected after DO");}


}
