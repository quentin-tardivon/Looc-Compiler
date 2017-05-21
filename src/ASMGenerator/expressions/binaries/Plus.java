package ASMGenerator.expressions.binaries;

import ASMGenerator.ASMUtils;
import ASMGenerator.expressions.Binary;
import ASMGenerator.expressions.Expression;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class Plus extends Operation {

    public Plus(Expression left, Expression right) {
        super(left, right, ASMUtils.ADD, "+");
    }

}
