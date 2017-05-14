package ASMGenerator.expressions.binaries;

import ASMGenerator.ASMUtils;
import ASMGenerator.expressions.Binary;
import ASMGenerator.expressions.Expression;


public abstract class Comparison extends Binary {

    private String operator;
    private String label;

    public Comparison(Expression left, Expression right, String operator) {
        super(left, right);
        this.operator = operator;
    }

    @Override
    public String generateOperation() {
        return ASMUtils.generateComparison(this.operator, this.label);
    }

    public void setLabel(String l) {
        this.label = l;
    }

}
