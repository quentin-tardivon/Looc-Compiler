package utils;

import TDS.Entry;
import TDS.SymbolTable;
import exceptions.InexactDoCallException;
import exceptions.StringOperationException;
import exceptions.UndeclaredMethodException;
import exceptions.UnknownNodeTypeException;
import org.antlr.runtime.tree.Tree;

import exceptions.*;


/**
 * Created by tld on 22/03/2017.
 */
public class Util {

    public static Boolean testType(Entry l, String r, SymbolTable tds) throws UnknownNodeTypeException{
    	System.out.println(r);
        if (l.get("type").equals(r)) {
	        return true;
        }
        else if (tds.get(r)!=null) {
        	return l.get("type").equals(tds.get(r).get("Inherit"));
        }
        else if(tds.getFather() != null) {

        	return testType(l,r,tds.getFather());
        }
        else {

	        return false;
        }

    }


    public static String testTypeOper(Entry l, Entry r) throws StringOperationException {
        if (l.get("type").equals("string") ||  r.get("type").equals("string"))
            throw new StringOperationException();
        return "int";
    }

    public static String testTypeOper(String nodeL, String nodeR) throws Exception {
        if (nodeL.equals("int") && nodeR.equals("int")) {
        	return "int";
        }
        else if (nodeL.equals("string") && nodeR.equals("string")) {
	        throw new StringOperationException();
        }
        else {
			throw new MismatchOperationException();
        }
    }

    public static String getType(String s, SymbolTable tds) throws Exception {
        if (s.matches("[0-9]+")) {return "int";}
        else if (s.matches("'.*'")){
            return "string";
        }
        else {
            return tds.getInfo(s).get("type");

        }
    }

    public static void testReturnType(String expected, String real) throws Exception {
        if(!expected.equals(real))
            throw new ReturnValueTypeMismatchException(expected, real);

    }

    public static Boolean testExecMethod(String var,String method,SymbolTable tds) throws Exception {
        if (tds.getInfo(var).get("type").equals(tds.getLink(tds.getInfo(var).get("type")).getInfo(method)))
            return true;
        else {
            throw new UndeclaredMethodException(null,null,null);
        }
    }

    public static void testDo(Tree doChild,SymbolTable tds) throws Exception {
        switch (doChild.getText()) {
            case "CALL":
                if (!Util.testExecMethod(doChild.getChild(0).getText(),doChild.getChild(1).getText(),tds)){
                    System.out.println("c pa bi1");
                }
                break;


            default: //OPER ou new
                throw new InexactDoCallException(null,null,doChild.getText());

        }
    }

}
