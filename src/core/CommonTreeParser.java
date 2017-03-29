package core;

import TDS.Entry;
import TDS.SymbolTable;
import TDS.entries.Method;
import TDS.entries.Parameter;
import TDS.entries.Variable;

import exceptions.LoocException;
import exceptions.MismatchTypeException;
import TDS.entries.*;
import TDS.entries.Class;

import exceptions.StringOperationException;
import exceptions.UndeclaredVariableException;
import exceptions.UnknownNodeTypeException;
import org.antlr.runtime.tree.Tree;
import utils.Util;


import java.util.ArrayList;


/**
 * Created by quentin on 13/03/2017.
 */
public class CommonTreeParser {

	protected SymbolTable tds;
	private String filename;
	protected ArrayList<String> list = new ArrayList<>();

	public CommonTreeParser(String filename) {
		this.filename = filename;
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
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDS(tree.getChild(i), tds);
				}
				break;

			case "FORMAL_PARAM":
				tds.put(tree.getChild(0).getText(), new Parameter(tree.getChild(1).getText()));
				break;

			case "VAR_DEC":
				tds.put(tree.getChild(0).getText(), new Variable(tree.getChild(1).getText()));
				break;

			case "CLASS_DEC":
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
					System.out.println("affect new");
					tds.getInfo(tree.getChild(1).getChild(0).getText());
				}

				//MismatchTypeException
				//System.out.println(entry);
				if (!Util.testType(entry,subTreeType(tree.getChild(1),tds)))
					throw new MismatchTypeException(this.filename, tree.getChild(1),
							Util.getType(tree.getChild(1).getText(), tds),
							entry.get("type"),
							tree.getChild(1).getText(),
							tree.getChild(0).getText()
					);
				//System.out.println("Affect : " + tree.getChild(0).getText() + ":=" + tree.getChild(1).getText());
				System.out.println("Line number: "  + tree.getChild(0).getLine());

				break;


			case "FOR":
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds);
				nb = tds.getNumberBlock();
				//System.out.println("for"+nb);
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

	public String subTreeType(Tree node,SymbolTable tds) throws Exception {
			System.out.println("Appel subtreetype" + node.getText());

			switch (node.getText()) {
				case "PLUS":
					//System.out.println("plus");
					return Util.testTypeOper(subTreeType(node.getChild(0),tds),subTreeType(node.getChild(1),tds));
				case "DIFF":
					//System.out.println("diff");
					return Util.testTypeOper(subTreeType(node.getChild(0),tds),subTreeType(node.getChild(1),tds));
				case "MUL":
					//System.out.println("mul");
					return Util.testTypeOper(subTreeType(node.getChild(0),tds),subTreeType(node.getChild(1),tds));
				case "DIV":
					//System.out.println("div");
					return Util.testTypeOper(subTreeType(node.getChild(0),tds),subTreeType(node.getChild(1),tds));
				case "new":
					//System.out.println("new subtreetype");
					return node.getChild(0).getText();
				default:
					return Util.getType(node.getText(),tds);
			}
	}


}
