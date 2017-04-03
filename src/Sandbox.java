import TDS.SymbolTable;
import core.CommonTreeParser;
import factories.CommonTreeParserFactory;

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
        CommonTreeParser treeParser = CommonTreeParserFactory.createFromFile("./samples/errorSamples/AllSemantic.looc");
        System.out.println(treeParser.getRootSymbolTable());

	    SymbolTable root = new SymbolTable();
	    SymbolTable comp = new SymbolTable();
	    //root.putClass("Comparator")
    }
}
