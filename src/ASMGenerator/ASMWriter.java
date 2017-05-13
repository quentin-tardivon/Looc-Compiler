package ASMGenerator;

import TDS.Entry;
import ASMGenerator.instructions.Block;
import ASMGenerator.instructions.Condition;
import ASMGenerator.instructions.For;
import TDS.SymbolTable;
import TDS.entries.Variable;
import core.Keywords;
import org.antlr.runtime.tree.Tree;

import java.io.*;

/**
 * Created by quentin on 29/04/2017.
 * Note: Une adresse 2 octets, un entier 2 octets
 */
public class ASMWriter {

	public static final int INT_SIZE = 2;
	public static final int ADDR_SIZE = 2;
	public static final int CHAR_SIZE = 2;
	private static int CPT =0;
	private String output;
	private final int offsetEnvironment = INT_SIZE * 3;

	public ASMWriter(String asmFile) {
		this.output = asmFile;
	}


	public static String formatASM(String...params) {
		if(params.length == 3)
			return String.format("%-10s\t\t%-10s\t\t%-10s\n", (Object[])params); //cast to kill warnings
		if(params.length == 4)
			return String.format("%-10s\t\t%-10s\t\t%-10s\t\t%10s\n", (Object[])params);

		if(params.length != 3 || params.length != 4) {
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
					formatASM("BT", "EQU", "R11\n") +

					formatASM("EXIT_EXC", "EQU", "64") +
					formatASM("READ_EXC", "EQU", "65") +
					formatASM("WRITE_EXC", "EQU", "66\n") +
					formatASM("NUL", "EQU", "0") +
					formatASM("NULL", "EQU", "0") +
					formatASM("NIL", "EQU", "0\n") +



					formatASM("STACK_ADRS", "EQU", "0x1000") +
					formatASM("HEAP_ADRS","EQU","0xFD00")+
					formatASM("LOAD_ADRS", "EQU", "0xFE00\n") +


					formatASM("", "ORG", "LOAD_ADRS") +
					formatASM("", "START", "main_") +
					//formatASM("CHAR","STRING","\"Chienne de caractere\"")+


					formatASM("main_", "LDW", "SP, #STACK_ADRS") +
					formatASM("", "LDW", "BP, #NIL") +
					formatASM("", "STW", "BP, -(SP)") +
					formatASM("", "LDW", "BP, SP") +

					formatASM("", "LDW","ST, #HEAP_ADRS")+
					formatASM("", "LDW","BT, #NIL")+
					formatASM("", "STW","BT, -(ST)")+
					formatASM("", "LDW","BT, ST")

			);
			this.stackStaticAndDynamic(writer);

			this.constructASM(tree, writer, TDS);

			writer.write(formatASM("\n\n\n\n// ------------- FIN DU PGM", "", "\n") +
					formatASM("", "LDW SP, BP", "") +
					formatASM("", "LDW BP, (SP)+", "") +
					formatASM("", "LDW ST, BT", "") +
					formatASM("", "LDW BT, (ST)+", "") +
					formatASM("", "TRP #EXIT_EXC", "") +
					formatASM("", "JEA @main_", "")
			);

			writer.write(itoaDef());


		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to write or create File");
		}
	}

	private void constructASM(Tree tree, Writer writer, SymbolTable TDS) throws IOException {
		int cpt=0;
		switch(tree.getText()) {
			case "ROOT":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructASM(tree.getChild(i), writer, TDS);
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
						//writer.write(addStringToStack(((Variable)TDS.get(tree.getChild(0).getText())).getDepl()));
						writer.write(addToStack("R12"));
						writer.write(varAffect(((Variable)TDS.get(tree.getChild(0).getText())).getDepl()));
						for (int i = 1; i < tree.getChild(1).getText().length() - 1; i++) {
							writer.write(varStringAffect(2 , (int) tree.getChild(1).getText().charAt(i)));
							//writer.write(addToHeap(2));
							System.out.println(tree.getChild(1).getText().charAt(i));
						}
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


			case "WRITE":
				if (TDS.get(tree.getChild(0).getText()).get("Type").equals("int")) {
					writer.write(itoaCall(((Variable)TDS.get(tree.getChild(0).getText())).getDepl()));
				}
				else {
					writer.write(printFuncCall(((Variable)TDS.get(tree.getChild(0).getText())).getDepl()));
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
				}

				else { //Cas de variable
					loadVar(((Variable)TDS.get(tree.getText())).getDepl());
					writer.write(addToStack("R1"));
					System.out.println(tree.getText() + "\n");
				}

		}
	}


	private void ifCondition(int valueLeft, int valueRight, String comparator, boolean leftValueisRaw, boolean rightValueisRaw, Tree tree, Writer writer, SymbolTable TDS) throws IOException{


		String afterIFLabel=afterIfLabelMaker(CPT);
		String IFLabel=ifLabelMaker(CPT);
		//if(3>2)
		if(leftValueisRaw&&rightValueisRaw){
			 writer.write (formatASM("","LDW","R9, #"+valueLeft)+
					 formatASM("","LDW","R10, #"+valueRight)+
					 formatASM("", "CMP", "R9, R10") +
					 formatASM("","" + jumpCondition(comparator),"#" + IFLabel + "-$-2"));

			         constructASM(tree.getChild(1), writer, TDS);

            writer.write(formatASM("", "JEA", "@" + afterIFLabel )+
					 formatASM(IFLabel, "", ""));

			         constructASM(tree.getChild(2), writer, TDS);

            writer.write(formatASM(afterIFLabel, "", ""));

		//if(b>2)
		}else if(leftValueisRaw&&!rightValueisRaw){


            writer.write (formatASM("" ,"LDW","R0, (BP)-"+valueLeft)+
                    formatASM("","LDW", "R10, #"+valueRight)+
                    formatASM("", "CMP", "R0, R10") +
                    formatASM("","" + jumpCondition(comparator),"#" + IFLabel + "-$-2"));

                    constructASM(tree.getChild(1), writer, TDS);

            writer.write(formatASM("", "JEA", "@" + afterIFLabel)+
                    formatASM(IFLabel, "", ""));
                    constructASM(tree.getChild(2), writer, TDS);
                    writer.write(formatASM(afterIFLabel, "", ""));


		//if(2>b)
		}else if(!leftValueisRaw&&rightValueisRaw){

		    writer.write(formatASM("" ,"LDW","R0, (BP)-"+valueRight) +
                     formatASM("","LDW","R10, #"+valueLeft)+
					 formatASM("", "CMP", "R0, R10") +
					 formatASM("","" + jumpCondition(comparator),"#" + IFLabel + "-$-2"));

					 constructASM(tree.getChild(1), writer, TDS);

            writer.write(formatASM("", "JEA", "@" + afterIFLabel)+
					 formatASM(IFLabel, "", ""));

			         constructASM(tree.getChild(2), writer, TDS);

            writer.write(formatASM(afterIFLabel, "", ""));

		//if(a>b)
		}else {
            writer.write(formatASM("" ,"LDW","R0, (BP)-"+valueLeft) +
					 formatASM("" ,"LDW","R10, (BP)-"+valueRight) +
					 formatASM("", "CMP", "R0, R10") +
					 formatASM("","" + jumpCondition(comparator),"#"+ IFLabel+"-$-2"));

			         constructASM(tree.getChild(1), writer, TDS);

            writer.write(formatASM("", "JEA", "@" + afterIFLabel)+
					 formatASM(IFLabel, "", ""));

					 constructASM(tree.getChild(2), writer, TDS);

            writer.write(formatASM(afterIFLabel, "", ""));
		}
	}


	private String ifLabelMaker(int cpt){
		String label = "ELSE"+cpt;
		return label;
	}


	private String afterIfLabelMaker(int cpt){
		String label = "FI"+cpt;
		return label;
	}


	private String jumpCondition(String comparator){
		String jump="";
		switch(comparator){
			case "<":
				jump="JGE";
				break;
			case "<=":
				jump="JG";
				break;
			case ">":
				jump="JBE";
				break;
			case ">=":
				jump="JB";
				break;
			case "==":
				jump="JNE";
				break;
			case "!=":
				jump="JE";
				break;
		}
		return jump;
	}


	private String loadVar(int depl) {
		return formatASM("", "LDW", "R1, (BP)-" + depl);
	}


	private String getVar(String reg, int depl) {
		return formatASM("", "LDW " +
				"" + reg + ", (BP)-" + depl, "");
	}


	private String itoaCall(int depl) {
		return formatASM("", "LDW", "R0, (BP)-" + (offsetEnvironment + depl) + "") +
				formatASM("", "STW", "R0, -(SP)", "// Stack param for 'write' function: move = " + depl) +
				formatASM("","JSR @itoa_", "") +
				formatASM("","ADI", "SP, SP, #" + INT_SIZE, "// Unstack params");
	}


	private String itoaDef() {


		return  formatASM("\n\n\n\n// ------------- I_TO_A FUNCT", "", "\n") +
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
				formatASM("", "LDW", "SP, BP") +
				formatASM("", "LDW", "BP, (SP)+") +
				formatASM("", "RTS", "");



	}


	private String printFuncCall(int depl) { //Equivalent à charger une fonction classique, inspiration
		return formatASM("", "LDW", "R0, (BP)-" + (offsetEnvironment + depl) + "") +
						formatASM("", "TRP", "#WRITE_EXC");
	}


	public void stackStaticAndDynamic(Writer w) throws IOException {
		w.write(formatASM("", "STW", "BP, -(SP)", "// Stack the dynamic link") +
				formatASM("", "STW", "BP, -(SP)", "// Stack the static link"));
	}


	private String varDecl(int deplType) {
		return formatASM("", "ADI", "SP, SP, #-" + deplType);
	}


	private String addToHeap(int depl){
		return formatASM("","ADQ" , "-" + depl + ", ST");
	}


	private String varStringAffect(int depl,int charValue){
		return formatASM("", "LDW ",  "R0, #" + charValue) +
				formatASM("", "STW " , "R0, (ST)-" + depl)+
				formatASM("","ADQ" , "-" + depl + ", ST");
	}


	private String addStringToStack(int depl) {
		return //formatASM("","LDW R0, (R12)","")+
				formatASM("","STW ", "R12, (SP)-" + depl);
	}


	private String varAffect(int depl) {
		return removeFromStack("R1")+
				formatASM("", "LDW", "R0, R1") +
				formatASM("", "STW", "R0, (BP)-" + (this.offsetEnvironment + depl), "// Affection: move = " + depl);
	}


	private String classAffect() {
		return formatASM("", "Here comes a Class ADDR", "");
	}


	public String addConst(int constante, int depl) {
		getVar("R1", depl);
		return formatASM("", "ADQ", constante + ", R1");
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

}
