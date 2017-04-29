package ASMGenerator;

import ASMGenerator.instructions.Declaration;
import TDS.Entry;
import TDS.SymbolTable;
import TDS.entries.Variable;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import java.io.*;

/**
 * Created by quentin on 29/04/2017.
 */
public class ASMWriter {

	public static final int INT_SIZE = 2;
	private String output;

	public ASMWriter(String asmFile) {
		this.output = asmFile;
	}

	public void generateASMFile(Tree tree, SymbolTable TDS) {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(this.output), "utf-8"))) {

			//Début du programme
			writer.write("SP          EQU r15\n" +
					"WR          EQU r14\n" +
					"BP          EQU r13\n" +
					"\n" +
					"EXIT_EXC   EQU   64\n" +
					"READ_EXC   EQU   65\n" +
					"WRITE_EXC  EQU   66\n" +
					"\n" +
					"NUL         EQU  0\n" +
					"NULL        EQU  0\n" +
					"NIL         EQU  0\n" +
					"\n" +
					"STACK_ADRS  EQU  0x1000\n" +
					"LOAD_ADRS   EQU  0xFE00\n" +
					"\n" +
					"            ORG LOAD_ADRS\n" +
					"            START main_\n" +
					"\n" +
					"\n" +
					"main_   LDW SP, #STACK_ADRS\n" +
					"        LDW BP, #NIL\n" +
					"\n" +
					"        STW BP, -(SP)\n" +
					"        LDW BP, SP\n");

			this.constructASM(tree, writer, TDS);

			//Fin du programme
			writer.write("LDW SP, BP\n" +
					"        LDW BP, (SP)+\n" +
					"        TRP #EXIT_EXC\n");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to write or create File");
		}
	}

	public String varDecl(int deplType) {
		//#-2 ==> depl
		return "ADI SP, SP, #-"+ deplType + "\n";
	}

	public String varAffect(int depl, int value) {
		//#-23 ==> Value
		//(bp)-10 ==> Depl
		return "LDW R0, #" + value + "\n" +
				"STW R0, (BP)-"+ depl + "\n";
	}

	public String addConst(int constante, int depl) {
		getVar("R1", depl);

		return "ADQ " + constante + ", R1";
	}

	public String addToStack(String reg) {
		return "ADQ -2, SP\n" +
				"STW " + reg + ", (SP)\n";
	}

	public String removeFromStack(String reg) {
		return "LDW " + reg + ", (SP)\n" +
				"ADQ 2, SP\n";
	}

	public String getVar(String reg, int depl) {
		return "LDW " + reg + ", (BP)-" + depl;
	}


	private void constructASM(Tree tree, Writer writer, SymbolTable TDS) throws IOException {
		switch(tree.getText()) {
			case "ROOT":
				for (int i = 0; i < tree.getChildCount(); i++) {
					constructASM(tree.getChild(i), writer, TDS);
				}
				break;

			case "VAR_DEC":
				writer.write(varDecl(2));
				break;

			case "AFFECT":
				writer.write(varAffect(((Variable)TDS.get(tree.getChild(0).getText())).getDepl(), Integer.parseInt(tree.getChild(1).getText())));
				break;
		}
	}

}
