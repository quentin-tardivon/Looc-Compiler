package utils;

import TDS.Entry;
import TDS.SymbolTable;
import exceptions.StringOperationException;
import exceptions.UndeclaredMethodException;
import exceptions.UnknownNodeTypeException;


/**
 * Created by tld on 22/03/2017.
 */
public class Util {

    public static Boolean testType(Entry l, String r, SymbolTable tds) throws UnknownNodeTypeException{
    	System.out.println(r);
        if (l.get("type").equals(r)) {
	        System.out.println("Types OK");
	        return true;
        }
        else if (tds.get(r)!=null) {
        	System.out.println("TDS non nulle");
        	System.out.println(tds.getLink(r).get("Inherit"));
        	return l.get("type").equals(tds.get(r).get("Inherit"));
        }
        else if(tds.getFather() != null) {
	        System.out.println("Père de la TDS non nul");
        	return testType(l,r,tds.getFather());
        }
        else {
		    System.out.println("Type non ok");
	        return false;
        }

    }


    public static String testTypeOper(Entry l, Entry r) throws StringOperationException {
        if (l.get("type").equals("string") ||  r.get("type").equals("string"))
            throw new StringOperationException();
        return "int";
    }

    public static String testTypeOper(String nodeL, String nodeR) throws StringOperationException {
        if (nodeL.equals("int") && nodeR.equals("int")) return "int";
        else if (nodeL.equals("string") && nodeR.equals("string")) return "string";
        else throw new StringOperationException();
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

    public static Boolean testExecMethod(String var,String method,SymbolTable tds) throws Exception {
        if (tds.getInfo(var).get("type").equals(tds.getLink(tds.getInfo(var).get("type")).getInfo(method)))
            return true;
        else {
            throw new UndeclaredMethodException(null,null,null);
        }
    }

}
