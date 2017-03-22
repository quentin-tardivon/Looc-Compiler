import core.LoocLexer;
import core.LoocParser;
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
}
