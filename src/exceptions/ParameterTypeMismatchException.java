package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class ParameterTypeMismatchException extends LoocException {

    public ParameterTypeMismatchException(String filename, Tree node, String type1 , String type2, String idf1) {
        super(filename, node, "Parameter " + idf1 + " is '" + type1 + "' but '" + type2 +"' is expected"  );
    }
}
