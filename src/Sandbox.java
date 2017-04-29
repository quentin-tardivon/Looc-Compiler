import ASMGenerator.ASMWriter;
import TDS.SymbolTable;
import TDS.entries.Variable;
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
        CommonTreeParser treeParser = CommonTreeParserFactory.createFromFile("./samples/level0.looc");

        int depl;

		for (String key: treeParser.getRootSymbolTable().getKeyEntries()) {
			depl = ((Variable)treeParser.getRootSymbolTable().get((key))).getDepl();
			System.out.println(depl);
		}

        System.out.println(((Variable) treeParser.getRootSymbolTable().get("i")).getDepl());
        //treeParser.getRootSymbolTable();

	    new ASMWriter().initASMFile("test");
        //System.out.println(treeParser.getRootSymbolTable());

	    SymbolTable root = new SymbolTable();
	    SymbolTable comp = new SymbolTable();
	    //root.putClass("Comparator")
    }
}
