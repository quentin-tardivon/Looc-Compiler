package ASMGenerator.expressions;

/**
 * Created by mcdostone on 13/05/17.
 */
public abstract class Binary extends Expression {

    protected Expression left;
    protected Expression right;

    public Binary(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String generate() {
        StringBuffer asm = new StringBuffer();
        asm.append(this.left.generate());
        asm.append(this.right.generate());
        asm.append(this.generateOperation());

        return asm.toString();
    }

    public abstract String generateOperation();

}
