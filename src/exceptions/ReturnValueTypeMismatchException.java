package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class ReturnValueTypeMismatchException extends LoocException {

    public ReturnValueTypeMismatchException(String filename, Tree node, String expected, String real) {
        super(filename, node, "Return value type is '"+real+"' expected '"+expected+"'");
    }
}