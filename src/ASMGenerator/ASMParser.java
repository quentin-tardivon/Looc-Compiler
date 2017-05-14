package ASMGenerator;

import ASMGenerator.expressions.*;
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


	static int nbClass = 0;
    private static int countBlock = 0;
    private static EnvironmentCounter counter = new EnvironmentCounter();


    public static ArrayList<Generable> parse(Tree tree, SymbolTable TDS, ArrayList<Generable> res, ArrayList<Generable> meths) {
        switch(tree.getText()) {
            case "CLASS_DEC":
                String className = tree.getChild(0).getText();
                res.add(new LoocClass(className, TDS, nbClass));
                nbClass += 4; //TODO Change 4 to size of class descriptor + nb method
                int startAt = 1;
                for (int j = startAt; j < tree.getChildCount(); j++) {
                    parse(tree.getChild(j), TDS.getClass(className), res, meths);
                }
                break;

            case "VARS":
                break;

            case "METHODS":
                for (int i = 0; i < tree.getChildCount(); i++) {
                    parse(tree.getChild(i), TDS, res, meths);
                }
                break;

            case "METHOD":
                Tree body = tree.getChild(tree.getChildCount() - 1);
                ArrayList<Generable> inst = new ArrayList<Generable>();
                for (int i = 0; i < body.getChildCount(); i++) {
                    parse(body.getChild(i), TDS.getLink(tree.getChild(0).getText()), inst, meths);
                }
                Method m = new Method(TDS.getLink(tree.getChild(0).getText()));
                m.addAllInstructions(inst);
                meths.add(m);
                break;

            case "BLOCK":
                String blockID = EnvironmentCounter.generateID(Entry.ANONYMOUS_BLOC, counter.incrementBlock() ,TDS.getImbricationLevel() + 1);
                ArrayList<Generable> instBlock = new ArrayList<Generable>();
                for (int i = 0; i < tree.getChildCount(); i++) {
                    parse(tree.getChild(i), TDS.getLink(blockID), instBlock, meths);
                }
                Block myBlock = new Block();
                myBlock.addAllInstructions(instBlock);
                res.add(myBlock);
                break;

            case "BODY":
                for (int i = 0; i < tree.getChildCount(); i++) {
                    parse(tree.getChild(i), TDS, res, meths);
                }
                break;

            case "IF":
                Expression comparaison = parseExpression(tree.getChild(0), TDS);
                ArrayList<Generable> instIf = new ArrayList<Generable>();
                Tree tmp = tree.getChild(1);
                for (int i = 0; i < tmp.getChildCount(); i++) {
                    parse(tmp.getChild(i), TDS, instIf, meths);
                }
                Block then = new Block();
                Block elseBlock = null;
                then.addAllInstructions(instIf);

                if(tree.getChildCount() == 3) {
                    elseBlock =  new Block();
                    tmp = tree.getChild(2);
                    instIf = new ArrayList<Generable>();
                    for (int i = 0; i < tmp.getChildCount(); i++) {
                        parse(tmp.getChild(i), TDS, instIf, meths);
                    }
                    elseBlock.addAllInstructions(instIf);
                }
                res.add(new If((Comparison) comparaison, then, elseBlock));
                break;

            case "FOR":
                ASMGenerator.expressions.Variable vFor = new ASMGenerator.expressions.Variable((Variable) TDS.getInfo(tree.getChild(0).getText()));
                Affectation a = new Affectation(vFor, TDS, parseExpression(tree.getChild(1), TDS));
                Comparison c = new LowerOrEqual(vFor, parseExpression(tree.getChild(2), TDS));
                ArrayList<Generable> instFor = new ArrayList<Generable>();
                Tree tmpFor = tree.getChild(3);
                for (int i = 0; i < tmpFor.getChildCount(); i++) {
                    parse(tmpFor.getChild(i), TDS, instFor, meths);
                }
                Block forBlock = new Block();
                forBlock.addAllInstructions(instFor);
                res.add(new For(new ConditionFor(a, c), forBlock, TDS));
                break;


            case "VAR_DEC":
                res.add(new Declaration((Variable) TDS.get(tree.getChild(0).getText())));
                break;

            case "AFFECT":
                ASMGenerator.expressions.Variable varAffect = new ASMGenerator.expressions.Variable((Variable) TDS.getInfo(tree.getChild(0).getText()));
                Expression right = parseExpression(tree.getChild(1), TDS);
                res.add(new Affectation(varAffect, TDS, right));
                break;

            case "RETURN":
                res.add(new Return( (Variable) TDS.get(tree.getChild(0).getText())));
                break;


            case "WRITE":
                res.add(new Write(parseExpression(tree.getChild(0), TDS)));
                break;

	        case "DO":
		        for (int i = 0; i < tree.getChildCount(); i++) {
			        parse(tree.getChild(i), TDS, res, meths);
		        }
	        	break;

	        case "CALL":
	        	res.add(new MethodCall(tree.getChild(0).getText(), TDS, tree.getChild(1).getText()));
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
               return new LoocClassAffect(node.getChild(0).getText(), 0, TDS);

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
