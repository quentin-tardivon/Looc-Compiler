package ASMGenerator;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Created by quentin on 29/04/2017.
 */
public class ASMWriter {

	public void initASMFile(String filename) {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("./samples/asmSamples/"+ filename + ".asm"), "utf-8"))) {

			//Début du programme
			writer.write("sp          equ r15\n" +
					"wr          equ r14\n" +
					"bp          equ r13\n" +
					"\n" +
					"SP          equ r15\n" +
					"WR          equ r14\n" +
					"BP          equ r13\n" +
					"\n" +
					"EXIT_EXC   EQU   64\n" +
					"READ_EXC   EQU   65\n" +
					"WRITE_EXC  EQU   66\n" +
					"\n" +
					"NUL         equ  0\n" +
					"NULL        equ  0\n" +
					"NIL         equ  0\n" +
					"\n" +
					"STACK_ADRS  equ 0x1000\n" +
					"LOAD_ADRS   equ 0xFE00\n" +
					"\n" +
					"            org LOAD_ADRS\n" +
					"            start main_\n" +
					"\n" +
					"\n" +
					"main_   ldw sp, #STACK_ADRS\n" +
					"        ldw bp, #NIL\n" +
					"\n" +
					"        stw bp, -(sp)\n" +
					"        ldw bp, sp\n");

			//Fin du programme
			writer.write("ldw sp, bp\n" +
					"        ldw bp, (sp)+\n" +
					"        trp #EXIT_EXC\n" +
					"        jea @main_\n");
		}
		catch (Exception e) {
			System.out.println("Unable to write or create File");
		}
	}

}
