package core;

import TDS.Entry;
import TDS.SymbolTable;
import TDS.entries.*;
import TDS.entries.Class;
import exceptions.MismatchTypeException;
import exceptions.VarUninitializedException;
import org.antlr.runtime.tree.Tree;
import sun.jvm.hotspot.oops.ExceptionTableElement;
import utils.Util;

import java.util.ArrayList;


/**
 * Created by quentin on 13/03/2017.
 */
public class CommonTreeParser {

	private SymbolTable tds;
	private String filename;
	private ArrayList<String> list = new ArrayList<>();
	private int currentLine = 0;

	public CommonTreeParser(String filename) {  this.filename = filename;  }

	public void parseCommonTreeParser(Tree tree) {
		list.add(tree.toString());
		for (int i = 0; i < tree.getChildCount(); i++) {
			parseCommonTreeParser(tree.getChild(i));
		}
	}

	private void printCurrentLine(Tree node) {
		if(node != null) {
			if (currentLine != node.getLine()) {
				this.currentLine = node.getLine();
				System.out.print("\nLine number: " + this.currentLine + " ");
			}
			else
				System.out.print("+");
		}
	}


	public void constructTDS(Tree tree, SymbolTable tds, SymbolTable rootTDS) throws Exception {
		SymbolTable newtds;

		switch (tree.getText()) {
			case "ROOT":
				this.tds = tds;
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDS(tree.getChild(i), this.tds, rootTDS);
				}
				break;


			case "METHOD":
				//System.out.println("Method encounter:" + tree.getChild(0).toString());
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, tree.getChild(0).getText());
				tds.putLink(tree.getChild(0).getText(), newtds);

