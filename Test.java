import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.nio.file.Paths;

public class Test {

    private static final String DIR_TESTS = "samples";
    private static final String DEFAULT_TEST_FILE = Paths.get(DIR_TESTS, "coucou.looc").toString();

    public static void main(String[] args) throws Exception {
        String file = (args.length != 0) ? args[0] : DEFAULT_TEST_FILE;
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file));
        LOOCLexer lexer = new LOOCLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LOOCParser parser = new LOOCParser(tokens);
        parser.program();
    }
}