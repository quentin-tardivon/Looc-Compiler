package ASMGenerator;

import TDS.Entry;
<<<<<<< 45cfd452882dd7e7a56bab456f3dcd2089bcf179
=======
import ASMGenerator.instructions.Condition;
import ASMGenerator.instructions.For;
>>>>>>> DOn't worry
import TDS.SymbolTable;
import TDS.entries.Variable;
import core.Keywords;
import org.antlr.runtime.tree.Tree;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by quentin on 29/04/2017.
 * Note: Une adresse 2 octets, un entier 2 octets
 */
public class ASMWriter {

	public static final int INT_SIZE = 2;
	public static final int ADDR_SIZE = 2;
	private static int CPTIF =0;
	private static int CPTFOR =0;
	public static final int CHAR_SIZE = 1;

	private String output;
	private final int offsetEnvironment = INT_SIZE * 3;

	public ASMWriter(String asmFile) {
		this.output = asmFile;
	}


	public static String formatASM(String... params) {
		if (params.length == 3)
			return String.format("%-10s\t\t%-10s\t\t%-10s\n", (Object[]) params); //cast to kill warnings
		if (params.length == 4)
			return String.format("%-10s\t\t%-10s\t\t%-10s\t\t%10s\n", (Object[]) params);

		if (params.length != 3 || params.length != 4) {
			try {
				throw new Exception("Problem with usage of formatASM:\n" + " - Only 3 or 4 params possible !");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	public void generateASMFile(Tree tree, SymbolTable TDS) {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(this.output), "utf-8"))) {
			//Début du programme

			writer.write(formatASM("// ------------- ASM FOR LOOC", "", "\n") +
					formatASM("SP", "EQU", "R15") +
					formatASM("WR", "EQU", "R14") +
					formatASM("BP", "EQU", "R13") +
					formatASM("ST", "EQU", "R12") +

					formatASM("BT", "EQU", "R11") +
					formatASM("SC", "EQU", "R7") +

					formatASM("EXIT_EXC", "EQU", "64") +
					formatASM("READ_EXC", "EQU", "65") +
					formatASM("WRITE_EXC", "EQU", "66\n") +
					formatASM("NUL", "EQU", "0") +
					formatASM("NULL", "EQU", "0") +
					formatASM("NIL", "EQU", "0\n") +


					formatASM("STACK_ADRS", "EQU", "0x1000") +
					formatASM("HEAP_ADRS","EQU","0xF100")+
					formatASM("CLASS_ADRS","EQU","0xFD00")+
					formatASM("LOAD_ADRS", "EQU", "0xFE00\n") +


					formatASM("", "ORG", "LOAD_ADRS") +
					formatASM("", "START", "main_") +
					//formatASM("CHAR","STRING","\"Chienne de caractere\"")+


					formatASM("main_", "LDW", "SP, #STACK_ADRS") +
					formatASM("", "LDW", "R0, #0x0d0a") +
					formatASM("", "STW", "R0, @0x0000") +
					formatASM("", "LDW", "BP, #NIL") +
					formatASM("", "STW", "BP, -(SP)") +
					formatASM("", "LDW", "BP, SP") +

					formatASM("", "LDW","ST, #HEAP_ADRS")+
					formatASM("", "LDW","BT, #NIL")+
					formatASM("", "STW","BT, -(ST)")+
					formatASM("", "LDW","BT, ST") +
					formatASM("", "LDW","SC, #CLASS_ADRS", "// load into SC the base of class descriptors")
			);
			writer.write(ASMUtils.stackStaticAndDynamic());

			this.constructASM(tree, writer, TDS);

			writer.write(formatASM("\n\n\n\n// ------------- FIN DU PGM", "", "\n") +
					formatASM("", "LDW SP, BP", "") +
					formatASM("", "LDW BP, (SP)+", "") +
					formatASM("", "TRP #EXIT_EXC", "") +
					formatASM("", "JEA @main_", "")
			);

			writer.write(itoaDef());


		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to write or create File");
		}
	}


