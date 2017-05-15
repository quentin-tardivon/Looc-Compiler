import ASMGenerator.ASMWriter;
import TDS.SymbolTable;
import TDS.entries.Variable;
import core.CommonTreeParser;
import core.LoocLexer;
import core.LoocParser;
import factories.CommonTreeParserFactory;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;

import java.io.File;
import java.io.FileInputStream;

/**
 * Class for testing things !
 *
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class Sandbox {

    public static void main(String[] args) throws Exception {
        if(args.length == 0) {
            System.out.println("filename should be in arguments !");
            System.exit(0);
        }
        System.out.println(" -- Generate ASM for " + args[0]);
        File f = new File(args[0]);

        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(f));
        LoocLexer lexer = new LoocLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LoocParser parser = new LoocParser(tokens);
        CommonTree tree = (CommonTree)parser.program().getTree();

        CommonTreeParser treeParser = new CommonTreeParser("##called in TestLooc.java");
        treeParser.parseCommonTreeParser(tree);
	      SymbolTable tds = new SymbolTable();
	    treeParser.constructTDS(tree, tds, tds);
        ASMWriter writer = new ASMWriter("./samples/asmSamples/" + f.getName() + ".asm");
        writer.generateASMFile(tree, tds);
    }
}
