package utils;

import TDS.Entry;
import TDS.SymbolTable;
import exceptions.InexactDoCallException;
import exceptions.StringOperationException;
import exceptions.UndeclaredMethodException;
import exceptions.UnknownNodeTypeException;
import org.antlr.runtime.tree.Tree;

import exceptions.*;
import sun.jvm.hotspot.debugger.cdbg.Sym;


/**
 * Created by tld on 22/03/2017.
 */
public class Util {

    public static Boolean testType(Entry l, String r, SymbolTable tds) throws Exception{
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


    /*public static String testTypeOper(Entry l, Entry r) throws StringOperationException {
        if (l.get("type").equals("string") ||  r.get("type").equals("string"))
            throw new StringOperationException();
        return "int";
    }*/

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

    public static void testExecMethod(String var,String method,SymbolTable tds) throws Exception {
        if (!tds.getInfo(var).get("type").equals(tds.getLink(tds.getInfo(var).get("type")).getInfo(method)))
            throw new UndeclaredMethodException(null,null,null);

    }

    public static void testDo(Tree doChild,SymbolTable tds) throws Exception {
        System.out.println("testDo node : " +doChild);
        switch (doChild.getText()) {
            case "CALL":
                //Util.testCall(doChild,tds);
                Util.testExecMethod(doChild.getChild(0).getText(),doChild.getChild(1).getText(),tds);
                Util.testVoidCall(doChild,tds);
                break;


            default: //OPER ou new
                throw new InexactDoCallException(null,null,doChild.getText());

        }
    }

    public static void testCall(Tree callNode,SymbolTable tds) throws Exception {

       // for (int j = 1; j < callNode.getChildCount(); j++) {
        //}
        Util.testExecMethod(callNode.getChild(0).getText(),callNode.getChild(1).getText(),tds);

    }

    public static void testVoidCall(Tree callNode, SymbolTable tds) throws Exception {
        if (tds.getInfo(callNode.getChild(0).getText()).get("returnType").equals(null)){
            throw new MethodNonVoidException(null,null,callNode.getChild(0).getText());
        }
    }

    public static void undeclaredClass(String className, SymbolTable tds) throws Exception {
    	throw new UndeclaredClassException(null, null, className);
    }

	public static void undeclaredToken(String tokenName, SymbolTable tds) throws Exception {
    	throw new UndeclaredVariableException(null, null, tokenName);
	}

	public static void undeclaredInheritance(String className, SymbolTable tds) throws Exception {
		throw new UndeclaredInheritanceException(null, null, className);
	}

	public static void mismatchType(String filename, Tree node, String type1 , String type2, String idf1, String idf2) throws Exception {
        throw new MismatchTypeException(filename,node,type1,type2,idf1,idf2);
    }

    public static String callReturnType(Tree node, SymbolTable tds)throws Exception{
        return tds.getInfo(node.getText()).get("returnType");
    }
}
