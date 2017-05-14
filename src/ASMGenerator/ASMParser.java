package ASMGenerator;

import ASMGenerator.expressions.ConstantInteger;
import ASMGenerator.expressions.ConstantString;
import ASMGenerator.expressions.Expression;
import ASMGenerator.expressions.binaries.*;
import ASMGenerator.instructions.*;
import TDS.Entry;
import TDS.SymbolTable;
import TDS.entries.Variable;
import core.Keywords;
import org.antlr.runtime.tree.Tree;
import utils.EnvironmentCounter;

import java.util.ArrayList;


public class ASMParser {

    private static int countBlock = 0;
    private static EnvironmentCounter counter = new EnvironmentCounter();

    public static ArrayList<Generable> parse(Tree tree, SymbolTable TDS, ArrayList<Generable> res) {
        switch(tree.getText()) {
            case "CLASS_DEC":
                String className = tree.getChild(0).getText();
                res.add(new LoocClass(className, TDS));
                int startAt = 1;
                for (int j = startAt; j < tree.getChildCount(); j++) {
                    parse(tree.getChild(j), TDS.getClass(className), res);
                }
                break;
            case "VARS":
                break;

            case "METHODS":
                for (int i = 0; i < tree.getChildCount(); i++) {
                    parse(tree.getChild(i), TDS, res);
                }
                break;

            case "METHOD":
                Tree body = tree.getChild(tree.getChildCount() - 1);
                ArrayList<Generable> inst = new ArrayList<Generable>();
                for (int i = 0; i < body.getChildCount(); i++) {
                    parse(body.getChild(i), TDS.getLink(tree.getChild(0).getText()), inst);
                }
                Method m = new Method(TDS.getLink(tree.getChild(0).getText()));
                m.addAllInstructions(inst);
                res.add(m);
                break;

            case "BLOCK":
                String blockID = EnvironmentCounter.generateID(Entry.ANONYMOUS_BLOC, counter.incrementBlock() ,TDS.getImbricationLevel() + 1);
                ArrayList<Generable> instBlock = new ArrayList<Generable>();
                for (int i = 0; i < tree.getChildCount(); i++) {
                    parse(tree.getChild(i), TDS.getLink(blockID), instBlock);
                }
                Block myBlock = new Block();
                myBlock.addAllInstructions(instBlock);
                res.add(myBlock);
                break;

            case "BODY":
                for (int i = 0; i < tree.getChildCount(); i++) {
                    parse(tree.getChild(i), TDS, res);
                }
                break;

            case "IF":
                Expression comparaison = parseExpression(tree.getChild(0), TDS);
                ArrayList<Generable> instIf = new ArrayList<Generable>();
                Tree tmp = tree.getChild(1);
                for (int i = 0; i < tmp.getChildCount(); i++) {
                    parse(tmp.getChild(i), TDS, instIf);
                }
                Block then = new Block();
                Block elseBlock = null;
                then.addAllInstructions(instIf);

                if(tree.getChildCount() == 3) {
                    elseBlock =  new Block();
                    tmp = tree.getChild(2);
                    instIf = new ArrayList<Generable>();
                    for (int i = 0; i < tmp.getChildCount(); i++) {
                        parse(tmp.getChild(i), TDS, instIf);
                    }
                    elseBlock.addAllInstructions(instIf);
                }
                res.add(new If((Comparison) comparaison, then, elseBlock));
                break;

            case "FOR":
                Variable v = (Variable) TDS.getInfo(tree.getChild(0).getText());
                Affectation a = new Affectation(v, parseExpression(tree.getChild(1), TDS));
                Comparison c = new LowerOrEqual(new ASMGenerator.expressions.Variable(v), parseExpression(tree.getChild(2), TDS));
                ArrayList<Generable> instFor = new ArrayList<Generable>();
                Tree tmpFor = tree.getChild(3);
                for (int i = 0; i < tmpFor.getChildCount(); i++) {
                    parse(tmpFor.getChild(i), TDS, instFor);
                }
                Block forBlock = new Block();
                forBlock.addAllInstructions(instFor);
                res.add(new For(new ConditionFor(a, c), forBlock));


            case "VAR_DEC":
                res.add(new Declaration((Variable) TDS.get(tree.getChild(0).getText())));
                break;

            case "AFFECT":
                Expression right = parseExpression(tree.getChild(1), TDS);
                res.add(new Affectation( (Variable) TDS.getInfo(tree.getChild(0).getText()), right));
                break;

            case "RETURN":
                res.add(new Return( (Variable) TDS.get(tree.getChild(0).getText())));
                break;


            case "WRITE":
                res.add(new Write(parseExpression(tree.getChild(0), TDS)));
                break;

            default:
                System.err.println(tree.getText() + " is not supported [line "+ tree.getLine() + "]");
                break;
        }
        return res;
    }

    public static Expression parseExpression(Tree node, SymbolTable TDS) {
        switch (node.getText()) {
            case "PLUS":
                return new Plus(parseExpression(node.getChild(0), TDS), parseExpression(node.getChild(1), TDS));
            case "DIFF":
                return new Diff(parseExpression(node.getChild(0), TDS), parseExpression(node.getChild(1), TDS));
            case "MUL":
                return new Mul(parseExpression(node.getChild(0), TDS), parseExpression(node.getChild(1), TDS));
            case "DIV":
                return new Div(parseExpression(node.getChild(0), TDS), parseExpression(node.getChild(1), TDS));
            case "-":
                return new ConstantInteger(- Integer.parseInt(node.getChild(0).getText()));
            case ">":
                return new Greater(parseExpression(node.getChild(0), TDS), parseExpression(node.getChild(1), TDS));
            case ">=":
                return new GreaterOrEqual(parseExpression(node.getChild(0), TDS), parseExpression(node.getChild(1), TDS));
            case "<":
                return new Lower(parseExpression(node.getChild(0), TDS), parseExpression(node.getChild(1), TDS));
            case "<=":
                return new LowerOrEqual(parseExpression(node.getChild(0), TDS), parseExpression(node.getChild(1), TDS));
            case "==":
                return new Equal(parseExpression(node.getChild(0), TDS), parseExpression(node.getChild(1), TDS));
            case "!=":
                return new NotEqual(parseExpression(node.getChild(0), TDS), parseExpression(node.getChild(1), TDS));

            case Keywords.NEW:
            case Keywords.THIS:
            case "CALL":
            case Keywords.NIL:
            default:
                if(node.getText().matches("[-+]?\\d*\\.?\\d+"))
                    return new ConstantInteger(Integer.parseInt(node.getText()));
                if(node.getText().matches("\".*\""))
                    return new ConstantString(node.getText());
                // variable
                else
                    return new ASMGenerator.expressions.Variable((Variable) TDS.getInfo(node.getText()));
        }
    }

}
