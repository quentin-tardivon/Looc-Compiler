package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class UndeclaredVariableException extends LoocException {

    public UndeclaredVariableException(String filename, Tree t, String idf) {
        super(filename, t, "Variable '" + idf + "' is not declared");
    }

}
