package factories;

import TDS.SymbolTable;
import core.CommonTreeParser;
import core.LoocLexer;
import core.LoocParser;
import exceptions.MismatchTypeException;
import exceptions.SymbolAlreadyDeclaredException;
import exceptions.UndeclaredVariableException;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import java.io.FileInputStream;
import java.io.IOException;

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
		treeParser.constructTDS(tree, new SymbolTable());
		return treeParser;
	}
}
