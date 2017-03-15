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

    public void constructTDS(Tree tree) {
		switch(tree.getText()) {
			case "ROOT": this.tds = new SymbolTable();
						 for (int i=0; i<tree.getChildCount();i++) {
							 constructTDS(tree.getChild(i));
						 }
				         break;

			case "METHOD": this.tds.putLink(tree.getChild(0).getText(),new SymbolTable(this.tds.getImbricationLevel()+1, this.tds));
				           break;

			case "VAR_DEC": this.tds.put(tree.getChild(0).getText(), new Variable(tree.getChild(1).getText()));
						    break;

			case "CLASS_DEC": this.tds.putLink(tree.getChild(0).getText(),new SymbolTable(this.tds.getImbricationLevel()+1, this.tds));
							  break;

			default: for (int i=0; i<tree.getChildCount();i++) {
				constructTDS(tree.getChild(i));
			}
			break;
		}
    }


}
