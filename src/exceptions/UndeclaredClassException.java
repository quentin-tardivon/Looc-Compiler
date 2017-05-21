package exceptions;


import org.antlr.runtime.tree.Tree;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class UndeclaredClassException extends LoocException {

    public UndeclaredClassException(String filename, Tree t, String idf) {
        super(filename, t, "Class '" + idf + "' is not declared");
    }
}
