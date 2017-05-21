package exceptions;

import org.antlr.runtime.tree.Tree;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class MethodNonVoidException extends LoocException {

    public MethodNonVoidException(String filename, Tree node, String method){
        super( filename,node,"Method '" + method +"' is non-void");
    }
}