	private void constructASM(Tree tree, Writer writer, SymbolTable TDS) throws IOException {
		int cpt = 0;
		switch (tree.getText()) {
			case "ROOT":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructASM(tree.getChild(i), writer, TDS);
				}
				break;

			case "BODY":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructASM(tree.getChild(i), writer, TDS);
				}
				break;

			case "VAR_DEC":
				if (tree.getChild(1).getText().equals("int")) {
					writer.write(varDecl(INT_SIZE));
				} else if (tree.getChild(1).getText().equals("string")) {
					writer.write(varDecl(ADDR_SIZE));
				}
				break;


			case "AFFECT":


				if(TDS.getInfo(tree.getChild(0).getText()).get(Entry.TYPE).equals(Keywords.STRING)) {
					if (tree.getChild(1).getText().matches("\".*\"")) {
						writer.write(formatASM("", "LDW ",  "R0, #0x0000")) ;
						writer.write(formatASM("", "STW " , "R0, (ST)-" + ADDR_SIZE));
						writer.write(formatASM("","ADQ" , "-" + ADDR_SIZE + ", ST"));
						for (int i = tree.getChild(1).getText().length()-2; i > 0 ; i--) {
							writer.write(varStringAffect(CHAR_SIZE ,  String.format("%04x", (int) tree.getChild(1).getText().charAt(i)).substring(2)));
						}
						writer.write(addToStack("R12"));
						writer.write(varAffect(((Variable)TDS.get(tree.getChild(0).getText())).getDepl()));
					}
					else if (TDS.getInfo(tree.getChild(1).getText()) != null) {
						writer.write(formatASM("", "LDW ",  "R0, (BP)-"+ (this.offsetEnvironment +  ((Variable)TDS.get(tree.getChild(1).getText())).getDepl() ) )) ;
						writer.write(addToStack("R0"));
						writer.write(varAffect(((Variable)TDS.get(tree.getChild(0).getText())).getDepl()));

					}
				} else if (tree.getChild(1).getText().equals("new")) {
					writer.write(classAffect());
				} else {
					constructASM(tree.getChild(1), writer, TDS);
					writer.write(varAffect(((Variable) TDS.get(tree.getChild(0).getText())).getDepl()));
				}


				break;

			case "FOR":
				CPTFOR++;
				int deplIndice;
				int upperBound;
				int lowerBound;
				boolean lowerBoundisRaw=true;
				boolean upperBoundisRaw=true;


				deplIndice=((Variable)TDS.get(tree.getChild(0).getText())).getDepl();


				try{
					lowerBound=Integer.parseInt(tree.getChild(1).getText());
				}catch(NumberFormatException e){
					lowerBound=((Variable)TDS.get(tree.getChild(1).getText())).getDepl();
					upperBoundisRaw=false;
				}

				try{
					upperBound=Integer.parseInt(tree.getChild(2).getText());
				}catch(NumberFormatException e){
					upperBound=((Variable)TDS.get(tree.getChild(2).getText())).getDepl();
					upperBoundisRaw=false;
				}

				forCondition(deplIndice,lowerBound,upperBound,lowerBoundisRaw, upperBoundisRaw, tree,  writer, TDS);
				break;


			case "IF":
				CPTIF++;
				int leftValue;
				int rightValue;
				boolean leftValueisRaw = true;
				boolean rightValueisRaw = true;
				try {
					leftValue = Integer.parseInt(tree.getChild(0).getChild(0).getText());
				} catch (NumberFormatException e) {
					leftValue = ((Variable) TDS.get(tree.getChild(0).getChild(0).getText())).getDepl();
					leftValueisRaw = false;
				}

				try {
					rightValue = Integer.parseInt(tree.getChild(0).getChild(1).getText());
				} catch (NumberFormatException e) {
					rightValue = ((Variable) TDS.get(tree.getChild(0).getChild(1).getText())).getDepl();
					rightValueisRaw = false;
				}

