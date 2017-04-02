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


	public void constructTDS(Tree tree, SymbolTable tds) throws Exception {
		SymbolTable newtds;
		this.printCurrentLine(tree);

		switch (tree.getText()) {
			case "ROOT":
				this.tds = tds;
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDS(tree.getChild(i), this.tds);
				}
				break;


			case "METHOD":
				//System.out.println("Method encounter:" + tree.getChild(0).toString());
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, tree.getChild(0).getText());
				tds.putLink(tree.getChild(0).getText(), newtds);

				//cas méthode avec type de retour et avec paramètres
				if (tree.getChildCount() == 4) {
					tds.put(tree.getChild(0).getText(), new Method(tree.getChild(2).getText()));
					constructTDS(tree.getChild(1), newtds);
					constructTDS(tree.getChild(3), newtds);
				}
				//cas méthode sans type de retour et avec paramètres
				else if ((tree.getChildCount() == 3) && tree.getChild(1).getText().equals("FORMAL_PARAMS")) {
					tds.put(tree.getChild(0).getText(), new Method());
					constructTDS(tree.getChild(1), newtds);
					constructTDS(tree.getChild(2), newtds);
				}
				//cas méthode avec type de retour et sans paramètres
				else if ((tree.getChildCount() == 3)) {
					tds.put(tree.getChild(0).getText(), new Method(tree.getChild(1).getText()));
					constructTDS(tree.getChild(2), newtds);
				}
				//cas méthode sans type de retour et sans paramètres
				else {
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
				Class newClass = new Class(tree.getChild(0).getText());
				if (!(tree.getChild(1).getText().equals("METHODS") || tree.getChild(1).getText().equals("VARS"))) {
					if (tds.getInfo(tree.getChild(1).getText()) == null) {
						Util.undeclaredInheritance(tree.getChild(1).getText(), tds);
					}
					else {
						newClass.put("Inherit", tree.getChild(1).getText());
					}
				}
				tds.put(tree.getChild(0).getText(), newClass);
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, tree.getChild(0).getText());
				tds.putLink(tree.getChild(0).getText(), newtds);
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds);
				}
				break;


			case "BLOCK":
				int nb = tds.getNumberBlock();
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, "block" + nb);
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
				nb = tds.getNumberIf();
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, "if" + nb);
				tds.put("if" +nb , new If());
				tds.putLink("if" + nb, newtds);
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds);
				}
				break;

			case "ELSE":
				nb = tds.getNumberIf();
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, "else" + nb);
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
				this.testAffectation(tree, tds);
				break;


			case "FOR":
				nb = tds.getNumberBlock();
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, "for" + nb);
				tds.put("for" +nb , new ForLoop(), "For");
				tds.putLink("for" + nb, newtds);
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds);
				}
				break;

			case "DO":
				Util.testDo(tree.getChild(0), tds);
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

			case "RETURN"://TODO : regarder return 1, et passer par getInfo ou autre ?
				String realV = Util.subTreeType(tree.getChild(0), tds);
				String expectedV = tds.getFather().get(tds.getName()).get(Entry.RETURN_TYPE);
				Util.testReturnType(expectedV,realV);
				break;

			case "READ":

				break;


			default:
				for (int i = 0; i < tree.getChildCount(); i++) {
					System.out.println("## Default case " + tree);
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
	private void testAffectation(Tree tree, SymbolTable tds) throws Exception {
		Entry entry = tds.getInfo(tree.getChild(0).getText());
		String rightNodeType;

		if (entry == null)
			Util.undeclaredToken(tree.getChild(0).getText(), tds);

		switch (tree.getChild(1).getText()) {
			case Keywords.NEW:
				// Check if the class has been declared previously
				if (tds.getInfo(tree.getChild(1).getChild(0).getText()) == null)
					Util.undeclaredClass(tree.getChild(1).getChild(0).getText(), tds);

				//TODO : rightNodeType dans le cas de l'héritage , ici seul le cas sans héritage est testé
				//System.out.println("case new : "+tree.getChild(1).getChild(0).getText());
				rightNodeType = tree.getChild(1).getChild(0).toString();
				break;
			case Keywords.NIL:
				entry.put(Entry.NIL, "true");
				rightNodeType="nil";
				break;
			default:
				rightNodeType = Util.subTreeType(tree.getChild(1), tds);

		}
		if (!entry.get(Entry.TYPE).equals(rightNodeType)){
			throw new MismatchTypeException(null,null,entry.get(Entry.TYPE),rightNodeType,entry.toString());
		}



				/*
		//UndefinedVariableException
		Entry entry = tds.getInfo(tree.getChild(0).getText());
		if (entry == null) {
			Util.undeclaredToken(tree.getChild(0).getText(), tds);
		}

		//UndefinedClassException
		if(tree.getChild(1).getText().equals("new") && tds.getInfo(tree.getChild(1).getChild(0).getText()) == null){
			Util.undeclaredClass(tree.getChild(1).getChild(0).getText(), tds);
		}

		//MismatchTypeException
		Util.testType(entry, Util.subTreeType(tree.getChild(1),tds),tds);

		if (tree.getChild(1).getText().equals("new")) {
			//System.out.println("node: "+ tree.getChild(1).getChild(0).getText());
			if (!Util.testType(entry, Util.subTreeType(tree.getChild(1),tds),tds))
				Util.mismatchType(this.filename, tree.getChild(1),
						Util.getType(tree.getChild(1).getChild(0).getText(), tds),
						entry.get(Entry.TYPE),
						tree.getChild(1).getChild(0).getText(),
						tree.getChild(0).getText());


		} //TODO : implementer case : CALL dans subTreeType et testType
		//TODO : Probleme lors d'une affectation avec nil (voir Level7 dans les tests):    a := nil;
		else if(tree.getChild(1).getText().equals("call")) {
			if (!Util.testType(entry, Util.subTreeType(tree.getChild(1),tds),tds))
				Util.mismatchType(this.filename, tree.getChild(1),
						Util.getType(tree.getChild(1).getChild(0).getText(), tds),
						entry.get(Entry.TYPE),
						tree.getChild(1).getChild(0).getText(),
						tree.getChild(0).getText());

		}
		else if (!Util.testType(entry, Util.subTreeType(tree.getChild(1),tds),tds))
			Util.mismatchType(this.filename, tree.getChild(1),
					Util.getType(tree.getChild(1).getText(), tds),
					entry.get(Entry.TYPE),
					tree.getChild(1).getText(),
					tree.getChild(0).getText());

*/
	}

	/*public void constructTDSWithoutSemantic(Tree tree, SymbolTable tds) throws SymbolAlreadyDeclaredException{
		SymbolTable newtds;
		switch (tree.getText()) {
			case "ROOT":
				this.tds = tds;
				for (int i = 0; i < tree.getChildCount(); i++) {
					//System.out.println("Enter in child" + i);
					constructTDSWithoutSemantic(tree.getChild(i), this.tds);
				}
				break;

			case "METHOD":
				System.out.println("Method encounter:" + tree.getChild(0).toString());
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds);
				tds.putLink(tree.getChild(0).getText(), newtds);
				if (tree.getChildCount() == 4) {
					tds.put(tree.getChild(0).getText(), new Method(tree.getChild(2).getText()));
					constructTDSWithoutSemantic(tree.getChild(1), newtds);
					constructTDSWithoutSemantic(tree.getChild(3), newtds);
				} else if ((tree.getChildCount() == 3) && tree.getChild(1).getText() == "FORMAL_PARAMS") {
					tds.put(tree.getChild(0).getText(), new Method());
					constructTDSWithoutSemantic(tree.getChild(1), newtds);
					constructTDSWithoutSemantic(tree.getChild(2), newtds);
				} else if ((tree.getChildCount() == 3)) {
					tds.put(tree.getChild(0).getText(), new Method(tree.getChild(1).getText()));
					constructTDSWithoutSemantic(tree.getChild(2), newtds);
				} else {
					tds.put(tree.getChild(0).getText(), new Method());
					constructTDSWithoutSemantic(tree.getChild(1), newtds);
				}

				break;

			case "FORMAL_PARAMS":
				System.out.println("Formal parameters encounter:");
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDSWithoutSemantic(tree.getChild(i), tds);
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
					constructTDSWithoutSemantic(tree.getChild(j), newtds);
				}

				break;


			case "BLOCK":
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds);
				int nb = tds.getNumberBlock();
				tds.put("block" +nb , new AnonymousBloc(), "Block");
				tds.putLink("block" + nb, newtds);
				for (int j = 0; j < tree.getChildCount(); j++) {
					constructTDSWithoutSemantic(tree.getChild(j), newtds);
				}
				break;

			case "IF":
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDSWithoutSemantic(tree.getChild(j), tds);
				}
				tds.setNumberIf(tds.getNumberIf()+1);
				break;

			case "THEN":
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds);
				nb = tds.getNumberIf();
				tds.put("if" +nb , new If());
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds);
				nb = tds.getNumberIf();
				tds.put("else" +nb , new Else());
				tds.putLink("else" + nb, newtds);
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDSWithoutSemantic(tree.getChild(j), newtds);
				}
				break;

			case "VARS":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDSWithoutSemantic(tree.getChild(i), tds);
				}
				break;

			case "METHODS":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDSWithoutSemantic(tree.getChild(i), tds);
				}
				break;

			case "BODY":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDSWithoutSemantic(tree.getChild(i), tds);
				}
				break;

			case "FOR":
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds);
				nb = tds.getNumberBlock();
				System.out.println("for"+nb);
				tds.put("for" +nb , new ForLoop(), "For");
				tds.putLink("for" + nb, newtds);
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDSWithoutSemantic(tree.getChild(j), newtds);
				}
				break;

			default:
				for (int i = 0; i < tree.getChildCount(); i++) {
					System.out.println("## Default case " + tree);
					constructTDSWithoutSemantic(tree.getChild(i), tds);
				}
				break;
		}
	}

*/

}
