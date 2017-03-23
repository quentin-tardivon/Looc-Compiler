package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * All exceptions of the LOOC compiler,
 * should herit from this class
 * To be clear about errors, the constructor of this class
 * takes the current node of the tree in order to access to the line number and the position.
 *
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public abstract class LoocException extends Exception {
    
    public LoocException(Tree t) {
        super();
    }

}
