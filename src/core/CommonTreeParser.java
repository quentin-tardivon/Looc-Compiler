package core;

import TDS.Entry;
import TDS.SymbolTable;
import TDS.entries.*;
import TDS.entries.Class;
import exceptions.MismatchTypeException;
import org.antlr.runtime.tree.Tree;
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
		this.printCurrentLine(tree);

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
					tds.put(tree.getChild(0).getText(), new Method(tree.getChild(2).getText()));
					constructTDS(tree.getChild(1), newtds, rootTDS);
					constructTDS(tree.getChild(3), newtds, rootTDS);
				}
				//cas méthode sans type de retour et avec paramètres
				else if ((tree.getChildCount() == 3) && tree.getChild(1).getText().equals("FORMAL_PARAMS")) {
					tds.put(tree.getChild(0).getText(), new Method());
					constructTDS(tree.getChild(1), newtds, rootTDS);
					constructTDS(tree.getChild(2), newtds, rootTDS);
				}
				//cas méthode avec type de retour et sans paramètres
				else if ((tree.getChildCount() == 3)) {
					tds.put(tree.getChild(0).getText(), new Method(tree.getChild(1).getText()));
					constructTDS(tree.getChild(2), newtds, rootTDS);
				}
				//cas méthode sans type de retour et sans paramètres
				else {
					tds.put(tree.getChild(0).getText(), new Method());
					constructTDS(tree.getChild(1), newtds, rootTDS);
				}

				break;

			case "FORMAL_PARAMS":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDS(tree.getChild(i), tds, rootTDS);
				}
				break;

			case "FORMAL_PARAM":
				tds.put(tree.getChild(0).getText(), new Parameter(tree.getChild(1).getText(), tree.getChildIndex()));
				break;

			case "VAR_DEC":
				tds.put(tree.getChild(0).getText(), new Variable(tree.getChild(1).getText()));
				break;

			case "CLASS_DEC":
				Class newClass = new Class(tree.getChild(0).getText());
				String quentin = tree.getChild(0).getText();
				SymbolTable parentTDS = rootTDS;
				if (!(tree.getChild(1).getText().equals("METHODS") || tree.getChild(1).getText().equals("VARS"))) {
					if (rootTDS.findClass(tree.getChild(1).getText()) == null) {
						Util.undeclaredInheritance(tree.getChild(1).getText(), tds);
					}
					else {
						newClass.put("Inherit", tree.getChild(1).getText());
						parentTDS = rootTDS.findClass(tree.getChild(1).getText());
						if (parentTDS == null) {
							Util.undeclaredClass(tree.getChild(1).getText(), tds);
						}
					}
				}

				parentTDS.put(tree.getChild(0).getText(), newClass);
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, parentTDS, tree.getChild(0).getText()); //Attention, l'imbrication level correspond ici au niveau d'héritage
				parentTDS.putClass(tree.getChild(0).getText(), newtds);

				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds, rootTDS);
				}
				break;


			case "BLOCK":
				int nb = tds.getNumberBlock();
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, "block" + nb);
				tds.put("block" +nb , new AnonymousBloc(), "Block");
				tds.putLink("block" + nb, newtds);
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
				tds.put("if" +nb , new If());
				tds.putLink("if" + nb, newtds);
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds, rootTDS);
				}
				break;

			case "ELSE":
				nb = tds.getNumberIf();
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, "else" + nb);
				tds.put("else" +nb , new Else());
				tds.putLink("else" + nb, newtds);
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

				this.testAffectation(tree, tds, rootTDS);
				break;


			case "FOR":
				nb = tds.getNumberBlock();
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, "for" + nb);
				tds.put("for" +nb , new ForLoop(), "For");
				tds.putLink("for" + nb, newtds);
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds, rootTDS);
				}
				break;

			case "DO":
				Util.testDo(tree.getChild(0), tds, rootTDS);
				/*if (tree.getChildCount()==1) {
					//Controle sémantique ici ??
					if (tree.getChild(0).getText().equals("new"))
						tds.getInfo(tree.getChild(0).getChild(0).getText());
					else {

					}
				}
				else {
					if (!Util.testExecMethod(tree.getChild(0).getText(),tree.getChild(1).getText(),tds)){
						System.out.println("c pa bi1");
					}
				}
				tds.getInfo(tree.getChild(1).getText());*/
				break;

			case "RETURN":
				String realV = Util.subTreeType(tree.getChild(0), tds, rootTDS);

				String expectedV = tds.getFather().get(tds.getName()).get(Entry.RETURN_TYPE);

				Util.testReturnType(expectedV,realV);
				break;

			case "READ":
				realV = Util.subTreeType(tree.getChild(0), tds, rootTDS);
				Util.testReadUse(realV);
				break;

			case "WRITE":
				realV = Util.subTreeType(tree.getChild(0), tds, rootTDS);

				Util.testWriteUse(realV);

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

		switch (tree.getChild(1).getText()) {
			case Keywords.NEW:
				// Check if the class has been declared previously

				if (rootTDS.findClass(tree.getChild(1).getChild(0).getText()) == null)
					Util.undeclaredClass(tree.getChild(1).getChild(0).getText(), tds);

				rightNodeType = tree.getChild(1).getChild(0).toString();
				if (!entry.get(Entry.TYPE).equals(rightNodeType)) {
					if (!Util.validInherit(entry.get(Entry.TYPE),rightNodeType, rootTDS)) {
							throw new MismatchTypeException(null,null,rightNodeType,entry.get(Entry.TYPE),entry.toString());
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
				System.out.println("hello "+ rightNodeType + "\n");
				System.out.println("Hello 2 " + entry.get(Entry.TYPE) + "\n");
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
