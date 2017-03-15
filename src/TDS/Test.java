package TDS;

import java.util.HashMap;

/**
 * Created by mcdostone on 13/03/17.
 */
public class Test {

    /*
        class Test = (
	    var n :int;

	    method init() {
		    var t: int;
		    n:=12;
		    t:=5;}
	    n:=10;
	    )

        -- TDS_main --
            n ->    type = 'int',
                    kind = 'var',
                    depl = 0

            init -> type = method
                    return = void
                    params = []
                    depl = 1
                    link = TDS init

            father -> null

        -- TDS_init --
            t ->    type = 'int',
                    kind = 'var',
                    depl = 0

            father -> TDS_main
     */

    public static void main(String[] args) {
        SymbolTable tds_main = new SymbolTable();
        SymbolTable tds_init = new SymbolTable();
        HashMap<String, Object> tmp_n = new HashMap<>();
        HashMap<String, Object> tmp_init = new HashMap<>();
        HashMap<String, Object> tmp_t = new HashMap<>();

        tmp_n.put("type", "int");
        tmp_n.put("kind", "var");
        tmp_n.put("depl", "0");

        tds_main.put("n", tmp_n);



        tmp_init.put("type", "method");
        tmp_init.put("return", "void");
        tmp_init.put("params", "");
        tmp_init.put("depl", "1");
        tmp_init.put("link",tds_init);

        tds_main.put("init", tmp_init);


        tmp_t.put("type", "int");
        tmp_t.put("kind", "var");
        tmp_t.put("depl", "0");

        tds_init.put("t",tmp_t);

        System.out.println("tds main : "+tds_main.toString());

        System.out.println("init dans tds main : "+tds_main.getEntries("init"));

        //System.out.println("init dans tds main"+(tds_main.get("init")).getClass().toString());


    }

}
