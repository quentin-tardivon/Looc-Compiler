import TDS.SymbolTable
import core.CommonTreeParser
import exceptions.SymbolAlreadyDeclaredException
import factories.CommonTreeParserFactory

/**
 * Created by quentin on 18/03/2017.
 */
class CommonTreeParserTest extends GroovyTestCase {

    private CommonTreeParser treeParser

    void testConstructTDSLevel1() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level1.looc");

        String out =  treeParser.tds.get("total")
        def expected = "### Variable ###\n" +  " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.get("n")
        expected = "### Variable ###\n" +  " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.get("i")
        expected = "### Variable ###\n" +  " - type       -> int\n"
        assertToString(out, expected)
    }

    void testConstructTDSLevel2() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level2.looc");

        String out =  treeParser.tds.getLink("Math").getLink("pow").get("retval").toString()
        def expected = "### Variable ###\n" +  " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.get("m")
        expected = "### Variable ###\n" + " - type       -> Math\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Math").getLink("pow").get("a").toString()
        expected = "### Parameter ###\n" + " - type       -> int\n"
        assertToString(out, expected)

    }

    void testConstructTDSLevel3() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level3.looc");

        String out = treeParser.tds.getLink("Fibonacci").get("current")
        def expected = "### Variable ###\n" +  " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Fibonacci").get("previous")
        expected = "### Variable ###\n" + " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Fibonacci").get("generation")
        expected = "### Variable ###\n" + " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Fibonacci").getLink("nextGen").get("temp")
        expected = "### Variable ###\n" + " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.get("f")
        expected = "### Variable ###\n" + " - type       -> Fibonacci\n"
        assertToString(out, expected)

    }

    void testConstruct__TDSLevel1() {
        shouldFail(SymbolAlreadyDeclaredException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/__Level1.looc")
            treeParser.constructTDS(tree, new SymbolTable());

        }
    }
}
