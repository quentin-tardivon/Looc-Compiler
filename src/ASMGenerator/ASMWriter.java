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
	private String output;

	public ASMWriter(String asmFile) {
		this.output = asmFile;
	}


	public static String formatASM(String left, String asm, String value) {
		return String.format("%-10s\t\t%-10s\t\t%-10s\n",left, asm, value);
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

			this.constructASM(tree, writer, TDS);

			writer.write(formatASM("\n\n\n\n// ------------- FIN DU PGM", "", "\n") +
					formatASM("", "LDW SP, BP", "") +
					formatASM("", "LDW BP, (SP)+", "") +
					formatASM("", "LDW ST, BT", "") +
					formatASM("", "LDW BT, (ST)+", "") +
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
		return formatASM("", "ADI SP, SP, #-" + deplType, "");
	}

	private String addToHeap(int depl){
		return formatASM("","ADQ -" + depl + ", ST","");
	}

	private String varAffect(int depl, int value) {
		return formatASM("", "LDW R0, #" + value, "") +
				formatASM("", "STW R0, (BP)-" + depl, "");
	}

	private String varStringAffect(int depl,int charValue){
		return formatASM("", "LDW R0, #" + charValue, "") +
				formatASM("", "STW R0, (ST)-" + depl, "");
	}

	private String addStringToStack(int depl) {
		return //formatASM("","LDW R0, (R12)","")+
				formatASM("","STW R12, (BP)-" + depl,"");
	}

	private String stringTest(int depl){
		return formatASM("","LDW R0, #" ,"" );
	}


	private String classAffect() {
		return formatASM("", "Here comes a Class ADDR", "");
	}


	public String addConst(int constante, int depl) {
		getVar("R1", depl);
		return this.formatASM("", "ADQ", constante + ", R1");
	}

	public String addToStack(String reg) {
		return formatASM("", "ADQ -2, SP", "") +
				formatASM("", "STW " + reg + ", (SP)", "");
	}

	public String removeFromStack(String reg) {
		return this.formatASM("", "LDW", reg + ", (SP)") +
			this.formatASM("", "ADQ", "2, SP");
	}

	private String getVar(String reg, int depl) {
		return formatASM("", "LDW" + reg + ", (BP)-" + depl, "");
	}

	private String defPrintFunc() {
		return formatASM("\n\n\n\n// ------------- PRINT FUNCT", "", "\n") +
				formatASM("print_", "LDQ", "0,R1") +
				formatASM("", "STW", "BP, -(SP)") +
				formatASM("", "LDW", "BP, SP") +
				formatASM("", "SUB", "SP, R1, SP") +
				formatASM("", "LDW", "R0, (BP)4") +
				formatASM("", "TRP", "#WRITE_EXC") +
				formatASM("", "LDW", "SP, BP") +
				formatASM("", "LDW", "BP, (SP)+") +
				formatASM("", "RTS", "");
	}

	public String printFuncCall(String varName) { //Equivalent à charger une fonction classique, inspiration
		return this.formatASM("", "ADI","BP, R0, #-8") +
				this.formatASM("", "STW", "R0, -(SP)") +
				this.formatASM("", "JSR", "@print_") +
				this.formatASM("", "ADI", "SP, SP, #2");
	}



	private void constructASM(Tree tree, Writer writer, SymbolTable TDS) throws IOException {
		switch(tree.getText()) {
			case "ROOT":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructASM(tree.getChild(i), writer, TDS);
				}
				break;

			case "VAR_DEC":
				if (tree.getChild(0).getText().equals("int")) {
					writer.write(varDecl(2));
				}
				else if(tree.getChild(0).getText().equals("string")) {
					writer.write(varDecl(2));
				}
				break;

			case "AFFECT":
				if (TDS.getInfo(tree.getChild(0).getText()).get(Entry.TYPE).equals(Keywords.INTEGER)) {
					System.out.println("affect int");
					writer.write(varAffect(((Variable)TDS.get(tree.getChild(0).getText())).getDepl(), Integer.parseInt(tree.getChild(1).getText())));
				}
				else if(TDS.getInfo(tree.getChild(0).getText()).get(Entry.TYPE).equals(Keywords.STRING)) {
					if (tree.getChild(1).getText().matches("\".*\"")) {
						writer.write(addStringToStack(((Variable)TDS.get(tree.getChild(0).getText())).getDepl()));
						for (int i = 1; i < tree.getChild(1).getText().length() - 1; i++) {
							writer.write(varStringAffect(2 , (int) tree.getChild(1).getText().charAt(i)));
							writer.write(addToHeap(2));
							System.out.println(tree.getChild(1).getText().charAt(i));
						}
					}
					//else if (TDS.getInfo(tree.getChild(1).getText()))

				}
				else if (tree.getChild(1).getText().equals("new")) {
					writer.write(classAffect());
				}
				else {
					writer.write(varAffect(((Variable)TDS.get(tree.getChild(0).getText())).getDepl(), Integer.parseInt(tree.getChild(1).getText())));
				}

				break;

			case "FOR":
				writer.write(new For(new Condition(), new Block()).generate());
				break;

			case "WRITE":
				writer.write(printFuncCall(tree.getChild(0).getText()));
				break;

			case "CLASS_DEC":
				writer.write(formatASM(tree.getChild(0).getText(), "RSB", "size"));
				break;
			//default:
//				System.out.println(tree.getText() + " ");

		}
	}

}
