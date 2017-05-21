package ASMGenerator.expressions;

import core.Keywords;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public abstract class Binary extends Expression {

    protected Expression left;
    protected Expression right;
    protected String operatorSymbol;

    public Binary(Expression left, Expression right, String opSign) {
        this.left = left;
        this.right = right;
        this.operatorSymbol = opSign;
    }

    @Override
    public String generate() {
        StringBuffer asm = new StringBuffer();
        asm.append(this.left.generate());
        asm.append(this.right.generate());
        asm.append(this.generateOperation());
        return asm.toString();
    }

    @Override
    public String getType() {
        return Keywords.INTEGER;
    }

    public String toString() {
        return this.left.toString() + " " +  this.operatorSymbol + " " + this.right.toString();
    }

    public abstract String generateOperation();
}
