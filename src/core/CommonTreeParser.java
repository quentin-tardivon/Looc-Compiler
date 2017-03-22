package core;

import TDS.Entry;
import TDS.SymbolTable;
import TDS.entries.Method;
import TDS.entries.Parameter;
import TDS.entries.Variable;
import com.sun.org.apache.xpath.internal.operations.Bool;
import exceptions.MismatchTypeException;
import exceptions.SymbolAlreadyDeclaredException;
import exceptions.UndeclaredVariableException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import TDS.entries.Class;
import utils.Util;

import java.util.ArrayList;
import java.util.HashMap;

import static utils.Util.testType;

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
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds); //We have to generate a nam
				tds.putLink(tree.getChild(0).getText(), newtds);
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds);
				}
				break;

			case "IF":
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds); //We have to generate a nam
				tds.putLink(tree.getChild(0).getText(), newtds);
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds);
				}
				break;

			case "THEN":
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds); //We have to generate a name
				tds.putLink(tree.getChild(0).getText(), newtds);
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds);
				}
				break;

			case "ELSE":
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds); //We have to generate a nam
				tds.putLink(tree.getChild(0).getText(), newtds);
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
				Entry entry = tds.getInfo(tree.getChild(0).getText());
				if (!Util.testType(entry,tree.getChild(1).getText()))
					throw new MismatchTypeException(
							Util.getType(tree.getChild(1).getText()),
							entry.get("type"),
							tree.getChild(1).getText(),
							tree.getChild(0).getText()
					);
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
