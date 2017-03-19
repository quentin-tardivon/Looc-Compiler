import TDS.SymbolTable
import org.antlr.runtime.ANTLRInputStream
import org.antlr.runtime.CommonTokenStream
import org.antlr.runtime.tree.CommonTree

/**
 * Created by quentin on 18/03/2017.
 */
class CommonTreeParserTest extends GroovyTestCase {
    void testConstructTDSLevel1() {

        String file = "./samples/Level1.looc"

        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file))
        LoocLexer lexer = new LoocLexer(input)
        CommonTokenStream tokens = new CommonTokenStream(lexer)
        LoocParser parser = new LoocParser(tokens)
        CommonTree tree = (CommonTree)parser.program().getTree()

        CommonTreeParser treeParser = new CommonTreeParser()
        treeParser.constructTDS(tree, new SymbolTable())

        String out =  treeParser.tds.get("total")
        def expected = "### Variable ####\n" +  " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.get("n")
        expected = "### Variable ####\n" +  " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.get("i")
        expected = "### Variable ####\n" +  " - type       -> int\n"
        assertToString(out, expected)
    }

    void testConstructTDSLevel2() {
        String file = "./samples/Level2.looc"

        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file))
        LoocLexer lexer = new LoocLexer(input)
        CommonTokenStream tokens = new CommonTokenStream(lexer)
        LoocParser parser = new LoocParser(tokens)
        CommonTree tree = (CommonTree)parser.program().getTree()

        CommonTreeParser treeParser = new CommonTreeParser()
        treeParser.constructTDS(tree, new SymbolTable())

        String out =  treeParser.tds.get("Math")
        def expected = "### Variable ####\n" +  " - type       -> Math\n"
        assertToString(out, expected)

        out =  treeParser.tds.get("pow")
        expected = "### Variable ####\n" +  " - type       -> Math\n"
        assertToString(out, expected)

    }
}
