import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.nio.file.Paths;

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


	public static void prompt() {
		/*if(args.length == 0) {
			System.out.println("\n -> Write some " + LANGUAGE_NAME + " code:\n\n");
			input = new ANTLRInputStream(System.in);
		}*/
	}
}
