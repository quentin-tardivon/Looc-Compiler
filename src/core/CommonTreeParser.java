package core;

import TDS.Entry;
import TDS.SymbolTable;
import TDS.entries.Method;
import TDS.entries.Parameter;
import TDS.entries.Variable;

import exceptions.MismatchTypeException;
import TDS.entries.*;
import TDS.entries.Class;

import org.antlr.runtime.tree.Tree;
import utils.Util;


import java.util.ArrayList;


/**
 * Created by quentin on 13/03/2017.
 */
public class CommonTreeParser {

	protected SymbolTable tds;

	protected ArrayList<String> list = new ArrayList<>();

	public CommonTreeParser() {

	}

	public void parseCommonTreeParser(Tree tree) {
		list.add(tree.toString());
		for (int i = 0; i < tree.getChildCount(); i++) {
			parseCommonTreeParser(tree.getChild(i));
		}
	}

	public void constructTDS(Tree tree, SymbolTable tds) throws Exception {
		SymbolTable newtds;
		switch (tree.getText()) {
			case "ROOT":
				this.tds = tds;
				for (int i = 0; i < tree.getChildCount(); i++) {
					//System.out.println("Enter in child" + i);
					constructTDS(tree.getChild(i), this.tds);
				}
				break;

			case "METHOD":
				System.out.println("Method encounter:" + tree.getChild(0).toString());
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds);
				tds.putLink(tree.getChild(0).getText(), newtds);
				if (tree.getChildCount() == 4) {
					tds.put(tree.getChild(0).getText(), new Method(tree.getChild(2).getText()));
					constructTDS(tree.getChild(1), newtds);
					constructTDS(tree.getChild(3), newtds);
				} else if ((tree.getChildCount() == 3) && tree.getChild(1).getText() == "FORMAL_PARAMS") {
					tds.put(tree.getChild(0).getText(), new Method());
					constructTDS(tree.getChild(1), newtds);
					constructTDS(tree.getChild(2), newtds);
				} else if ((tree.getChildCount() == 3)) {
					tds.put(tree.getChild(0).getText(), new Method(tree.getChild(1).getText()));
					constructTDS(tree.getChild(2), newtds);
				} else {
					tds.put(tree.getChild(0).getText(), new Method());
					constructTDS(tree.getChild(1), newtds);
				}

				break;

			case "FORMAL_PARAMS":
				System.out.println("Formal parameters encounter:");
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDS(tree.getChild(i), tds);
				}
				break;

			case "FORMAL_PARAM":
				System.out.println("Formal parameters encounter:");
				tds.put(tree.getChild(0).getText(), new Parameter(tree.getChild(1).getText()));
				break;

			case "VAR_DEC":
				System.out.println("Var encounter:" + tree.getChild(0).toString());
				tds.put(tree.getChild(0).getText(), new Variable(tree.getChild(1).getText()));
				break;

			case "CLASS_DEC":
				System.out.println("Class encounter:" + tree.getChild(0).toString());
				tds.put(tree.getChild(0).getText(), new Class(tree.getChild(0).getText()));
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds);
				tds.putLink(tree.getChild(0).getText(), newtds);
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds);
				}

				break;


			case "BLOCK":
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds);
				int nb = tds.getNumberBlock();
				tds.put("block" +nb , new AnonymousBloc(), "Block");
				tds.putLink("block" + nb, newtds);
				for (int j = 0; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds);
				}
				break;

			case "IF":
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), tds);
				}
				tds.setNumberIf(tds.getNumberIf()+1);
				break;

			case "THEN":
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds);
				nb = tds.getNumberIf();
				tds.put("if" +nb , new If());
				tds.putLink("if" + nb, newtds);
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds);
				}
				break;

			case "ELSE":
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds);
				nb = tds.getNumberIf();
				tds.put("else" +nb , new Else());
				tds.putLink("else" + nb, newtds);
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds);
				}
				break;

			case "VARS":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDS(tree.getChild(i), tds);
				}
				break;

			case "METHODS":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDS(tree.getChild(i), tds);
				}
				break;

			case "BODY":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDS(tree.getChild(i), tds);
				}
				break;


			case "AFFECT":

				//UndefinedVariableException
				Entry entry = tds.getInfo(tree.getChild(0).getText());

				//UndefinedClassException
				if(tree.getChild(1).getText().equals("new")){
					tds.getInfo(tree.getChild(1).getChild(0).getText());
				}

				//MismatchTypeException
				if (!Util.testType(entry,tree.getChild(1).getText()))
					throw new MismatchTypeException(
							Util.getType(tree.getChild(1).getText()),
							entry.get("type"),
							tree.getChild(1).getText(),
							tree.getChild(0).getText()
					);
				System.out.println("Line number: "  + tree.getChild(0).getLine());

				break;


			case "FOR":
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds);
				nb = tds.getNumberBlock();
				System.out.println("for"+nb);
				tds.put("for" +nb , new ForLoop(), "For");
				tds.putLink("for" + nb, newtds);
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds);
				}
				break;

			case "DO":
				//UndeclaredMethodException
				tds.getInfo(tree.getChild(1).getText());

				break;

			default:
				for (int i = 0; i < tree.getChildCount(); i++) {
					//System.out.println("## Default case " + tree);
					constructTDS(tree.getChild(i), tds);
				}
				break;
		}
	}

	public String toString() {
		return this.list.toString();
	}

	public SymbolTable getRootSymbolTable() {
		return this.tds;
	}

	/*public Boolean testType(Entry l, Object r){
		if (l.get("type").equals("int") && r instanceof Integer)
			return true;
		if (l.get("type").equals("string") && r instanceof String)
			return true;
		return false;
	}

	public String getType(Object o) {
		System.out.println(o);
		if (o instanceof Integer) {return "int";}
		else  { return "string";}

	}*/


}
