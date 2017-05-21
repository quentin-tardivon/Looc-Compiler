package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class UndeclaredMethodException extends LoocException {

    public UndeclaredMethodException(String filename, Tree t, String idf) {
        super(filename, t, "Method '" + idf + "' is not declared");
    }
}

