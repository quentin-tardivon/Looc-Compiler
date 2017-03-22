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
        String file = "./samples/Level2.looc"

        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file))
        LoocLexer lexer = new LoocLexer(input)
        CommonTokenStream tokens = new CommonTokenStream(lexer)
        LoocParser parser = new LoocParser(tokens)
        CommonTree tree = (CommonTree)parser.program().getTree()

        CommonTreeParser treeParser = new CommonTreeParser()
        treeParser.constructTDS(tree, new SymbolTable())

        String out =  treeParser.tds.getLink("Math").getLink("pow").get("retval").toString()
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

        out = treeParser.tds.getLink("Math").getLink("pow").get("i")
        expected = "### Variable ###\n" + " - type       -> int\n"
        assertToString(out, expected)



    }

    void testConstructTDSLevel4() {
        String file = "./samples/Level4.looc"

        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file))
        LoocLexer lexer = new LoocLexer(input)
        CommonTokenStream tokens = new CommonTokenStream(lexer)
        LoocParser parser = new LoocParser(tokens)
        CommonTree tree = (CommonTree)parser.program().getTree()

        CommonTreeParser treeParser = new CommonTreeParser()
        treeParser.constructTDS(tree, new SymbolTable())

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

    void testConstructTDSLevel3AnonymousBlock() {
        String file = "./samples/Level3AnonymousBlock.looc"

        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file))
        LoocLexer lexer = new LoocLexer(input)
        CommonTokenStream tokens = new CommonTokenStream(lexer)
        LoocParser parser = new LoocParser(tokens)
        CommonTree tree = (CommonTree)parser.program().getTree()

        CommonTreeParser treeParser = new CommonTreeParser()
        treeParser.constructTDS(tree, new SymbolTable())

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

    void testConstructTDSLevel3() {
        String file = "./samples/Level3.looc"

        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file))
        LoocLexer lexer = new LoocLexer(input)
        CommonTokenStream tokens = new CommonTokenStream(lexer)
        LoocParser parser = new LoocParser(tokens)
        CommonTree tree = (CommonTree)parser.program().getTree()

        CommonTreeParser treeParser = new CommonTreeParser()
        treeParser.constructTDS(tree, new SymbolTable())

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

    }


}
