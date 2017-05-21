package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class StringOperationException extends LoocException {

    public StringOperationException(String filename, Tree node){
        super(filename, node,"Cannot operate on strings ");
    }
    
}
