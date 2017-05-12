package ASMGenerator;

import ASMGenerator.instructions.Block;
import ASMGenerator.instructions.Condition;
import ASMGenerator.instructions.For;
import TDS.SymbolTable;
import TDS.entries.Variable;
import org.antlr.runtime.tree.Tree;

import java.io.*;

/**
 * Created by quentin on 29/04/2017.
 * Note: Une adresse 2 octets, un entier 2 octets
 */
public class ASMWriter {

	public static final int INT_SIZE = 2;
	private static int CPT =0;
	private String output;
	private final int offsetEnvironment = INT_SIZE * 3;

	public ASMWriter(String asmFile) {
		this.output = asmFile;
	}


	public static String formatASM(String...params) {
		if(params.length == 3)
			return String.format("%-10s\t\t%-10s\t\t%-10s\n", params);
		if(params.length == 4)
			return String.format("%-10s\t\t%-10s\t\t%-10s\t\t%10s\n", params);

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
					formatASM("BP", "EQU", "R13\n") +
					formatASM("EXIT_EXC", "EQU", "64") +
					formatASM("READ_EXC", "EQU", "65") +
					formatASM("WRITE_EXC", "EQU", "66\n") +
					formatASM("NUL", "EQU", "0") +
					formatASM("NULL", "EQU", "0") +
					formatASM("NIL", "EQU", "0\n") +

					formatASM("STACK_ADRS", "EQU", "0x1000") +
					formatASM("LOAD_ADRS", "EQU", "0xFE00\n") +
					formatASM("", "ORG", "LOAD_ADRS") +
					formatASM("", "START", "main_") +

					formatASM("main_", "LDW", "SP, #STACK_ADRS") +
					formatASM("", "LDW", "BP, #NIL") +
					formatASM("", "STW", "BP, -(SP)") +
					formatASM("", "LDW", "BP, SP")
			);
			this.stackStaticAndDynamic(writer);

			this.constructASM(tree, writer, TDS);

			writer.write(formatASM("\n\n\n\n// ------------- FIN DU PGM", "", "\n") +
					formatASM("", "LDW SP, BP", "") +
					formatASM("", "LDW BP, (SP)+", "") +
					formatASM("", "TRP #EXIT_EXC", "") +
					formatASM("", "JEA @main_", "")
			);

