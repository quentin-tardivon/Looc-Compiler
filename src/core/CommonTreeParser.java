package core;

import TDS.Entry;
import TDS.SymbolTable;
import TDS.entries.*;
import TDS.entries.Class;
import exceptions.LoocException;
import exceptions.MismatchTypeException;
import org.antlr.runtime.tree.Tree;
import utils.EnvironmentCounter;
import utils.Util;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by quentin on 13/03/2017.
 */
public class CommonTreeParser {

	private SymbolTable tds;
	//private String filename;
	public static Tree node;
	public static String filename;
	private ArrayList<String> list = new ArrayList<>();
	private int currentLine = 0;
	private List<LoocException> exceptions;
	public  static int depl;
	private EnvironmentCounter counter = new EnvironmentCounter();

	public CommonTreeParser(String filename) {
		CommonTreeParser.filename = filename;
		this.exceptions = new ArrayList<>();
	}

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
		//this.printCurrentLine(tree);
		CommonTreeParser.node = tree;

		switch (tree.getText()) {
			case "ROOT":
				depl=0;
				this.tds = tds;
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDS(tree.getChild(i), this.tds, rootTDS);
				}
				break;


			case "METHOD":
				depl=0;
				//System.out.println("Method encounter:" + tree.getChild(0).toString());
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, tree.getChild(0).getText());
				tds.putLink(tree.getChild(0).getText(), newtds);

				//cas méthode avec type de retour et avec paramètres
				if (tree.getChildCount() == 4) {
					try {
						tds.put(tree.getChild(0).getText(), new Method(tree.getChild(2).getText()));
					}
					catch (LoocException e) {
						this.exceptions.add(e);
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
					catch (LoocException e) {
						this.exceptions.add(e);
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
					catch (LoocException e) {
						this.exceptions.add(e);
						e.printStackTrace();
					}
					constructTDS(tree.getChild(2), newtds, rootTDS);
				}
				//cas méthode sans type de retour et sans paramètres
				else {
					try {
						tds.put(tree.getChild(0).getText(), new Method());
					}
					catch (LoocException e) {
						this.exceptions.add(e);
						e.printStackTrace();
					}
					constructTDS(tree.getChild(1), newtds, rootTDS);
				}

				break;

			case "FORMAL_PARAMS":
				depl=0;
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDS(tree.getChild(i), tds, rootTDS);
				}
				break;

			case "FORMAL_PARAM":
				try {
					tds.put(tree.getChild(0).getText(), new Parameter(tree.getChild(1).getText(), tree.getChildIndex()));
				}
				catch (LoocException e) {
					this.exceptions.add(e);
					e.printStackTrace();
				}
				break;

			case "VAR_DEC":
				Variable var = new Variable(tree.getChild(1).getText(),depl);
				var.setInit(false);
				switch(tree.getChild(1).getText()){
					case "int":
						depl+=2;
						break;
					case "string":
						depl+=2;
						break;
					default:
						depl+=0;
						break;
				}
				try {
					tds.put(tree.getChild(0).getText(), var);
				}
				catch (LoocException e) {
					this.exceptions.add(e);
					System.err.println( e.getClass().getName() + " " + e.getMessage());
				}
				break;

			case "CLASS_DEC":
				depl=0;
				Class newClass = new Class(tree.getChild(0).getText());
				String quentin = tree.getChild(0).getText();
				SymbolTable parentTDS = rootTDS;
				if (!(tree.getChild(1).getText().equals("METHODS") || tree.getChild(1).getText().equals("VARS"))) {
					if (rootTDS.findClass(tree.getChild(1).getText()) == null) {
						try {
							Util.undeclaredInheritance(tree.getChild(1).getText(), tds);
						}
						catch (LoocException e) {
							this.exceptions.add(e);
							System.err.println( e.getClass().getName() + " " + e.getMessage());
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
				catch (LoocException e) {
					this.exceptions.add(e);
					System.err.println( e.getClass().getName() + " " + e.getMessage());
				}
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, parentTDS, tree.getChild(0).getText()); //Attention, l'imbrication level correspond ici au niveau d'héritage
				parentTDS.putClass(tree.getChild(0).getText(), newtds);

				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds, rootTDS);
				}
				break;


			case "BLOCK":
				depl=0;
				String blockID = EnvironmentCounter.generateID(Entry.ANONYMOUS_BLOC, this.counter.incrementBlock(), tds.getImbricationLevel() + 1);
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, blockID);
				try {
					tds.put(blockID , new AnonymousBloc(), Entry.ANONYMOUS_BLOC);
					tds.putLink(blockID, newtds);
				}
				catch (LoocException e) {
					this.exceptions.add(e);
					e.printStackTrace();
				}
				for (int j = 0; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds, rootTDS);
				}
				break;

			case "IF":
				depl=0;
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), tds, rootTDS);
				}
				//tds.setNumberIf(tds.getNumberIf()+1);
				break;

			case "THEN":
				depl=0;
				int nb = counter.incrementIf();
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, "if" + nb);
				try {
					tds.put("if" +nb , new If());
					tds.putLink("if" + nb, newtds);
				}
				catch (LoocException e) {
					this.exceptions.add(e);
					e.printStackTrace();
				}
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds, rootTDS);
				}
				break;

			case "ELSE":
				depl=0;
				nb = this.counter.incrementIf();
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, "else" + nb);
				try {
					tds.put("else" +nb , new Else());
					tds.putLink("else" + nb, newtds);
				}
				catch (LoocException e) {
					this.exceptions.add(e);
					e.printStackTrace();
				}
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds, rootTDS);
				}
				break;

			case "VARS":
				depl=0;
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDS(tree.getChild(i), tds, rootTDS);
				}
				break;

			case "METHODS":
				depl=0;
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDS(tree.getChild(i), tds, rootTDS);
				}
				break;


			case "BODY":
				depl=0;
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructTDS(tree.getChild(i), tds, rootTDS);
				}
				break;


			case "AFFECT":
				depl=0;
				try {
					Util.testAffectation(tree, tds, rootTDS);
				}
				catch (LoocException e) {
					this.exceptions.add(e);
					System.err.println( e.getClass().getName() + " " + e.getMessage());
				}
					break;



			case "FOR":
				depl=0;
				nb = this.counter.getCountFor();
				String forID = "FOR_" + tds.getImbricationLevel() + 1 + "_" + nb;
				newtds = new SymbolTable(tds.getImbricationLevel() + 1, tds, forID);
				try {
					tds.put(forID, new ForLoop(), Entry.FOR);
					tds.putLink(forID, newtds);
				}
				catch (LoocException e) {
					this.exceptions.add(e);
					System.err.println( e.getClass().getName() + " " + e.getMessage());
				}
				//TODO Further testing on for loop
				tds.getInfo(tree.getChild(0).getText()).setInit(true);
				for (int j = 1; j < tree.getChildCount(); j++) {
					constructTDS(tree.getChild(j), newtds, rootTDS);
				}
				break;

			case "DO":
				depl=0;
				try {
					Util.testDo(tree.getChild(0), tds, rootTDS);
				}
				catch (LoocException e) {
					this.exceptions.add(e);
					System.err.println( e.getClass().getName() + " " + e.getMessage());
				}
				break;

			case "RETURN":
				depl=0;
				String realV = Util.subTreeType(tree.getChild(0), tds, rootTDS);
				String expectedV = tds.getFather().get(tds.getName()).get(Entry.RETURN_TYPE);

				try {
					Util.testReturnType(expectedV,realV);
				}
				catch (LoocException e) {
					this.exceptions.add(e);
					System.err.println( e.getClass().getName() + " " + e.getMessage());
				}
				break;

			case "READ":
				depl=0;
				realV = Util.subTreeType(tree.getChild(0), tds, rootTDS);
				try {
					Util.testReadUse(realV);
				}
				catch (LoocException e) {
					this.exceptions.add(e);
					System.err.println( e.getClass().getName() + " " + e.getMessage());
				}
				break;

			case "WRITE":
				depl=0;
				try {
					realV = Util.subTreeType(tree.getChild(0), tds, rootTDS);
					Util.testWriteUse(realV);
				}
				catch (LoocException e) {
					this.exceptions.add(e);
					System.err.println( e.getClass().getName() + " " + e.getMessage());
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

	public List<LoocException> getExceptions() {
		return this.exceptions;
	}

}