				//cas méthode avec type de retour et avec paramètres
				if (tree.getChildCount() == 4) {
					try {
						tds.put(tree.getChild(0).getText(), new Method(tree.getChild(2).getText()));
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					constructTDS(tree.getChild(1), newtds, rootTDS);
					constructTDS(tree.getChild(3), newtds, rootTDS);
				}
				//cas méthode sans type de retour et avec paramètres
				else if ((tree.getChildCount() == 3) && tree.getChild(1).getText().equals("FORMAL_PARAMS")) {
					try {
						tds.put(tree.getChild(0).getText(), new Method());
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					constructTDS(tree.getChild(1), newtds, rootTDS);
					constructTDS(tree.getChild(2), newtds, rootTDS);
				}
				//cas méthode avec type de retour et sans paramètres
				else if ((tree.getChildCount() == 3)) {
					try {
						tds.put(tree.getChild(0).getText(), new Method(tree.getChild(1).getText()));
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					constructTDS(tree.getChild(2), newtds, rootTDS);
				}
				//cas méthode sans type de retour et sans paramètres
				else {
					try {
						tds.put(tree.getChild(0).getText(), new Method());
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					constructTDS(tree.getChild(1), newtds, rootTDS);
				}

				break;

			case "FORMAL_PARAMS":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDS(tree.getChild(i), tds, rootTDS);
				}
				break;

			case "FORMAL_PARAM":
				try {
					tds.put(tree.getChild(0).getText(), new Parameter(tree.getChild(1).getText(), tree.getChildIndex()));
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case "VAR_DEC":
				Variable var = new Variable(tree.getChild(1).getText());
				var.setInit(false);
				try {
					tds.put(tree.getChild(0).getText(), var);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case "CLASS_DEC":
				Class newClass = new Class(tree.getChild(0).getText());
				String quentin = tree.getChild(0).getText();
				SymbolTable parentTDS = rootTDS;
				if (!(tree.getChild(1).getText().equals("METHODS") || tree.getChild(1).getText().equals("VARS"))) {
					if (rootTDS.findClass(tree.getChild(1).getText()) == null) {
						try {
							Util.undeclaredInheritance(tree.getChild(1).getText(), tds);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
					else {
						newClass.put("Inherit", tree.getChild(1).getText());
						parentTDS = rootTDS.findClass(tree.getChild(1).getText());
						if (parentTDS == null) {
							Util.undeclaredClass(tree.getChild(1).getText(), tds);
						}
					}
				}
				try {
					parentTDS.put(tree.getChild(0).getText(), newClass);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, parentTDS, tree.getChild(0).getText()); //Attention, l'imbrication level correspond ici au niveau d'héritage
				parentTDS.putClass(tree.getChild(0).getText(), newtds);

				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds, rootTDS);
				}
				break;


			case "BLOCK":
				int nb = tds.getNumberBlock();
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, "block" + nb);
				try {
					tds.put("block" +nb , new AnonymousBloc(), "Block");
					tds.putLink("block" + nb, newtds);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				for (int j = 0; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds, rootTDS);
				}
				break;

			case "IF":
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), tds, rootTDS);
				}
				tds.setNumberIf(tds.getNumberIf()+1);
				break;

			case "THEN":
				nb = tds.getNumberIf();
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, "if" + nb);
				try {
					tds.put("if" +nb , new If());
					tds.putLink("if" + nb, newtds);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds, rootTDS);
				}
				break;

			case "ELSE":
				nb = tds.getNumberIf();
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, "else" + nb);
				try {
					tds.put("else" +nb , new Else());
					tds.putLink("else" + nb, newtds);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds, rootTDS);
				}
				break;

			case "VARS":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDS(tree.getChild(i), tds, rootTDS);
				}
				break;

			case "METHODS":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDS(tree.getChild(i), tds, rootTDS);
				}
				break;


			case "BODY":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDS(tree.getChild(i), tds, rootTDS);
				}
				break;


			case "AFFECT":
				try {
					this.testAffectation(tree, tds, rootTDS);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				break;


			case "FOR":
				nb = tds.getNumberBlock();
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, "for" + nb);
				try {
					tds.put("for" +nb , new ForLoop(), "For");
					tds.putLink("for" + nb, newtds);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				//TODO Further testing on for loop
				tds.getInfo(tree.getChild(0).getText()).setInit(true);
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds, rootTDS);
				}
				break;

			case "DO":
				try {
					Util.testDo(tree.getChild(0), tds, rootTDS);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case "RETURN":
				String realV = Util.subTreeType(tree.getChild(0), tds, rootTDS);

				String expectedV = tds.getFather().get(tds.getName()).get(Entry.RETURN_TYPE);

				try {
					Util.testReturnType(expectedV,realV);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case "READ":
				realV = Util.subTreeType(tree.getChild(0), tds, rootTDS);
				try {
					Util.testReadUse(realV);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case "WRITE":
				realV = Util.subTreeType(tree.getChild(0), tds, rootTDS);
				try {
					Util.testWriteUse(realV);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				break;

			default:
				for (int i = 0; i < tree.getChildCount(); i++) {

					constructTDS(tree.getChild(i), tds, rootTDS);
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


	/**
	 * This method must:
	 *  - Check that the variable is correctly declared
	 *  - The type of the variable corresponds to the right node's type
	 *  - If the expression is the creation of object (new), check if the class exists
	 *
	 * @param tree
	 * @param tds
	 * @throws Exception
	 */

	private void testAffectation(Tree tree, SymbolTable tds, SymbolTable rootTDS) throws Exception {
		Entry entry = tds.getInfo(tree.getChild(0).getText());
		String rightNodeType= null;



		if (entry == null)
			Util.undeclaredToken(tree.getChild(0).getText(), tds);

		tds.getInfo(tree.getChild(0).getText()).setInit(true);
		switch (tree.getChild(1).getText()) {
			case Keywords.NEW:
				// Check if the class has been declared previously

				if (rootTDS.findClass(tree.getChild(1).getChild(0).getText()) == null)
					Util.undeclaredClass(tree.getChild(1).getChild(0).getText(), tds);

				rightNodeType = tree.getChild(1).getChild(0).toString();
				if (!entry.get(Entry.TYPE).equals(rightNodeType)) {
					if (!Util.validInherit(entry.get(Entry.TYPE),rightNodeType, rootTDS)) {
							throw new MismatchTypeException(null, null, rightNodeType, entry.get(Entry.TYPE), entry.toString());
					}

				}
				break;
			case Keywords.NIL:
				entry.put(Entry.NIL, "true");
				rightNodeType="nil";
				break;
			case "CALL":
				Util.testCall(tree.getChild(1), tds, rootTDS);
				break;
			default:
				rightNodeType = Util.subTreeType(tree.getChild(1), tds, rootTDS);
		}

		if (!entry.get(Entry.TYPE).equals(rightNodeType)) {
			if(!rightNodeType.equals("nil")) {
				if (!Util.validInherit(entry.get(Entry.TYPE),rightNodeType, rootTDS)) {
					throw new MismatchTypeException(null, null, rightNodeType, entry.get(Entry.TYPE), entry.toString());
				}
			}
		}
	}



}
