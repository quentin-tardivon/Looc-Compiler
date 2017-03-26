package utils;

import TDS.Entry;
import TDS.SymbolTable;
import exceptions.StringOperationException;
import exceptions.UndeclaredVariableException;
import exceptions.UnknownNodeTypeException;
import org.antlr.runtime.tree.Tree;

import javax.lang.model.type.UnknownTypeException;

/**
 * Created by tld on 22/03/2017.
 */
public class Util {

    public static Boolean testType(Entry l, String r) throws UnknownNodeTypeException{
        if (l.get("type").equals("int") && r.equals("int"))
            return true;
        if (l.get("type").equals("string") && r.equals("string"))
            return true;
        return false;
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

}
