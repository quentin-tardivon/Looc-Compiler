package ASMGenerator;

import TDS.SymbolTable;
import TDS.entries.Variable;
import org.antlr.runtime.tree.Tree;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by quentin on 29/04/2017.
 * Note: Une adresse 2 octets, un entier 2 octets
 */
public class ASMWriter {

	private static int CPTFOR =0;

	private String output;
	public static final String BUILTIN_FIND_STATIC = "FIND_STATIC";

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

			writer.write(formatASM("// ------------- ASM FOR LOOC", "", "\n") +
					formatASM("SP", "EQU", "R15") +
					formatASM("WR", "EQU", "R14") +
					formatASM("BP", "EQU", "R13") +
					formatASM("ST", "EQU", "R12") +
					formatASM("BT", "EQU", "R11") +
					formatASM("SC", "EQU", "R7\n") +

					formatASM("EXIT_EXC", "EQU", "64") +
					formatASM("READ_EXC", "EQU", "65") +
					formatASM("WRITE_EXC", "EQU", "66") +
					formatASM("NUL", "EQU", "0") +
					formatASM("NULL", "EQU", "0") +
					formatASM("NIL", "EQU", "0") +
					formatASM("STACK_ADRS", "EQU", "0x1000") +
					formatASM("HEAP_ADRS", "EQU", "0xF000") +
					formatASM("LOAD_ADRS", "EQU", "0xFA00") +
					formatASM("CLASS_ADRS","EQU","0xFD00")+
					formatASM("CONVERT_BUFF", "EQU", "40")+
					formatASM("ITOA_I", "EQU", "4") +
					formatASM("ATOI_A", "EQU", "10")+
					formatASM("ASCII_MINUS", "EQU", "45") +
					formatASM("ASCII_PLUS", "EQU", "43") +
					formatASM("ASCII_SP", "EQU", "32") +
					formatASM("ASCII_0", "EQU", "48") +
					formatASM("ASCII_A", "EQU", "65\n")+

					formatASM("", "ORG", "LOAD_ADRS") +
					formatASM("", "START", "main_\n") +

					formatASM("main_", "LDW", "SP, #STACK_ADRS") +
					formatASM("", "LDW", "R0, #0x0d0a") +
					formatASM("", "STW", "R0, @0x0000") +
					formatASM("", "LDW", "BP, #NIL") +
					formatASM("", "LDW","ST, #HEAP_ADRS")+
					formatASM("", "LDW","BT, #NIL")+
					formatASM("", "STW","BT, -(ST)")+
					formatASM("", "LDW","BT, ST") +
					formatASM("", "LDW","SC, #CLASS_ADRS", "// load into SC the base of class descriptors")
			);

			writer.write(formatASM("\n\n//", "---------------------------------------------", "")+
					formatASM("//", "|        Beginning of program	            |", "") +
					formatASM("//", "|        Looc compiler V0.0.2 beta          |", "") +
					formatASM("//", "|        The program starts right now !     |", "") +
					formatASM("//", "---------------------------------------------", "\n")
			);
			writer.write(ASMUtils.stackStaticAndDynamic());
			ArrayList<Generable> meths = this.constructASM(tree, writer, TDS);

			writer.write(ASMUtils.generateComment("End of program", "Go back to @main"));
			writer.write(formatASM("", "LDW SP, BP", "") +
					formatASM("", "LDW BP, (SP)+", "") +
					formatASM("", "TRP #EXIT_EXC", "") +
					formatASM("", "JEA @main_", "")
			);

