package utils;

import TDS.Entry;
import TDS.SymbolTable;
import core.Keywords;
import exceptions.*;
import org.antlr.runtime.tree.Tree;


/**
 * Created by tld on 22/03/2017.
 */
public class Util {

    public static Boolean testType(Entry l, String r, SymbolTable tds) throws Exception{
        if (l.get(Entry.TYPE).equals(r)) {
	        return true;
        }
        else if (tds.get(r)!=null) {
        	return l.get(Entry.TYPE).equals(tds.get(r).get(Entry.INHERIT));
        }
        else if(tds.getFather() != null) {
        	return testType(l,r,tds.getFather());
        }
        else {
	        return false;
        }
    }

    public static String testTypeOper(String nodeL, String nodeR) throws Exception {
        if (nodeL.equals(Keywords.INTEGER) && nodeR.equals(Keywords.INTEGER)) {
        	return Keywords.INTEGER;
        }
        else if (nodeL.equals(Keywords.STRING) && nodeR.equals(Keywords.STRING)) {
	        throw new StringOperationException();
        }
        else {
			throw new MismatchOperationException();
        }
    }

    public static String getType(String s, SymbolTable tds) throws Exception {
        if (s.matches("[0-9]+")) {return Keywords.INTEGER;}
        else if (s.matches("'.*'")){
            return Keywords.STRING;
        }
        else {
            return tds.getInfo(s).get(Entry.TYPE);

        }
    }

    public static void testReturnType(String expected, String real) throws Exception {
        if(!expected.equals(real))
            throw new ReturnValueTypeMismatchException(expected, real);

    }

    public static void testDo(Tree doChild,SymbolTable tds) throws Exception {
        Util.testCall(doChild, tds);
    }

    public static void testCall(Tree callNode,SymbolTable tds) throws Exception {
        if(!(callNode.getChildCount() >= 2 && callNode.getChildCount() <= 3))
            throw new InexactDoCallException(null,null,callNode.getText());
        else {
            // Test the receiver: this / super / idf
            String receiver = callNode.getChild(callNode.getChildCount() - 1).getText();
            String called = callNode.getChild(0).getText();
            SymbolTable symbolTableReceiver = Util.getSymbolTable(receiver, tds);
            int actualNbParams = callNode.getChildCount() == 3 ? callNode.getChild(1).getChildCount() : 0;
            // Check if method exists
            if(symbolTableReceiver.get(called) == null || !symbolTableReceiver.get(called).getName().equals(Entry.METHOD))
                throw new UndeclaredMethodException(null, null, receiver);

            // Check Number of params
            if(Util.countParameters(symbolTableReceiver.getLink(called)) != actualNbParams)
                throw new LoocException(null, null, "EXCEPTION NO GOOD NUMBER OF PARAMS // TODO CREATE THE DEDICATED EXCEPTION, " + called + " - " + tds);
        }
    }

    public static void testVoidCall(Tree callNode, SymbolTable tds) throws Exception {
        if (tds.getInfo(callNode.getChild(0).getText()).get(Entry.RETURN_TYPE).equals(null)){
            throw new MethodNonVoidException(null,null,callNode.getChild(0).getText());
        }
    }

    public static void undeclaredClass(String className, SymbolTable tds) throws Exception {
    	throw new UndeclaredClassException(null, null, className);
    }

    private static int countParameters(SymbolTable tds) {
        int count = 0;
        for(String key: tds.getKeyEntries()) {
            if(tds.get(key).getName().equals(Entry.PARAMETER))
                count++;
        }
        return count;
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
        return tds.getInfo(node.getText()).get(Entry.RETURN_TYPE);
    }

    /**
     * This method will find the appropriate Symbol depending on the type of the receiver (idf , this or super in our case).
     *
     *          var a: Animal ;
     *          do a.eat()
     *
     *          // getSymbolTable(a, currentTDS) => returns the Symbol Table of Animal class
     *
     */
    private static SymbolTable getSymbolTable(String receiver, SymbolTable currentTDS) throws Exception {
        switch (receiver) {
            case Keywords.THIS:
                return currentTDS.getFather();
            case Keywords.SUPER:
                String inheritedClass = currentTDS.getFather().getFather().get(currentTDS.getFather().getName()).get(Entry.INHERIT);
                return currentTDS.getFather().getFather().getLink(inheritedClass);
            default:
                String typeIdf = currentTDS.getInfo(receiver).get(Entry.TYPE);
                return currentTDS.getLink(typeIdf);
        }
    }
}
