import TDS.SymbolTable;
import core.CommonTreeParser;
import core.LoocLexer;
import core.LoocParser;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;

import java.io.FileInputStream;
import java.nio.file.Paths;

public class TestLooc {

	private static final String LANGUAGE_NAME = "LOOC";
	private static final String DIR_TESTS = "samples";
	private static final String DIR_ASM = "asmSamples";
	private static final String DEFAULT_TEST_FILE = Paths.get(DIR_TESTS, "coucou.looc").toString();

	public static void main(String[] args) throws Exception {
		ANTLRInputStream input;

		if(args.length == 0) {
			System.out.println("\n -> Write some " + LANGUAGE_NAME + " code:\n\n");
			input = new ANTLRInputStream(System.in);
		}
		else
			input = new ANTLRInputStream(new FileInputStream(args[0]));

		LoocLexer lexer = new LoocLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LoocParser parser = new LoocParser(tokens);
		CommonTree tree = (CommonTree)parser.program().getTree();


		CommonTreeParser treeParser = new CommonTreeParser("##called in TestLooc.java");
		treeParser.parseCommonTreeParser(tree);

		System.out.print(treeParser.toString() + "\n");
		SymbolTable tds = new SymbolTable();
		treeParser.constructTDS(tree, tds, tds);
		System.out.println(treeParser.getRootSymbolTable().toString());


		DOTTreeGenerator gen = new DOTTreeGenerator();
		StringTemplate st = gen.toDOT(tree);


		//ASMWriter asm = new ASMWriter();
		//asm.initASMFile(Paths.get(DIR_TESTS, DIR_ASM, "test.src").toString(), tree);

	}
}
