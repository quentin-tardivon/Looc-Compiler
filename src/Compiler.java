import ASMGenerator.ASMWriter;
import TDS.SymbolTable;
import core.CommonTreeParser;
import core.LoocLexer;
import core.LoocParser;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;

import java.io.File;
import java.io.FileInputStream;


public class Compiler {

    public static void main(String[] args) {
        if(args.length == 0) {
            showHelp();
            System.exit(1);
        }
        try {
            System.out.println(" -- Generate ASM for " + args[0]);
            File f = new File(args[0]);

            ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(f));
            LoocLexer lexer = new LoocLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LoocParser parser = new LoocParser(tokens);
            CommonTree tree = (CommonTree)parser.program().getTree();

            CommonTreeParser treeParser = new CommonTreeParser(f.getName());
            treeParser.parseCommonTreeParser(tree);
            SymbolTable tds = new SymbolTable();
            treeParser.constructTDS(tree, tds, tds);
            ASMWriter writer = new ASMWriter(new File(f.getAbsolutePath() + ".asm").getPath());
            writer.generateASMFile(tree, tds);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showHelp() {
        System.out.println("USAGE:\n" +
                "\tjava -jar looc.jar loocFile.looc\n\n" +
                "AUTHORS\n" +
                        "\t - Théo le donné\n" +
                        "\t - Maxime Escamez\n" +
                        "\t - Quentin Tardivon\n" +
                        "\t - Yann Prono\n"
        );
    }
}
