import org.antlr.runtime.*;

public class TestLooc {
    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        LoocLexer lexer = new LoocLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LoocParser parser = new LoocParser(tokens);
        parser.program();
    }
}
