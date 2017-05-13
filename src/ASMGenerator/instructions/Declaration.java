package ASMGenerator.instructions;

import ASMGenerator.ASMUtils;
import ASMGenerator.Generable;
import TDS.Entry;
import TDS.entries.Variable;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class Declaration implements Generable {

    private Variable variable;

    public Declaration(Variable v) {
        this.variable = v;
    }
    @Override
    public String generate() {
        return ASMUtils.generateDeclaration(ASMUtils.sizeof(this.variable));
    }
}
