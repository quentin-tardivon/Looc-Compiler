import ASMGenerator.ASMWriter
import TDS.SymbolTable
import core.CommonTreeParser
import core.LoocLexer
import core.LoocParser
import org.antlr.runtime.ANTLRInputStream
import org.antlr.runtime.CommonTokenStream
import org.antlr.runtime.tree.CommonTree

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
class AssemblerTest extends GroovyTestCase {

    private final String ROOT_PATH = "./samples/asmSamples/"
    private final String LOOC_PATH = ROOT_PATH + "loocFiles/"
    private final String ASM_PATH = LOOC_PATH + "output/"


    void testASmLevel0() {
        compileAndGenerate("Level0.looc", "+6", "MOGWA")
    }

    void testASmLevel1() {
        compileAndGenerate("Level1.looc", "+4")
    }

    void testASmLevel2() {
        compileAndGenerate("Level2.looc", "+4", "+21", "+5")
    }

    void testASmLevel3() {
        compileAndGenerate("Level3.looc", "+5", "+10")
    }

    void testASmLevel4() {
        compileAndGenerate("Level4.looc", "+50", "+100")
    }

    void testASmLevel5() {
        compileAndGenerate("Level5.looc", "+12","+50", "+100")
    }

    void testASmLevelRW() {
        compileAndGenerate("LevelRW.looc", "i+j :", "+2878","i (i:=j-i) :", "-3788", "x+i/100 :", "-36","helloworld()35!{","+0")
    }

    void testASmLevelDoubleFor() {
        compileAndGenerate("LevelDoubleFor.looc", "end", "+4","+5","+5", "+16")
    }


    public compileAndGenerate(String filename, String ... res) {
        File f = new File(LOOC_PATH + filename)
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(f))
        LoocLexer lexer = new LoocLexer(input)
        CommonTokenStream tokens = new CommonTokenStream(lexer)
        LoocParser parser = new LoocParser(tokens)
        CommonTree tree = (CommonTree)parser.program().getTree()

        CommonTreeParser treeParser = new CommonTreeParser(filename)
        treeParser.parseCommonTreeParser(tree)
        SymbolTable tds = new SymbolTable()
        treeParser.constructTDS(tree, tds, tds)
        ASMWriter writer = new ASMWriter(ASM_PATH + f.getName() + ".asm")
        writer.generateASMFile(tree, tds)
        executeAndCompare(f.getName(), res)

    }

    public executeAndCompare(filename, String ... res) {
        Process p = Runtime.getRuntime().exec("make batch file=" + ASM_PATH + filename)
        p.waitFor()
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))
        reader.readLine()
        String line = ""
        while ((line = reader.readLine())!= null && !line.contains("java -jar")) {}

            if (res)
                checkOutput(reader, res)

    }

    public checkOutput(BufferedReader reader, String ... res) {
        int i = 0
        String line = ""
        while ((line = reader.readLine())!= null && !line.contains("Simulation terminée")) {
            System.out.println(line)
            assertEquals("Output(s) doesn't correspond", res[i], line.trim())
            i++
        }
        assertEquals("Output(s) of assembler code doesn't correspond", res.length, i)
    }

}
