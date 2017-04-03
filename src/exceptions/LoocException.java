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
public class LoocException extends Exception {


    public LoocException(String filename, Tree t, String message) {
        super(LoocException.prefixException(filename, t) + message);
    }

    public LoocException(String filename, Tree t) {
        super(LoocException.prefixException(filename, t) + "###### UNKNOWN ERROR");
    }

    private static String prefixException(String filename, Tree t) {
        if(t == null && filename == null)
            return "Error: ";
        if(t != null && filename == null)
            return String.format("%d: error: ", t.getLine());
        if(t == null && filename != null)
            return String.format("%s: error: ", filename);
        else
            return String.format("%s:%d: error: ", filename, t.getLine());
    }

}