				ifCondition(leftValue, rightValue, tree.getChild(0).getText(), rightValueisRaw, leftValueisRaw, tree, writer, TDS);
				break;


			case "WRITE":
				if (TDS.get(tree.getChild(0).getText()).get("Type").equals("int")) {
					writer.write(itoaCall(((Variable) TDS.get(tree.getChild(0).getText())).getDepl()));
				} else {
					writer.write(printFuncCall(((Variable) TDS.get(tree.getChild(0).getText())).getDepl()));
				}

				break;

			case "CLASS_DEC":
				writer.write(formatASM(tree.getChild(0).getText(), "RSB", "size"));
				break;

			case "PLUS":
				constructASM(tree.getChild(0), writer, TDS);
				constructASM(tree.getChild(1), writer, TDS);
				writer.write(removeFromStack("R1"));
				writer.write(removeFromStack("R2"));
				writer.write(formatASM("", "ADD", "R1, R2, R3"));
				writer.write(addToStack("R3"));

				break;

			case "DIFF":
				constructASM(tree.getChild(0), writer, TDS);
				constructASM(tree.getChild(1), writer, TDS);
				writer.write(removeFromStack("R1"));
				writer.write(removeFromStack("R2"));
				writer.write(formatASM("", "SUB", "R1, R2, R3"));
				writer.write(addToStack("R3"));
				break;

			case "MUL":
				constructASM(tree.getChild(0), writer, TDS);
				constructASM(tree.getChild(1), writer, TDS);
				writer.write(removeFromStack("R1"));
				writer.write(removeFromStack("R2"));
				writer.write(formatASM("", "MUL", "R1, R2, R3"));
				writer.write(addToStack("R3"));
				break;

			case "DIV":
				constructASM(tree.getChild(0), writer, TDS);
				constructASM(tree.getChild(1), writer, TDS);
				writer.write(removeFromStack("R1"));
				writer.write(removeFromStack("R2"));
				writer.write(formatASM("", "DIV", "R1, R2, R3"));
				writer.write(addToStack("R3"));
				break;

