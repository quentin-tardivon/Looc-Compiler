import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by quentin on 13/03/2017.
 */
public class CommonTreeParser {

    ArrayList<String> list = new ArrayList<>();

    public CommonTreeParser() {

    }

    public void parseCommonTreeParser(Tree tree) {
        for (int i=0; i<tree.getChildCount(); i++) {
            list.add(tree.getChild(i).toString());
            parseCommonTreeParser(tree.getChild(i));
        }
    }
}
