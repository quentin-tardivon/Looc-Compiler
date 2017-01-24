import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import java.io.FileInputStream;
import java.nio.file.Paths;

public class TestLooc {

	private static final String LANGUAGE_NAME = "LOOC";
	private static final String DIR_TESTS = "samples";	
	private static final String DEFAULT_TEST_FILE = Paths.get(DIR_TESTS, "coucou.looc").toString();

	public static void main(String[] args) throws Exception {
		ANTLRInputStream input;

		if(args.length == 0) {
			System.out.println("\n -> Write some " + LANGUAGE_NAME + " code:\n\n");
			input = new ANTLRInputStream(System.in);
		}
		else
			input = new ANTLRInputStream(new FileInputStream(args[0]));
        
		LoocLexer lexer = new LoocLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LoocParser parser = new LoocParser(tokens);
		parser.program();
	}
}