			case "THEN":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructASM(tree.getChild(i), writer, TDS);
				}
				break;

			case "ELSE":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructASM(tree.getChild(i), writer, TDS);
				}
				break;

			default:
				if (tree.getText().matches("[-+]?\\d*\\.?\\d+")) { //Cas d'entier
					writer.write(formatASM("", "LDW", "R1, #" + tree.getText()));
					writer.write(addToStack("R1"));
					System.out.println(tree.getText() + "\n");
				} else { //Cas de variable
					System.out.println("Load var" + ((Variable) TDS.get(tree.getText())).getDepl());
					writer.write(loadVar(((Variable) TDS.get(tree.getText())).getDepl()));
					writer.write(addToStack("R1"));
					System.out.println(tree.getText() + "\n");
				}

		}
	}

	private void forCondition(int deplIndice, int lowerBound, int upperBound, boolean lowerBoundisRaw, boolean upperBoundisRaw, Tree tree,  Writer writer, SymbolTable TDS) throws IOException{
		String FORLabel=forLabelMaker(CPTFOR);
		     //for i in 2..3
		if(lowerBoundisRaw&&upperBoundisRaw){

			writer.write (formatASM("","LDW","R0, #"+lowerBound)+
					formatASM("", "STW", "R0, (BP)-" + (this.offsetEnvironment + deplIndice), "// indice = lowerbound "+FORLabel+" : move = " + deplIndice)+
					formatASM(""+FORLabel,"",""));

			constructASM(tree.getChild(3), writer, TDS);

			writer.write (formatASM("","LDW","R8, #"+upperBound));


			//for i in b..2
		}else if(!lowerBoundisRaw&&upperBoundisRaw){

			writer.write (formatASM("" ,"LDW","R0, (BP)-"+(lowerBound+this.offsetEnvironment))+
					formatASM("", "STW", "R0, (BP)-" + (this.offsetEnvironment + deplIndice), "// indice = lowerbound "+FORLabel+" : move = " + deplIndice)+
					formatASM(""+FORLabel,"",""));

			constructASM(tree.getChild(3), writer, TDS);

			writer.write (formatASM("","LDW","R8, #"+upperBound));


			//for i in 2..b
		}else if(lowerBoundisRaw&&!upperBoundisRaw){

			writer.write (formatASM("","LDW","R0, #"+lowerBound)+
					formatASM("", "STW", "R0, (BP)-" + (this.offsetEnvironment + deplIndice), "// indice = lowerbound "+FORLabel+" : move = " + deplIndice)+
					formatASM(""+FORLabel,"",""));

			constructASM(tree.getChild(3), writer, TDS);

			writer.write (formatASM("","LDW","R8, (BP)-"+(upperBound+this.offsetEnvironment)));


			//for i in a..b
		}else {

			writer.write (formatASM("","LDW","R0, (BP)-"+(this.offsetEnvironment + deplIndice))+
					formatASM("", "STW", "R0, (BP)-" + (this.offsetEnvironment + deplIndice), "// indice = lowerbound "+FORLabel+" : move = " + deplIndice)+
					formatASM(""+FORLabel,"",""));

			constructASM(tree.getChild(3), writer, TDS);

			writer.write (formatASM("","LDW","R8, (BP)-"+(upperBound+this.offsetEnvironment)));

		}

		writer.write(formatASM("","LDW","R0, (BP)-"+(this.offsetEnvironment + deplIndice))+
				formatASM("","LDW","R10, #1")+
				formatASM("","ADD","R0, R10, R0")+
				formatASM("", "STW", "R0, (BP)-" + (this.offsetEnvironment + deplIndice), "// indice++ "+FORLabel+" : move = " + deplIndice)+
				formatASM("","CMP","R0, R8")+
				formatASM("","JLW","#" + FORLabel + "-$-2"));

	}


	private void ifCondition(int valueLeft, int valueRight, String comparator, boolean leftValueisRaw, boolean rightValueisRaw, Tree tree, Writer writer, SymbolTable TDS) throws IOException {


		String afterIFLabel=afterIfLabelMaker(CPTIF);
		String IFLabel=ifLabelMaker(CPTIF);

		//if(3>2)
		if (leftValueisRaw && rightValueisRaw) {
			writer.write(formatASM("", "LDW", "R9, #" + valueLeft) +
					formatASM("", "LDW", "R10, #" + valueRight) +
					formatASM("", "CMP", "R9, R10") +
					formatASM("", "" + jumpCondition(comparator), "#" + IFLabel + "-$-2"));

		//if(b>2)
		}else if(leftValueisRaw&&!rightValueisRaw){
            writer.write (formatASM("" ,"LDW","R0, (BP)-"+(valueLeft+this.offsetEnvironment))+
                    formatASM("","LDW", "R10, #"+valueRight)+
                    formatASM("", "CMP", "R0, R10") +
                    formatASM("","" + jumpCondition(comparator),"#" + IFLabel + "-$-2"));

		//if(2>b)
		}else if(!leftValueisRaw&&rightValueisRaw){
		    writer.write(formatASM("" ,"LDW","R0, (BP)-"+valueRight) +
                     formatASM("","LDW","R10, #"+(valueLeft+this.offsetEnvironment))+
					 formatASM("", "CMP", "R0, R10") +
					 formatASM("","" + jumpCondition(comparator),"#" + IFLabel + "-$-2"));

		//if(a>b)
		}else {
            writer.write(formatASM("" ,"LDW","R0, (BP)-"+(valueLeft+this.offsetEnvironment)) +
					 formatASM("" ,"LDW","R10, (BP)-"+(valueRight+this.offsetEnvironment)) +
					 formatASM("", "CMP", "R0, R10") +
					 formatASM("","" + jumpCondition(comparator),"#"+ IFLabel+"-$-2"));
		}

		constructASM(tree.getChild(1), writer, TDS);

		writer.write(formatASM("", "JEA", "@" + afterIFLabel)+
				formatASM(IFLabel, "", ""));

		constructASM(tree.getChild(2), writer, TDS);

		writer.write(formatASM(afterIFLabel, "", ""));

	}


	private String ifLabelMaker(int cpt) {
		String label = "ELSE" + cpt;
		return label;
	}


	private String afterIfLabelMaker(int cpt) {
		String label = "FI" + cpt;
		return label;
	}

	private String forLabelMaker(int cpt){
		String label = "LOOP"+cpt;
		return label;
	}

	private String jumpCondition(String comparator){
		String jump="";
		switch(comparator){

			case "<":
				jump = "JGE";
				break;
			case "<=":
				jump = "JG";
				break;
			case ">":
				jump = "JBE";
				break;
			case ">=":
				jump = "JB";
				break;
			case "==":
				jump = "JNE";
				break;
			case "!=":
				jump = "JE";
				break;
		}
		return jump;
	}


	private String loadVar(int depl) {
		return formatASM("", "LDW", "R1, (BP)-" + (depl + this.offsetEnvironment));
	}


	private String getVar(String reg, int depl) {
		return formatASM("", "LDW " + "" + reg + ", (BP)-" + depl, "");
	}


	private String itoaCall(int depl) {
		return formatASM("", "LDW", "R0, (BP)-" + (offsetEnvironment + depl) + "") +
				formatASM("", "STW", "R0, -(SP)", "// Stack param for 'write' function: move = " + depl) +
				formatASM("", "JSR @itoa_", "") +
				formatASM("", "ADI", "SP, SP, #" + INT_SIZE, "// Unstack params");
	}


	private String itoaDef() {


		return formatASM("\n\n\n\n// ------------- I_TO_A FUNCT", "", "\n") +
				formatASM("ITOA_P", "EQU", "40") +
				formatASM("ITOA_I", "EQU", "4") +
				formatASM("ASCII_MINUS", "EQU", "45") +
				formatASM("ASCII_PLUS", "EQU", "43") +
				formatASM("ASCII_SP", "EQU", "32") +
				formatASM("ASCII_0", "EQU", "48") +
				formatASM("ASCII_A", "EQU", "65") +
				formatASM("itoa_", "STW", "BP, -(SP)") +
				formatASM("", "LDW", "BP, SP") +
				formatASM("", "LDW", "R0, (BP)ITOA_I") +
				formatASM("", "LDW", "R1, #10") +
				formatASM("", "LDQ", "ASCII_SP, R3") +
				formatASM("", "LDQ", "10, WR") +
				formatASM("", "CMP", "R1, WR") +
				formatASM("", "BNE", "NOSIGN-$-2") +
				formatASM("", "LDQ", "ASCII_PLUS, R3") +
				formatASM("", "TST", "R0") +
				formatASM("", "BGE", "POSIT-$-2") +
				formatASM("", "NEG", "R0, R0") +
				formatASM("", "LDQ", "ASCII_MINUS, R3") +
				formatASM("POSIT", "NOP", "") +
				formatASM("NOSIGN", "LDW", "R2, R0") +
				formatASM("CNVLOOP", "LDW", "R0, R2") +
				formatASM("", "SRL", "R1, R1") +
				formatASM("", "ANI", "R0, R4, #1") +
				formatASM("", "SRL", "R0, R0") +
				formatASM("", "DIV", "R0, R1, R2") +
				formatASM("", "SHL", "R0, R0") +
				formatASM("", "ADD", "R0, R4, R0") +
				formatASM("", "SHL", "R1, R1") +
				formatASM("", "ADQ", "-10, R0") +
				formatASM("", "BGE", "LETTER-$-2") +
				formatASM("", "ADQ", "10+ASCII_0, R0") +
				formatASM("", "BMP", "STKCHR-$-2") +
				formatASM("LETTER", "ADQ", "ASCII_A, R0") +
				formatASM("STKCHR", "STW", "R0, -(SP)") +
				formatASM("", "TST", "R2") +
				formatASM("", "BNE", "CNVLOOP-$-2", "// Les caractères sont empilés gauche en haut, droite en bas") +

				formatASM("", "LDW", "R1, #ITOA_P") + //20 par défaut pour l'instant
				formatASM("", "STB", "R3, (R1)+") +
				formatASM("CPYLOOP", "LDW", "R0, (SP)+") +
				formatASM("", "STB", "R0, (R1)+") +
				formatASM("", "CMP", "SP, BP") +
				formatASM("", "BNE", "CPYLOOP-$-2") +
				formatASM("", "LDQ", "NUL, R0") +
				formatASM("", "STB", "R0, (R1)+") +

				formatASM("", "LDW", "R0, #ITOA_P", "// Pointeur sur chaine de caract") +
				formatASM("", "TRP", "#WRITE_EXC") +
				formatASM("", "LDW", "R0, #0x0000", "// Pointeur sur retour ligne") +
				formatASM("", "TRP", "#WRITE_EXC") +
				formatASM("", "LDW", "SP, BP") +
				formatASM("", "LDW", "BP, (SP)+") +
				formatASM("", "RTS", "");


	}


	private String printFuncCall(int depl) { //Equivalent à charger une fonction classique, inspiration
		return formatASM("", "LDW", "R0, (BP)-" + (offsetEnvironment + depl) + "") +
				formatASM("", "TRP", "#WRITE_EXC") +
				formatASM("", "LDW", "R0, #0x0000") +
				formatASM("", "TRP", "#WRITE_EXC");
	}


	private String defPrintFunc() {
		return formatASM("\n\n\n\n// ------------- PRINT FUNCT", "", "\n") +
				//formatASM("print_", "LDW", "R0, (BP)" + ADDR_SIZE) +
				formatASM("", "TRP", "#WRITE_EXC") +
				formatASM("", "RTS", "");
	}

