import TDS.Entry
import TDS.SymbolTable
import core.CommonTreeParser
import factories.CommonTreeParserFactory
import factories.EntryFactory

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
class CommonTreeParserTest extends GroovyTestCase {

    private CommonTreeParser treeParser
    private final String ROOT_PATH = "./samples/testSamples/"


    void testConstructTDSLevel0() {
        treeParser = CommonTreeParserFactory.createFromFile(ROOT_PATH + "Level0.looc")
        System.out.println(treeParser.tds)
    }

    void testConstructTDSLevel1() {
        treeParser = CommonTreeParserFactory.createFromFile(ROOT_PATH + "Level1.looc")
        SymbolTable s = treeParser.getRootSymbolTable()
        assertEquals(treeParser.tds.get("total"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.get("n"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.get("FOR_0_1"), EntryFactory.createForLoop())
        System.out.println(treeParser.tds)
    }

    void testConstructTDSLevel2() {
        treeParser = CommonTreeParserFactory.createFromFile(ROOT_PATH + "Level2.looc")

        assertEquals(treeParser.tds.findClass("Math").getLink("pow").get("retval"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.get("m"), EntryFactory.createVariable("Math"))
        assertEquals(treeParser.tds.findClass("Math").getLink("pow").get("a"), EntryFactory.createIntParameter())
        assertEquals(treeParser.tds.findClass("Math").getLink("pow").get("b"), EntryFactory.createIntParameter())

        assertEquals(treeParser.tds.findClass("Math").get("pow"), EntryFactory.createMethodReturnInt())

        assertEquals(treeParser.tds.get("Math"), EntryFactory.createClass("Math"))
        assertEquals(treeParser.tds.findClass("Math").getLink("pow").get("FOR_0_3"), EntryFactory.createForLoop())

        assertEquals(treeParser.tds.findClass("Math").getLink("pow").getLink("FOR_0_3").getFather().get("retval"),
                EntryFactory.createIntVariable())

        assertEquals(treeParser.tds.findClass("Math").getLink("pow").get("i"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.findClass("Math").getLink("pow").get("IF_0_3"), EntryFactory.createIf())
        System.out.println(treeParser.tds)
    }

    void testConstructTDSLevel3() {
        treeParser = CommonTreeParserFactory.createFromFile(ROOT_PATH + "Level3.looc");

        assertEquals(treeParser.tds.get("Animal"), EntryFactory.createClass("Animal"))
        assertEquals(treeParser.tds.findClass("Animal").get("name"), EntryFactory.createStringVariable())
        assertEquals(treeParser.tds.findClass("Animal").get("setName"), EntryFactory.createMethod())
        assertEquals(treeParser.tds.findClass("Animal").getLink("setName").get("n"), EntryFactory.createStringParameter())
        assertEquals(treeParser.tds.findClass("Animal").get("Dog"), EntryFactory.createInheritClass("Dog", "Animal"))
        assertEquals(treeParser.tds.findClass("Dog").get("whoami"), EntryFactory.createMethod())
        assertEquals(treeParser.tds.findClass("Animal").get("Cat"), EntryFactory.createInheritClass("Cat", "Animal"))
        assertEquals(treeParser.tds.findClass("Cat").get("whoami"), EntryFactory.createMethod())
        assertEquals(treeParser.tds.get("a1"), EntryFactory.createVariable("Animal"))
        assertEquals(treeParser.tds.get("a2"), EntryFactory.createVariable("Animal"))
        assertEquals(treeParser.tds.findClass("Animal").get("Cat").get(Entry.INHERIT), "Animal")

        System.out.println(treeParser.tds)
    }


    void testConstructTDSLevel3AnonymousBlock() {
        treeParser = CommonTreeParserFactory.createFromFile(ROOT_PATH + "Level3AnonymousBlock.looc")

        assertEquals(treeParser.tds.get("Fibonacci"), EntryFactory.createClass("Fibonacci"))
        assertEquals(treeParser.tds.findClass("Fibonacci").get("current"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.findClass("Fibonacci").get("previous"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.findClass("Fibonacci").get("generation"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.findClass("Fibonacci").get("init"), EntryFactory.createMethod())
        assertEquals(treeParser.tds.findClass("Fibonacci").get("nextGen"), EntryFactory.createMethod())
        assertEquals(treeParser.tds.findClass("Fibonacci").getLink("nextGen").get("temp"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.findClass("Fibonacci").get("nextGenAndGet"), EntryFactory.createMethodReturnInt())

        assertEquals(treeParser.tds.get("f"), EntryFactory.createVariable("Fibonacci"))

        assertEquals(treeParser.tds.get("BLOCK_0_1"), EntryFactory.createAnonymousBlock())
        assertEquals(treeParser.tds.get("BLOCK_2_1"), EntryFactory.createAnonymousBlock())
        assertEquals(treeParser.tds.getLink("BLOCK_0_1").get("BLOCK_1_2"), EntryFactory.createAnonymousBlock())
        System.out.println(treeParser.tds)
    }

    void testConstructTDSLevel4() {
        treeParser = CommonTreeParserFactory.createFromFile(ROOT_PATH + "Level4.looc")

        assertEquals(treeParser.tds.get("Fibonacci"), EntryFactory.createClass("Fibonacci"))
        assertEquals(treeParser.tds.findClass("Fibonacci").get("current"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.findClass("Fibonacci").get("previous"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.findClass("Fibonacci").get("generation"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.findClass("Fibonacci").get("init"), EntryFactory.createMethod())
        assertEquals(treeParser.tds.findClass("Fibonacci").get("nextGen"), EntryFactory.createMethod())
        assertEquals(treeParser.tds.findClass("Fibonacci").getLink("nextGen").get("temp"), EntryFactory.createIntVariable())
        assertEquals(treeParser.tds.findClass("Fibonacci").get("nextGenAndGet"), EntryFactory.createMethodReturnInt())

        assertEquals(treeParser.tds.get("f"), EntryFactory.createVariable("Fibonacci"))
        System.out.println(treeParser.tds)
    }

    void testConstructTDSLevel5() {
        treeParser = CommonTreeParserFactory.createFromFile(ROOT_PATH + "Level5.looc")
        System.out.println(treeParser.tds)
    }

    void testConstructTDSLevel6() {
        treeParser = CommonTreeParserFactory.createFromFile(ROOT_PATH + "Level6.looc")
        System.out.println(treeParser.tds)
    }

    void testConstructTDSLevel7() {
        treeParser = CommonTreeParserFactory.createFromFile(ROOT_PATH + "Level7.looc")
        System.out.println(treeParser.tds)
    }

}
