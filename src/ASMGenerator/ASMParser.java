package ASMGenerator;

import ASMGenerator.expressions.*;
import ASMGenerator.expressions.Parameter;
import ASMGenerator.expressions.binaries.*;
import ASMGenerator.instructions.*;
import ASMGenerator.instructions.If;
import TDS.Entry;
import TDS.SymbolTable;
import core.Keywords;
import org.antlr.runtime.tree.Tree;
import utils.EnvironmentCounter;
import utils.Util;

import java.util.ArrayList;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class ASMParser {

	private static EnvironmentCounter counter = new EnvironmentCounter();
	private static SymbolTable rootTDS;

    public static ArrayList<Generable> parse(Tree tree, SymbolTable TDS, ArrayList<Generable> res, ArrayList<Generable> meths) {
        if(ASMParser.rootTDS == null)
            ASMParser.rootTDS = TDS;

        switch(tree.getText()) {
            case "CLASS_DEC":
                String className = tree.getChild(0).getText();
                res.add(new LoocClass(className, TDS, counter.incrementClass()));
                int startAt = 1;
                for (int j = startAt; j < tree.getChildCount(); j++) {
                    parse(tree.getChild(j), TDS.getClass(className), res, meths);
                }
                break;

            case "ATTRIBUTES":
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
                String ifID = EnvironmentCounter.generateID(Entry.IF, counter.incrementIf() ,TDS.getImbricationLevel() + 1);

                Expression comparaison = parseExpression(tree.getChild(0), TDS);
                ArrayList<Generable> instIf = new ArrayList<Generable>();
                Tree tmp = tree.getChild(1);
                for (int i = 0; i < tmp.getChildCount(); i++) {
                    parse(tmp.getChild(i), TDS.getLink(ifID), instIf, meths);
                }
                Block then = new Block();
                Block elseBlock = null;
                then.addAllInstructions(instIf);

                if(tree.getChildCount() == 3) {
                    String elseID = EnvironmentCounter.generateID(Entry.ELSE, counter.incrementElse() ,TDS.getImbricationLevel() + 1);
                    elseBlock =  new Block();
                    tmp = tree.getChild(2);
                    instIf = new ArrayList<Generable>();
                    for (int i = 0; i < tmp.getChildCount(); i++) {
                        parse(tmp.getChild(i), TDS.getLink(elseID), instIf, meths);
                    }
                    elseBlock.addAllInstructions(instIf);
                }
                res.add(new If((Comparison) comparaison, then, elseBlock));
                break;

            case "FOR":
                String forID = EnvironmentCounter.generateID(Entry.FOR, counter.incrementFor() ,TDS.getImbricationLevel() + 1);
                ASMGenerator.expressions.Variable vFor = new ASMGenerator.expressions.Variable((TDS.entries.Variable) TDS.getInfo(tree.getChild(0).getText()), TDS);
                Affectation a = new Affectation(vFor, TDS, parseExpression(tree.getChild(1), TDS));
                Comparison c = new LowerOrEqual(vFor, parseExpression(tree.getChild(2), TDS));
                ArrayList<Generable> instFor = new ArrayList<Generable>();
                Tree tmpFor = tree.getChild(3);
                for (int i = 0; i < tmpFor.getChildCount(); i++) {
                    parse(tmpFor.getChild(i), TDS.getLink(forID), instFor,meths);
                }
                Block forBlock = new Block();
                forBlock.addAllInstructions(instFor);
                res.add(new For(new ConditionFor(a, c), forBlock, TDS));
                break;


            case "VAR_DEC":
                res.add(new Declaration((TDS.entries.Variable) TDS.get(tree.getChild(0).getText())));
                break;

            case "AFFECT":
                ASMGenerator.expressions.Variable varAffect = parseReceiver(tree.getChild(0), TDS);
                Expression right = parseExpression(tree.getChild(1), TDS);
                res.add(new Affectation(varAffect, TDS, right));
                break;

            case "RETURN":
                res.add(new Return( (TDS.entries.Variable) TDS.getInfo(tree.getChild(0).getText())));
                break;

            case "WRITE":
                res.add(new Write(parseExpression(tree.getChild(0), TDS)));
                break;

            case "READ":
                res.add(new Read((ASMGenerator.expressions.Variable) parseExpression(tree.getChild(0), TDS), TDS));
                break;

            case "DO":
                for (int i = 0; i < tree.getChildCount(); i++) {
			        parse(tree.getChild(i), TDS, res, meths);
		        }
	        	break;

	        case "CALL":
	            // No params
                int indexReceiver = tree.getChildCount() == 2 ? 1 : 2;
                ASMGenerator.expressions.Variable receiver = new ASMGenerator.expressions.Variable((TDS.entries.Variable) TDS.getInfo(tree.getChild(indexReceiver).getText()), TDS);
                ArrayList<Parameter> p = new ArrayList<Parameter>();
                if(tree.getChildCount() == 2)
                    res.add(new MethodCall(receiver, tree.getChild(0).getText(), TDS, p));
                else {
                    SymbolTable methodTDS = rootTDS.findClass(receiver.getType()).getLink(tree.getChild(0).getText());
                    ArrayList<TDS.entries.Parameter> formalParams = Util.getParameters(methodTDS);

                    Tree node = tree.getChild(1);
	                for(int i = node.getChildCount() - 1; i >= 0; i--) {
                        p.add(parseParameter(formalParams.get(i), node.getChild(i), TDS));
                    }
                    res.add(new MethodCall(receiver, tree.getChild(0).getText(), TDS, p));
                }
                break;

            default:
                System.err.println(tree.getText() + " is not supported [line "+ tree.getLine() + "]");
                break;
        }
        return res;
    }

    public static Parameter parseParameter(TDS.entries.Parameter p, Tree node, SymbolTable TDS) {
        return new Parameter(p, parseExpression(node, TDS));
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
                return new ConstantInteger(-Integer.parseInt(node.getChild(0).getText()));
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
                if (node.getText().matches("[-+]?\\d*\\.?\\d+"))
                    return new ConstantInteger(Integer.parseInt(node.getText()));
                if (node.getText().matches("\".*\""))
                    return new ConstantString(node.getText());
                else {
                    if (TDS.getInfo(node.getText()) instanceof TDS.entries.Parameter)
                        return new EffectiveParam((TDS.entries.Parameter) TDS.getInfo(node.getText()), TDS);
                    if (TDS.getInfo(node.getText()) instanceof TDS.entries.Attribute)
                        return new Attribute((TDS.entries.Attribute) TDS.getInfo(node.getText()), TDS);
                    else
                        return new ASMGenerator.expressions.Variable((TDS.entries.Variable) TDS.getInfo(node.getText()), TDS);
                }
        }
    }

    public static Variable parseReceiver(Tree node, SymbolTable TDS) {
        if(TDS.getInfo(node.getText()) instanceof TDS.entries.Attribute)
            return new Attribute((TDS.entries.Attribute) TDS.getInfo(node.getText()), TDS);
        else
            return new ASMGenerator.expressions.Variable((TDS.entries.Variable) TDS.getInfo(node.getText()), TDS);
    }

}
