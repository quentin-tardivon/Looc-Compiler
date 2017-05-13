package ASMGenerator;

import ASMGenerator.expressions.Expression;
import ASMGenerator.expressions.ConstInt;
import ASMGenerator.expressions.binaries.Multiplication;
import ASMGenerator.expressions.binaries.Plus;
import ASMGenerator.instructions.Affectation;
import ASMGenerator.instructions.Declaration;
import ASMGenerator.instructions.Return;
import TDS.SymbolTable;
import TDS.entries.Variable;
import core.Keywords;
import org.antlr.runtime.tree.Tree;

import java.util.ArrayList;


public class ASMParser {

    public static ArrayList<Generable> parse(Tree tree, SymbolTable TDS, ArrayList<Generable> res) {

        switch(tree.getText()) {
            case "CLASS_DEC":
                String className = tree.getChild(0).getText();
                res.add(new LoocClass(className, TDS));
                for (int j = 1; j < tree.getChildCount(); j++) {
                   parse(tree.getChild(j), TDS.getClass(className), res);
                }
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
                    parse(tree.getChild(i), TDS.getLink(tree.getChild(0).getText()), inst);
                }
                Method m = new Method(TDS.getLink(tree.getChild(0).getText()));
                m.addAllInstructions(inst);
                res.add(m);
                break;

            case "BODY":
                for (int i = 0; i < tree.getChildCount(); i++) {
                    parse(tree.getChild(i), TDS, res);
                }
                break;

            case "VAR_DEC":
                res.add(new Declaration((Variable) TDS.get(tree.getChild(0).getText())));
                break;

            case "AFFECT":
                Expression right = parseExpression(tree.getChild(1), TDS);
                res.add(new Affectation( (Variable) TDS.get(tree.getChild(0).getText()), right));
                break;

            case "RETURN":
                res.add(new Return( (Variable) TDS.get(tree.getChild(0).getText())));
                break;

            default:
                System.err.println(tree.getText() + " is not supported!");
                break;
        }
        return res;
    }

    public static Expression parseExpression(Tree node, SymbolTable TDS) {
        switch (node.getText()) {
            case "PLUS":
                return new Plus(parseExpression(node.getChild(0), TDS), parseExpression(node.getChild(1), TDS));
            case "DIFF":
            case "MUL":
                return new Multiplication(parseExpression(node.getChild(0), TDS), parseExpression(node.getChild(1), TDS));
            case "DIV":
            case "-":
            case ">":
            case ">=":
            case "<":
            case "<=":
            case "==":
            case "!=":
            case Keywords.NEW:
            case Keywords.THIS:
            case "CALL":
            case Keywords.NIL:
            default:
                if(node.getText().matches("[-+]?\\d*\\.?\\d+"))
                    return new ConstInt(Integer.parseInt(node.getText()));
                // variable
                else
                    return new ASMGenerator.expressions.Variable((Variable) TDS.get(node.getText()));
        }
    }
}