<<<<<<< 45cfd452882dd7e7a56bab456f3dcd2089bcf179
	public void stackStaticAndDynamic(Writer w) throws IOException {
		w.write(formatASM("", "STW", "BP, -(SP)", "// Stack the dynamic link") +
				formatASM("", "STW", "BP, -(SP)", "// Stack the static link"));
	}

	

	private String varAffect(int depl) {
		return removeFromStack("R1") +
				formatASM("", "LDW", "R0, R1") +
				formatASM("", "STW", "R0, (BP)-" + (this.offsetEnvironment + depl), "// Affection: move = " + depl);
	}

=======

	private void constructASM(Tree tree, Writer writer, SymbolTable TDS) throws IOException {
		int cpt=0;
		switch(tree.getText()) {
			case "ROOT":
				for (int i = 0; i < tree.getChildCount(); i++) {
					ArrayList<Generable> l = new ArrayList<Generable>();
					ASMParser.parse(tree.getChild(i), TDS, l);
					generateInstructions(writer, l);
					//constructASM(tree.getChild(i), writer, TDS);
					//constructASM(tree.getChild(i), writer, TDS);

				}

				break;

			case "VAR_DEC":
				if (tree.getChild(1).getText().equals("int")) {
					writer.write(varDecl(INT_SIZE));
				}
				else if(tree.getChild(1).getText().equals("string")) {
					writer.write(varDecl(ADDR_SIZE));
				}
				break;

			case "AFFECT":

				if(TDS.getInfo(tree.getChild(0).getText()).get(Entry.TYPE).equals(Keywords.STRING)) {
					if (tree.getChild(1).getText().matches("\".*\"")) {
						writer.write(formatASM("", "LDW ",  "R0, #0x0000")) ;
						writer.write(formatASM("", "STW " , "R0, (ST)-" + ADDR_SIZE));
						writer.write(formatASM("","ADQ" , "-" + ADDR_SIZE + ", ST"));
						for (int i = tree.getChild(1).getText().length()-2; i > 0 ; i--) {
							writer.write(varStringAffect(CHAR_SIZE ,  String.format("%04x", (int) tree.getChild(1).getText().charAt(i)).substring(2)));
						}
						writer.write(addToStack("R12"));
						writer.write(varAffect(((Variable)TDS.get(tree.getChild(0).getText())).getDepl()));
					}
					//else if (TDS.getInfo(tree.getChild(1).getText()))

				}
				else if (tree.getChild(1).getText().equals("new")) {
					writer.write(classAffect());
				}
				else {
					constructASM(tree.getChild(1), writer, TDS);
					writer.write(varAffect(((Variable)TDS.get(tree.getChild(0).getText())).getDepl()));
				}

				break;

			case "FOR":
				writer.write(new For(new Condition(), new Block()).generate());
				break;

			case "IF":
				CPT++;
				int leftValue;
				int rightValue;
				boolean leftValueisRaw=true;
				boolean rightValueisRaw=true;
				try{
					leftValue=Integer.parseInt(tree.getChild(0).getChild(0).getText());
				}catch(NumberFormatException e){
					leftValue=((Variable)TDS.get(tree.getChild(0).getChild(0).getText())).getDepl();
					leftValueisRaw=false;
				}

				try{
					rightValue=Integer.parseInt(tree.getChild(0).getChild(1).getText());
				}catch(NumberFormatException e){
					rightValue=((Variable)TDS.get(tree.getChild(0).getChild(1).getText())).getDepl();
					rightValueisRaw=false;
				}

				ifCondition(leftValue,rightValue,tree.getChild(0).getText(),rightValueisRaw, leftValueisRaw, tree,  writer, TDS);
				break;
>>>>>>> DOn't worry


	private String classAffect() {
		return formatASM("", "Here comes a Class ADDR", "");
	}

<<<<<<< 45cfd452882dd7e7a56bab456f3dcd2089bcf179
=======
			case "CLASS_DEC":
				//writer.write(formatASM(tree.getChild(0).getText(), "RSB", "size"));
				ArrayList<Generable> l = new ArrayList<Generable>();
				l = ASMParser.parse(tree, TDS, l);
				generateInstructions(writer, l);
				break;
>>>>>>> DOn't worry

	public String addConst(int constante, int depl) {
		getVar("R1", depl);
		return formatASM("", "ADQ", constante + ", R1");
	}

	private String varStringAffect(int depl, String charValue) {
		return formatASM("", "LDB ", "R0, #0x" + charValue + "00") +
				formatASM("", "STB ", "R0, (ST)-" + depl) +
				formatASM("", "ADQ", "-" + depl + ", ST");
	}

	private String varDecl(int deplType) {
		return formatASM("", "ADI", "SP, SP, #-" + deplType);
	}


	public String addToStack(String reg) {
		/*return formatASM("", "ADQ", "-2, SP") +
				formatASM("", "STW", reg + ", (SP)");*/
		return formatASM("", "STW", reg + ", -(SP)");
	}


	private String removeFromStack(String reg) {
		return formatASM("", "LDW", reg + ", (SP)") +
				formatASM("", "ADQ", "2, SP");
	}


	private String linkR(int R) {
		return formatASM("", "ADQ", "-2, SP") +
				formatASM("", "STW", "BP, (SP)") +
				//Charger les param ici pour une func
				formatASM("", "LDW", "BP, SP");
	}


	private String unlink() {
		return formatASM("", "LDW", "SP, BP") +
				formatASM("", "LDW", "BP, (SP)") +
				formatASM("", "ADQ", "2, SP");
	}

	public void generateInstructions(Writer w, ArrayList<Generable> l) throws IOException {
		for(Generable g: l) {
			w.write(g.generate());
		}
	}
}
