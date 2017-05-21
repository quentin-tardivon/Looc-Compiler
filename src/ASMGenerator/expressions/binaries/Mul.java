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
public class Mul extends Operation {

    public Mul(Expression left, Expression right) {
        super(left, right, ASMUtils.MUL, "*");
    }

}
