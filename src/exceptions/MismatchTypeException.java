package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class MismatchTypeException extends LoocException {


    public MismatchTypeException(String filename, Tree node, String type1 , String type2, String idf1) {
        super(filename, node, "Cannot assign a '" + type1 + "' to a '" + type2 +"'"  );
    }

}
