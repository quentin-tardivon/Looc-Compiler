import TDS.Entry;
import TDS.SymbolTable;
import TDS.entries.Method;
import TDS.entries.Variable;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by quentin on 13/03/2017.
 */
public class CommonTreeParser {

	protected SymbolTable tds;

    protected ArrayList<String> list = new ArrayList<>();

    public CommonTreeParser() {

    }

    public void parseCommonTreeParser(Tree tree) {
	    list.add(tree.toString());
        for (int i=0; i<tree.getChildCount(); i++) {
            parseCommonTreeParser(tree.getChild(i));
        }
    }

    public void constructTDS(Tree tree, SymbolTable tds) {
	    SymbolTable newtds;
		switch(tree.getText()) {
			case "ROOT": this.tds = tds;
						 for (int i=0; i<tree.getChildCount();i++) {
						 	//System.out.println("Enter in child" + i);
							 constructTDS(tree.getChild(i), this.tds);
						 }
				         break;

			case "METHOD": System.out.println("Method encounter:" + tree.getChild(0).toString());
						   newtds = new SymbolTable(tds.getImbricationLevel()+1, tds);
						   tds.putLink(tree.getChild(0).getText(), newtds);
						   if (tree.getChildCount() == 4) {
						   	tds.put(tree.getChild(0).getText(), new Method(tree.getChild(2).getText()));
						   	constructTDS(tree.getChild(1), newtds);
						   	constructTDS(tree.getChild(3), newtds);
						   }
						   else {
							   tds.put(tree.getChild(0).getText(), new Method(tree.getChild(1).getText()));
							   constructTDS(tree.getChild(2), newtds);
						   }

				           break;

			case "FORMAL_PARAMETERS": System.out.println("Formal parameters encounter:");
									for(int i=0; i<tree.getChildCount(); i++ ) {
										constructTDS(tree.getChild(i), tds);
									}
									break;

			case "FORMAL_PARAMETER": System.out.println("Formal parameters encounter:");
									 tds.put(tree.getChild(0).getText(), new Parameter(tree.getChild(1).getText()));

			case "VAR_DEC": System.out.println("Var encounter:" + tree.getChild(0).toString());
						    tds.put(tree.getChild(0).getText(), new Variable(tree.getChild(1).getText()));
						    break;

			case "CLASS_DEC": System.out.println("Class encounter:" + tree.getChild(0).toString());
							  newtds = new SymbolTable(tds.getImbricationLevel()+1, tds);
							  tds.putLink(tree.getChild(0).getText(), newtds);
							  for (int j = 1; j<tree.getChildCount();j++) {
							  	constructTDS(tree.getChild(j), newtds);
							  }

							  break;


			case "BLOCK": this.tds.putLink(tree.getChild(0).getText(), new SymbolTable(this.tds.getImbricationLevel()+1, this.tds));
				          break;

			case "THEN": this.tds.putLink(tree.getChild(0).getText(), new SymbolTable(this.tds.getImbricationLevel()+1, this.tds)); //Certainly not working
				       break;

			case "ELSE": this.tds.putLink(tree.getChild(0).getText(), new SymbolTable(this.tds.getImbricationLevel()+1, this.tds)); //Certainly not working
						 break;

			case "VARS": for(int i= 0; i<tree.getChildCount();i++) {
							constructTDS(tree.getChild(i), tds);
						 }
						 break;

			case "METHODS": for(int i = 0; i<tree.getChildCount(); i++) {
								constructTDS(tree.getChild(i), tds);
							}
							break;

			case "BODY": for (int i = 0; i<tree.getChildCount(); i++) {
					        constructTDS(tree.getChild(i), tds);
						 }
						 break;

			default: for (int i=0; i<tree.getChildCount();i++) {
				System.out.println("## Default case " + tree);
				constructTDS(tree.getChild(i), tds);
			}
			break;
		}
    }


}
