package utils;

import TDS.Entry;
import exceptions.UnknownNodeTypeException;

import javax.lang.model.type.UnknownTypeException;

/**
 * Created by tld on 22/03/2017.
 */
public class Util {

    public static Boolean testType(Entry l, String r) throws UnknownNodeTypeException{
        if (l.get("type").equals("int") && Util.getType(r).equals("int"))
            return true;
        if (l.get("type").equals("string") && Util.getType(r).equals("string"))
            return true;
        return false;
    }

    public static String getType(String s) throws UnknownNodeTypeException {
        if (s.matches("[0-9]+")) {return "int";}
        if (s.matches("'.*'")) {return "string";}
        throw new UnknownNodeTypeException(s);

    }
}
