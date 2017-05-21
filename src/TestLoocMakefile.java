import core.LoocLexer;
import core.LoocParser;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;

import java.io.FileInputStream;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class TestLoocMakefile {

	public static void main(String[] args) throws Exception {
		ANTLRInputStream input;

		if(args.length == 1) {
			String entry = args[0];
			input = new ANTLRInputStream(new FileInputStream(entry));
			LoocLexer lexer = new LoocLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			LoocParser parser = new LoocParser(tokens);
			parser.program();
		}
	}
}
