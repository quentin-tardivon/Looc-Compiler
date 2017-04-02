package factories;

import TDS.SymbolTable;
import core.CommonTreeParser;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;

import java.io.FileInputStream;

/**
 * Factory for a core.CommonTreeParser
 */
public class CommonTreeParserFactory {

	public static CommonTreeParser createFromFile(String filename) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(filename));
		LoocLexer lexer = new LoocLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LoocParser parser = new LoocParser(tokens);
		CommonTree tree = (CommonTree) parser.program().getTree();



		CommonTreeParser treeParser = new CommonTreeParser(filename);
		SymbolTable tds = new SymbolTable();
		treeParser.constructTDS(tree, tds, tds);

		return treeParser;
	}
}