			writer.write(itoaDef());
			writer.write(atoiDef());
			generateInstructions(writer, meths);
			writer.write(generateFindVariableStatic());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to write or create File");
		}
	}


	private ArrayList<Generable> constructASM(Tree tree, Writer writer, SymbolTable TDS) throws IOException {
		ArrayList<Generable> meths = new ArrayList<Generable>();
		switch (tree.getText()) {
			case "ROOT":
				for (int i = 0; i < tree.getChildCount(); i++) {
					ArrayList<Generable> l = new ArrayList<Generable>();
					ASMParser.parse(tree.getChild(i), TDS, l, meths);
					generateInstructions(writer, l);
				}
				break;
		}
		return meths;

	}

	private String itoaDef() {
		return 	formatASM("\n\n", "", "") +
				ASMUtils.generateComment("I_TO_A builtin:", "Convert an integer into ASCII") +
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

				formatASM("", "LDW", "R1, #CONVERT_BUFF") + //20 par défaut pour l'instant
				formatASM("", "STB", "R3, (R1)+") +
				formatASM("CPYLOOP", "LDW", "R0, (SP)+") +
				formatASM("", "STB", "R0, (R1)+") +
				formatASM("", "CMP", "SP, BP") +
				formatASM("", "BNE", "CPYLOOP-$-2") +
				formatASM("", "LDQ", "NUL, R0") +
				formatASM("", "STB", "R0, (R1)+") +

				formatASM("", "LDW", "R0, #CONVERT_BUFF", "// Pointeur sur chaine de caract") +
				formatASM("", "TRP", "#WRITE_EXC") +
				formatASM("", "LDW", "R0, #0x0000", "// Pointeur sur retour ligne") +
				formatASM("", "TRP", "#WRITE_EXC") +
				formatASM("", "LDW", "SP, BP") +
				formatASM("", "LDW", "BP, (SP)+") +
				formatASM("", "RTS", "");


	}

	private String atoiDef(){
		return formatASM("\n\n", "", "") +
				ASMUtils.generateComment("A_TO_I builtin:", "Convert ASCII chars into integer") +
				formatASM("atoi_", "STW", "BP, -(SP)") +
				formatASM("", "LDW", "BP, SP") +
				formatASM("", "LDW", "R0, (BP)ITOA_I") +


				formatASM("","LDW","R3, #0x0100")+
				formatASM("","LDQ","0,R1")+
				formatASM("","STW","R1,-(SP)")+

				formatASM("LOOP_STACK","NOP","")+
					formatASM("","LDB","R0, (R3)")+
					//formatASM("","STB","R3,")+
					formatASM("","STW","R0,-(SP)")+
					formatASM("","ADQ","1,R3")+
					formatASM("","LDB","R0, (R3)")+
					formatASM("","CMP","R0,R1")+
				formatASM("","BNE","LOOP_STACK-$-2")+


				formatASM("","LDW","R3, (SP)")+
				formatASM("","LDW","R1, #48")+
				formatASM("","SUB","R3,R1,R0")+
				formatASM("", "ADI", "SP, SP, #" + ASMUtils.INT_SIZE, "// Unstack")+
				formatASM("","LDW","R3,(SP)")+
				formatASM("","LDQ","10,R10")+
				formatASM("LOOP_ATOI","NOP","")+
					formatASM("","LDW","R1, #0x002D")+
					formatASM("","CMP","R3,R1")+
					formatASM("","BEQ","ATOI_NEG-$-2")+
					formatASM("","LDW","R1, #0")+
					formatASM("","CMP","R3,R1")+
					formatASM("","BEQ","LOOP_ATOI_END-$-2")+
					formatASM("","STW","R0,-(SP)")+
					formatASM("","LDW","R1, #48")+
					formatASM("","SUB","R3,R1,R0")+
					formatASM("","MUL","R0,R10,R0")+
					formatASM("","LDW","R3,(SP)")+
					formatASM("","ADD","R0,R3,R0")+
					formatASM("", "ADI", "SP, SP, #" + ASMUtils.INT_SIZE, "// Unstack")+
					formatASM("", "ADI", "SP, SP, #" + ASMUtils.INT_SIZE, "// Unstack")+
					formatASM("","LDW","R3,(SP)")+
					formatASM("","LDW","R1, #10")+
					formatASM("","MUL","R10,R1,R10")+
				formatASM("","JEA","@LOOP_ATOI")+

				formatASM("ATOI_NEG","NOP","")+
				formatASM("","LDW","R1, #0xFFFF")+
				formatASM("","SUB","R1,R0,R0")+
				formatASM("","ADQ","1,R0")+
				formatASM("", "ADI", "SP, SP, #" + ASMUtils.INT_SIZE, "// Unstack")+
				formatASM("", "ADI", "SP, SP, #" + ASMUtils.INT_SIZE, "// Unstack")+



				formatASM("LOOP_ATOI_END","NOP","")+
				formatASM("", "ADI", "SP, SP, #" + ASMUtils.INT_SIZE, "// Unstack")+
				formatASM("", "LDW", "SP, BP") +
				formatASM("", "LDW", "BP, (SP)+") +
				formatASM("","RTS","");


	}


	public void generateInstructions(Writer w, ArrayList<Generable> l) throws IOException {
		for(Generable g: l) {
			w.write(g.generate());
		}
	}

	public String generateFindVariableStatic() {
		return formatASM("\n\n", "", "") +
				ASMUtils.generateComment(BUILTIN_FIND_STATIC + " builtin:", "Use static links to load", "variable not declared in", "the current environment") +
				ASMUtils.formatASM(BUILTIN_FIND_STATIC, "LDW", "R6, BP") +
				ASMUtils.loadParameter("R0", 1) +
				ASMUtils.formatASM( "STATIC_LOOP", "LDW", "R6, -(R6)") +
				ASMUtils.formatASM("", "LDW", "R1, #1") +
				ASMUtils.formatASM("", "SUB", "R0, R1, R0") +
				ASMUtils.formatASM("", "LDW", "R1, #0") +
				ASMUtils.formatASM("", "CMP", "R0, R1") +
				ASMUtils.formatASM( "", "BNE", "STATIC_LOOP-$-2") +
				ASMUtils.formatASM("", "RTS", "");
	}
}