			writer.write(defPrintFunc());


		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to write or create File");
		}
	}

	private String varDecl(int deplType) {
		return formatASM("", "ADI", "SP, SP, #-" + deplType);
	}


	private String varAffect(int depl) {
		return removeFromStack("R1")+
				formatASM("", "LDW", "R0, R1") +
				formatASM("", "STW", "R0, (BP)-" + (this.offsetEnvironment + depl), "// Affection: move = " + depl);
	}


	private String classAffect() {
		return formatASM("", "Here comes a Class ADDR", "");
	}


	private String addToStack(String reg) {
		return formatASM("", "ADQ", "-2, SP") +
				formatASM("", "STW", reg + ", (SP)");
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

	private void ifCondition(int valueLeft, int valueRight, String comparator, boolean leftValueisRaw, boolean rightValueisRaw, Tree tree, Writer writer, SymbolTable TDS) throws IOException{


		String afterIFLabel=afterIfLabelMaker(CPT);
		String IFLabel=ifLabelMaker(CPT);
		//if(3>2)
		if(leftValueisRaw&&rightValueisRaw){
			 writer.write (formatASM("", "CMP", "#" + valueLeft + ", #" + valueRight) +
					 formatASM("","" + jumpCondition(comparator),"@" + IFLabel));

			         constructASM(tree.getChild(1), writer, TDS);

			         writer.write(formatASM("", "JEA", "@" + afterIFLabel)+
					 formatASM(IFLabel, "EQU", "$"));


			         constructASM(tree.getChild(2), writer, TDS);

			         writer.write(formatASM(afterIFLabel, "EQU", "$"));

		//if(b>2)
		}else if(leftValueisRaw&&!rightValueisRaw){


			   		 writer.write (formatASM("" ,"LDW","R0, (BP)-"+valueLeft) +
			 		 formatASM("", "CMP", "R0, #"+ valueRight) +
					 formatASM("","" + jumpCondition(comparator),"@" + IFLabel));

			         constructASM(tree.getChild(1), writer, TDS);

			         writer.write(formatASM("", "JEA", "@" + afterIFLabel)+
					 formatASM(IFLabel, "EQU", "$"));

					 constructASM(tree.getChild(2), writer, TDS);

			         writer.write(formatASM(afterIFLabel, "EQU", "$"));


		//if(2>b)
		}else if(!leftValueisRaw&&rightValueisRaw){
					 writer.write(formatASM("" ,"LDW","R0, (BP)-"+valueRight) +
					 formatASM("", "CMP", "R0, #"+ valueLeft) +
					 formatASM("","" + jumpCondition(comparator),"@" + IFLabel));

					 constructASM(tree.getChild(1), writer, TDS);

					 writer.write(formatASM("", "JEA", "@" + afterIFLabel)+
					 formatASM(IFLabel, "EQU", "$"));

			         constructASM(tree.getChild(2), writer, TDS);

					 writer.write(formatASM(afterIFLabel, "EQU", "$"));

		//if(a>b)
		}else {
			         writer.write(formatASM("" ,"LDW","R0, (BP)-"+valueLeft) +
					 formatASM("" ,"LDW","R1, (BP)-"+valueRight) +
					 formatASM("", "CMP", valueLeft+", "+ valueRight) +
					 formatASM("","" + jumpCondition(comparator),"@" + IFLabel));

			         constructASM(tree.getChild(1), writer, TDS);

					 writer.write(formatASM("", "JEA", "@" + afterIFLabel)+
					 formatASM(IFLabel, "EQU", "$"));

					 constructASM(tree.getChild(2), writer, TDS);

			         writer.write(formatASM(afterIFLabel, "EQU", "$"));
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
		return formatASM("", "LDW" + reg + ", (BP)-" + depl, "");
	}

	private String defPrintFunc() {
		return formatASM("\n\n\n\n// ------------- PRINT FUNCT", "", "\n") +
				formatASM("print_", "LDW", "R0, (BP)0") +
				formatASM("", "TRP", "#WRITE_EXC") +
				formatASM("", "RTS", "");
	}


	private String itoaCall() {
		return formatASM("","LDW R0, #10", "") +
				formatASM("","STW R0, -(SP)", "") +
				formatASM("","ADI BP, R0, #-8", "") +
				formatASM("","STW R0, -(SP)", "") +
				formatASM("","LDW R0, (BP)-10", "") +
				formatASM("","STW R0, -(SP)", "") +
				formatASM("","JSR @itoa_", "") +
				formatASM("","ADI SP, SP, #6", "");
	}

	private String itoaDef() {



		return formatASM("", "ITOA_I      equ 4 ", "") +
				formatASM("", "ITOA_P      equ 6 ", "") +
				formatASM("", "ITOA_B      equ 8", "") +
				formatASM("", "ASCII_MINUS equ 45 ", "") +
				formatASM("", "ASCII_PLUS  equ 43", "") +
				formatASM("", "ASCII_SP    equ 32", "") +
				formatASM("", "ASCII_0     equ 48", "") +
				formatASM("", "ASCII_A     equ 65", "") +
				formatASM("", "itoa_  STW BP, -(SP)", "") +
				formatASM("", "LDW BP, SP", "") +
				formatASM("", "LDW R0, (BP)ITOA_I", "") +
				formatASM("", "LDW R1, (BP)ITOA_", "") +
				formatASM("", "LDQ ASCII_SP, R3", "") +
				formatASM("", "LDQ 10, WR", "") +
				formatASM("", "CMP R1, WR", "") +
				formatASM("", "BNE NOSIGN-$-2", "") +
				formatASM("", "LDQ ASCII_PLUS, R3", "") +
				formatASM("", "TST R0", "") +
				formatASM("", "BGE POSIT-$-2", "") +
				formatASM("", "NEG R0, R0", "") +
				formatASM("", "LDQ ASCII_MINUS, R3", "") +
				formatASM("", "POSIT   NOP ", "") +
				formatASM("", "NOSIGN  LDW R2, R0 ", "") +
				formatASM("", "CNVLOOP LDW R0, R2", "") +
				formatASM("", "SRL R1, R1", "") +
				formatASM("", "ANI R0, R4, #1", "") +
				formatASM("", "SRL R0, R0", "") +
				formatASM("", "DIV R0, R1, R2", "") +
				formatASM("", "SHL R0, R0", "") +
				formatASM("", "ADD R0, R4, R0", "") +
				formatASM("", "SHL R1, R1", "") +
				formatASM("", "ADQ -10, R0 ", "") +
				formatASM("", "BGE LETTER-$-2", "") +
				formatASM("", "ADQ 10+ASCII_0, R0", "") +
				formatASM("", "BMP STKCHR-$-2", "") +
				formatASM("", "LETTER  ADQ ASCII_A, R0", "") +
				formatASM("", "STKCHR  STW R0, -(SP)", "") +
				formatASM("", "TST R2", "") +
				formatASM("", "BNE CNVLOOP-$-2", "") +
				formatASM("", "LDW R1, (BP)ITOA_P", "") +
				formatASM("", "STB R3, (R1)+", "") +
				formatASM("", "CPYLOOP LDW R0, (SP)+", "") +
				formatASM("", "STB R0, (R1)+", "") +
				formatASM("", "CMP SP, BP", "") +
				formatASM("", "BNE CPYLOOP-$-2", "") +
				formatASM("", "LDQ NUL, R0", "") +
				formatASM("", "STB R0, (R1)+", "") +
				formatASM("", "LDW R0, (BP)ITOA_P ", "") +
				formatASM("", "LDW SP, BP ", "") +
				formatASM("", "LDW BP, (SP)+", "") +
				formatASM("", "RTS", "");

	}


	private String printFuncCall(int depl) { //Equivalent à charger une fonction classique, inspiration
		return formatASM("", "ADQ -2, SP", "") +
				formatASM("", "STW BP, (SP)", "") +
				//Charger les param ici pour une func
				formatASM("", "LDW" + depl, "R0, (BP)-") +
				formatASM("", "STW", "R0, -(SP)") +
				formatASM("", "LDW", "BP, SP") +
				formatASM("", "JSR", "@print_") +
				formatASM("", "LDW", "SP, BP") +
				formatASM("", "LDW", "BP, (SP)") +
				formatASM("", "ADQ", "2, SP");
	}

	public void stackStaticAndDynamic(Writer w) throws IOException {
		w.write(formatASM("", "STW", "BP, -(SP)", "// Stack the dynamic link") +
				formatASM("", "STW", "BP, -(SP)", "// Stack the static link"));
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
					writer.write(varDecl(2));
				}
				break;

			case "AFFECT":
				if (tree.getChild(1).getText().equals("new")) {
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
				writer.write(printFuncCall(((Variable)TDS.get(tree.getChild(0).getText())).getDepl()));
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

}
