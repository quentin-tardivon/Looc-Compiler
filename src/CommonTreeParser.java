import TDS.Entry;
import TDS.SymbolTable;
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
				           break;

			case "VAR_DEC": System.out.println("Var encounter:" + tree.getChild(0).toString());
						    this.tds.put(tree.getChild(0).getText(), new Variable(tree.getChild(1).getText()));
						    break;

			case "CLASS_DEC": System.out.println("Class encounter:" + tree.getChild(0).toString());
							  newtds = new SymbolTable(tds.getImbricationLevel()+1, tds);
							  tds.putLink(tree.getChild(0).getText(), newtds);
							  constructTDS(tree.getChild(1), newtds);
							  break;

			case "BLOCK": this.tds.putLink(tree.getChild(0).getText(), new SymbolTable(this.tds.getImbricationLevel()+1, this.tds));
				          break;

			case "THEN": this.tds.putLink(tree.getChild(0).getText(), new SymbolTable(this.tds.getImbricationLevel()+1, this.tds)); //Certainly not working
				       break;

			case "ELSE": this.tds.putLink(tree.getChild(0).getText(), new SymbolTable(this.tds.getImbricationLevel()+1, this.tds)); //Certainly not working
						 break;

			default: for (int i=0; i<tree.getChildCount();i++) {
				constructTDS(tree.getChild(i), tds);
			}
			break;
		}
    }


}
