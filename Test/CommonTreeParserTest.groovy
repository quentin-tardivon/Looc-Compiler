import TDS.Entry
import TDS.SymbolTable
import core.CommonTreeParser
import core.Keywords
import exceptions.MismatchOperationException
import exceptions.MismatchTypeException
import exceptions.StringOperationException
import exceptions.SymbolAlreadyDeclaredException
import exceptions.UndeclaredVariableException
import factories.CommonTreeParserFactory
import factories.EntryFactory

/**
 * Created by quentin on 18/03/2017.
 */
class CommonTreeParserTest extends GroovyTestCase {

    private CommonTreeParser treeParser


    void testConstructTDSLevel0() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level0.looc")
    }

    void testConstructTDSLevel1() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level1.looc")

        assertEquals(treeParser.tds.get("total"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.get("n"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.get("for0"), EntryFactory.createForLoop())
    }

    void testConstructTDSLevel2() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level2.looc")

        assertEquals(treeParser.tds.getLink("Math").getLink("pow").get("retval"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.get("m"), EntryFactory.createVariable("Math"))
        assertEquals(treeParser.tds.getLink("Math").getLink("pow").get("a"), EntryFactory.createIntParameter())
        assertEquals(treeParser.tds.getLink("Math").getLink("pow").get("b"), EntryFactory.createIntParameter())

        assertEquals(treeParser.tds.getLink("Math").get("pow"), EntryFactory.createMethodReturnInt())
        String out = treeParser.getRootSymbolTable().getLink("Math").get("pow")
        String expected ="### Method ###\n" + " - ReturnType -> int\n"
        assertToString(out, expected)

        assertEquals(treeParser.tds.get("Math"), EntryFactory.createClass("Math"))
        assertEquals(treeParser.tds.getLink("Math").getLink("pow").get("for0"), EntryFactory.createForLoop())

        assertEquals(treeParser.tds.getLink("Math").getLink("pow").getLink("for0").getFather().get("retval"),
                EntryFactory.createIntVariable())

        assertEquals(treeParser.tds.getLink("Math").getLink("pow").get("i"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.getLink("Math").getLink("pow").get("if0"), EntryFactory.createIf())
    }

    void testConstructTDSLevel3() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level3.looc");

        assertEquals(treeParser.tds.get("Animal"), EntryFactory.createClass("Animal"))
        assertEquals(treeParser.tds.getLink("Animal").get("name"), EntryFactory.createStringVariable())
        assertEquals(treeParser.tds.getLink("Animal").get("setName"), EntryFactory.createMethod())
        assertEquals(treeParser.tds.getLink("Animal").getLink("setName").get("n"), EntryFactory.createStringParameter())
        assertEquals(treeParser.tds.get("Dog"), EntryFactory.createInheritClass("Dog", "Animal"))
        assertEquals(treeParser.tds.getLink("Dog").get("whoami"), EntryFactory.createMethod())
        assertEquals(treeParser.tds.get("Cat"), EntryFactory.createInheritClass("Cat", "Animal"))
        assertEquals(treeParser.tds.getLink("Cat").get("whoami"), EntryFactory.createMethod())
        assertEquals(treeParser.tds.get("a1"), EntryFactory.createVariable("Animal"))
        assertEquals(treeParser.tds.get("a2"), EntryFactory.createVariable("Animal"))
        assertEquals(treeParser.tds.get("Cat").get(Entry.INHERIT), "Animal")
    }


    void testConstructTDSLevel3AnonymousBlock() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level3AnonymousBlock.looc");

        assertEquals(treeParser.tds.get("Fibonacci"), EntryFactory.createClass("Fibonacci"))
        assertEquals(treeParser.tds.getLink("Fibonacci").get("current"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.getLink("Fibonacci").get("previous"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.getLink("Fibonacci").get("generation"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.getLink("Fibonacci").get("init"), EntryFactory.createMethod())
        assertEquals(treeParser.tds.getLink("Fibonacci").get("nextGen"), EntryFactory.createMethod())
        assertEquals(treeParser.tds.getLink("Fibonacci").getLink("nextGen").get("temp"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.getLink("Fibonacci").get("nextGenAndGet"), EntryFactory.createMethodReturnInt())

        assertEquals(treeParser.tds.get("f"), EntryFactory.createVariable("Fibonacci"))

        assertEquals(treeParser.tds.get("block0"), EntryFactory.createAnonymousBlock())
        assertEquals(treeParser.tds.get("block1"), EntryFactory.createAnonymousBlock())
        assertEquals(treeParser.tds.getLink("block0").get("block0"), EntryFactory.createAnonymousBlock())
    }

    void testConstructTDSLevel4() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level4.looc");

        assertEquals(treeParser.tds.get("Fibonacci"), EntryFactory.createClass("Fibonacci"))
        assertEquals(treeParser.tds.getLink("Fibonacci").get("current"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.getLink("Fibonacci").get("previous"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.getLink("Fibonacci").get("generation"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.getLink("Fibonacci").get("init"), EntryFactory.createMethod())
        assertEquals(treeParser.tds.getLink("Fibonacci").get("nextGen"), EntryFactory.createMethod())
        assertEquals(treeParser.tds.getLink("Fibonacci").getLink("nextGen").get("temp"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.getLink("Fibonacci").get("nextGenAndGet"), EntryFactory.createMethodReturnInt())

        assertEquals(treeParser.tds.get("f"), EntryFactory.createVariable("Fibonacci"))
    }

    void testConstructTDSLevel5() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level5.looc");
    }

    void testConstructTDSLevel6() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level6.looc");
    }

    void testConstructTDSLevel7() {
        treeParser = CommonTreeParserFactory.createFromFile("./samples/Level7.looc");
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

    void testConstruct__MismatchTypeException() {
        shouldFail(MismatchTypeException) {
            treeParser = CommonTreeParserFactory.createFromFile("./samples/__MismatchTypeException.looc")
            treeParser.constructTDS(tree, new SymbolTable())
        }
    }

}
