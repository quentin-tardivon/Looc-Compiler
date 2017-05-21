package ASMGenerator.expressions.binaries;

import ASMGenerator.ASMUtils;
import ASMGenerator.expressions.Expression;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class NotEqual extends Comparison {

    public NotEqual(Expression left, Expression right) {
        super(left, right, ASMUtils.NE, "!=");
    }

}
