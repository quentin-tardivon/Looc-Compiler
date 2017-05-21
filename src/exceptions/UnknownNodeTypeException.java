package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class UnknownNodeTypeException extends LoocException {

    public UnknownNodeTypeException(String filename, Tree t, String idf) {
            super(filename, t, "Type unknown '" + idf+ "'");
    }

}
