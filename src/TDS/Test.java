package TDS;

import java.util.HashMap;

/**
 * Created by mcdostone on 13/03/17.
 */
public class Test {

    /*
        var n : int;
        n := 10;
        method init() {
    	     var t : int;
    	     n := 12;
    	}

        -- TDS main --
            n ->    type = 'int',
                    kind = 'var',
                    depl = 0

            init -> type = method
                    return = void
                    params = []
                    depl = 1
                    link = TDS init

            father -> null

        -- TDS init --
            t ->    type = 'int',
                    kind = 'var',
                    depl = 0

            father -> null
     */

    public static void main(String[] args) {
        SymbolTable tds = new SymbolTable();
        HashMap<String, String> tmp = new HashMap<String, String>();
        tmp.put("type", "int");
        tmp.put("kind", "var");
        tmp.put("depl", "0");



        tds.put("n", tmp);
    }
}


