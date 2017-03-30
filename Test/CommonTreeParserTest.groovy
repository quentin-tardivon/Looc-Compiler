import TDS.SymbolTable
import core.CommonTreeParser
import exceptions.MismatchOperationException
import exceptions.MismatchTypeException
import exceptions.StringOperationException
import exceptions.SymbolAlreadyDeclaredException
import exceptions.UndeclaredVariableException
import factories.CommonTreeParserFactory

/**
 * Created by quentin on 18/03/2017.
 */
class CommonTreeParserTest extends GroovyTestCase {

    private CommonTreeParser treeParser


    void testConstructTDSLevel0() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level0.looc");
    }

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

        out = treeParser.tds.get("for0")
        expected = "### For Loop ###\n"
        assertToString(out, expected)


    }

    void testConstructTDSLevel2() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level2.looc");

        String out =  treeParser.tds.getLink("Math").getLink("pow").get("retval")
        def expected = "### Variable ###\n" +  " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.get("m")
        expected = "### Variable ###\n" + " - type       -> Math\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Math").getLink("pow").get("a")
        expected = "### Parameter ###\n" + " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Math").getLink("pow").get("b")
        expected = "### Parameter ###\n" + " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Math").get("pow")
        expected = "### Method ###\n" + " - returnType -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.get("Math")
        expected = "### Class ###\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Math").getLink("pow").get("for0")
        expected = "### For Loop ###\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Math").getLink("pow").getLink("for0").getFather().get("retval")
        expected = "### Variable ###\n" + " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Math").getLink("pow").get("i")
        expected = "### Variable ###\n" + " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Math").getLink("pow").get("if0")
        expected = "### If Statement ###\n"
        assertToString(out, expected)




    }

    void testConstructTDSLevel3() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level3.looc");

        String out = treeParser.tds.get("Animal")
        def expected = "### Class ###\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Animal").get("name")
        expected = "### Variable ###\n" + " - type       -> string\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Animal").get("setName")
        expected = "### Method ###\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Animal").getLink("setName").get("n")
        expected = "### Parameter ###\n" + " - type       -> string\n"
        assertToString(out, expected)

        out = treeParser.tds.get("Dog")
        expected = "### Class ###\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Dog").get("whoami")
        expected = "### Method ###\n"
        assertToString(out, expected)

        out = treeParser.tds.get("Cat")
        expected = "### Class ###\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Cat").get("whoami")
        expected = "### Method ###\n"
        assertToString(out, expected)

        out = treeParser.tds.get("a1")
        expected = "### Variable ###\n" + " - type       -> Animal\n"
        assertToString(out, expected)

        out = treeParser.tds.get("a2")
        expected = "### Variable ###\n" + " - type       -> Animal\n"
        assertToString(out, expected)

        out = treeParser.tds.get("Cat").get("Inherit")
        expected = "Animal\n"
        assertToString(out, expected)

    }


    void testConstructTDSLevel3AnonymousBlock() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level3AnonymousBlock.looc");

        String out = treeParser.tds.get("Fibonacci")
        def expected = "### Class ###\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Fibonacci").get("current")
        expected = "### Variable ###\n" + " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Fibonacci").get("previous")
        expected = "### Variable ###\n" + " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Fibonacci").get("generation")
        expected = "### Variable ###\n" + " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Fibonacci").get("init")
        expected = "### Method ###\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Fibonacci").get("nextGen")
        expected = "### Method ###\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Fibonacci").getLink("nextGen").get("temp")
        expected = "### Variable ###\n" + " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Fibonacci").get("nextGenAndGet")
        expected = "### Method ###\n" + " - returnType -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.get("f")
        expected = "### Variable ###\n" + " - type       -> Fibonacci\n"
        assertToString(out, expected)

        out = treeParser.tds.get("block0")
        expected = "### Anonymous Block ###\n"
        assertToString(out, expected)

        out = treeParser.tds.get("block1")
        expected = "### Anonymous Block ###\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("block0").get("block0")
        expected = "### Anonymous Block ###\n"
        assertToString(out, expected)

    }

    void testConstructTDSLevel4() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level4.looc");

        String out = treeParser.tds.get("Fibonacci")
        def expected = "### Class ###\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Fibonacci").get("current")
        expected = "### Variable ###\n" + " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Fibonacci").get("previous")
        expected = "### Variable ###\n" + " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Fibonacci").get("generation")
        expected = "### Variable ###\n" + " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Fibonacci").get("init")
        expected = "### Method ###\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Fibonacci").get("nextGen")
        expected = "### Method ###\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Fibonacci").getLink("nextGen").get("temp")
        expected = "### Variable ###\n" + " - type       -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.getLink("Fibonacci").get("nextGenAndGet")
        expected = "### Method ###\n" + " - returnType -> int\n"
        assertToString(out, expected)

        out = treeParser.tds.get("f")
        expected = "### Variable ###\n" + " - type       -> Fibonacci\n"
        assertToString(out, expected)

    }



    void testConstruct__TDSLevel1() {
        shouldFail(SymbolAlreadyDeclaredException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/__Level1.looc")
            treeParser.constructTDS(tree, new SymbolTable())

        }
    }

    void testConstruct__TDSLevel1MismatchOperationException() {
        shouldFail(MismatchOperationException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/__Level1OperationMismatch.looc")
            treeParser.constructTDS(tree, new SymbolTable())
        }
    }

    void testConstruct__TDSLevel2() {
        shouldFail(UndeclaredVariableException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/__Level2.looc")
            treeParser.constructTDS(tree, new SymbolTable())
        }
    }

    void testConstruct__TDSLevel3() {
        shouldFail(MismatchTypeException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/__Level3.looc")
            treeParser.constructTDS(tree, new SymbolTable())
        }
    }

    void testConstruct__StringOperationException() {
        shouldFail(StringOperationException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/__StringOperationException.looc")
            treeParser.constructTDS(tree, new SymbolTable())
        }
    }

}
