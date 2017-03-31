import core.CommonTreeParser;
import factories.CommonTreeParserFactory;

/**
 * Created by mcdostone on 31/03/17.
 */
public class Sandbox {

    public static void main(String[] args) throws Exception {
        CommonTreeParser treeParser = CommonTreeParserFactory.createFromFile("./samples/Level3.looc");
    }
}
