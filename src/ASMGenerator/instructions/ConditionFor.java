package ASMGenerator.instructions;

import ASMGenerator.Generable;
import ASMGenerator.Labelable;
import ASMGenerator.expressions.Variable;
import ASMGenerator.expressions.binaries.Comparison;


public class ConditionFor implements Generable, Labelable {

    private Comparison condition;
    private Affectation a;

    public ConditionFor(Affectation a, Comparison c) {
        this.condition = c;
        this.a = a;
    }

    @Override
    public String generate() {
        return this.a.generate() + this.condition.generate();
    }

    public Variable getVariable() {
        return this.a.getVariable();
    }

    @Override
    public void setBaseLabel(String l) {
        this.condition.setBaseLabel(l);
    }

    @Override
    public void setGotoLabel(String l) {
        this.condition.setGotoLabel(l);
    }
}
