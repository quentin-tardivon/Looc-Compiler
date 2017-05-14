package ASMGenerator.expressions.binaries;

import ASMGenerator.ASMUtils;
import ASMGenerator.Labelable;
import ASMGenerator.expressions.Binary;
import ASMGenerator.expressions.Expression;


public abstract class Comparison extends Binary implements Labelable {

    private String operator;
    private String baselabel;
    private String gotoLabel;

    public Comparison(Expression left, Expression right, String operator) {
        super(left, right);
        this.operator = operator;
    }

    @Override
    public String generateOperation() {
        return ASMUtils.generateComparison(this.operator, this.gotoLabel, this.baselabel);
    }

    public void setBaseLabel(String l) {
        this.baselabel = l;
    }

    public void setGotoLabel(String l) {
        this.gotoLabel = l;
    }

}
