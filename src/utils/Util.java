package utils;

import TDS.Entry;
import TDS.SymbolTable;
import TDS.entries.Parameter;
import core.CommonTreeParser;
import core.Keywords;
import exceptions.*;
import org.antlr.runtime.tree.Tree;

import java.awt.image.LookupOp;
import java.util.ArrayList;
import java.util.Comparator;


/**
 * Created by tld on 22/03/2017.
 */
public class Util {

	/**
	 * Detect semantic error caused by wrong operation
	 * @param nodeL
	 * @param nodeR
	 * @return
	 * @throws Exception
	 */
	private static String testTypeOper(String nodeL, String nodeR) throws LoocException {
        if (nodeL.equals(Keywords.INTEGER) && nodeR.equals(Keywords.INTEGER)) {
        	return Keywords.INTEGER;
        }
        else if (nodeL.equals(Keywords.STRING) && nodeR.equals(Keywords.STRING)) {
	        throw new StringOperationException(CommonTreeParser.filename, CommonTreeParser.node);
        }
        else {
			throw new MismatchOperationException(CommonTreeParser.filename, CommonTreeParser.node);
        }
    }

	/**
	 * Return type of a token
	 * @param s
	 * @param tds
	 * @return
	 * @throws Exception
	 */
	public static String getType(String s, SymbolTable tds) throws LoocException {
        if (s.matches("[0-9]+"))
            return Keywords.INTEGER;
        if (s.matches("\".*\""))
            return Keywords.STRING;
        else if (tds.getInfo(s) != null) {
	        isInit(s,tds, tds);
	        return tds.getInfo(s).get(Entry.TYPE);
        }
	    else {
        	throw new UndeclaredVariableException(CommonTreeParser.filename, CommonTreeParser.node, s); //TODO Vérifier que c'est toujours une variable

        }
    }

	/**
	 * Detect semantic error caused by wrong return type
	 * @param expected
	 * @param real
	 * @throws Exception
	 */
	public static void testReturnType(String expected, String real) throws LoocException {
        if(!expected.equals(real))
            throw new ReturnValueTypeMismatchException(CommonTreeParser.filename, CommonTreeParser.node, expected, real);

    }


	/**
	 * Detect semantic error caused by wrong utilization of read expression
	 * @param readingType
	 * @throws Exception
	 */
	public static void testReadUse(String readingType) throws LoocException {
		if (!"int".equals(readingType)) {
			throw new ReadUsageException(CommonTreeParser.filename, CommonTreeParser.node, readingType);
		}
    }

	/**
	 * Detect semantic error caused by wrong utilization of write expression
	 * @param readingType
	 * @throws Exception
	 */
	public static void testWriteUse(String readingType) throws LoocException {
		if (!("int".equals(readingType) || "string".equals(readingType))) {
			throw new WriteUsageException(CommonTreeParser.filename, CommonTreeParser.node, readingType);
		}
	}

	/**
	 * Detect semantic error with wrong utilization of do expression
	 * @param doChild
	 * @param tds
	 * @param rootTDS
	 * @throws Exception
	 */
	public static void testDo(Tree doChild,SymbolTable tds, SymbolTable rootTDS) throws LoocException {

		if(doChild.getText().equals("CALL")) {
			// Test if the method is declared
			Util.testCall(doChild, tds, rootTDS);

			// Test if the method is void
			String called = doChild.getChild(0).getText();
			String receiver = doChild.getChild(doChild.getChildCount() - 1).getText();
			SymbolTable symbolTableReceiver = Util.getSymbolTable(receiver, tds, rootTDS);
			if (symbolTableReceiver.get(called).get(Entry.RETURN_TYPE) != null) {
				throw new MethodNonVoidException(CommonTreeParser.filename, CommonTreeParser.node, called);
			}
		}
		else throw new InexactUsesOfDoException(CommonTreeParser.filename, CommonTreeParser.node,doChild.getText());

	}

	/**
	 * Detect semantic error cause by wrong utilization of call
	 * @param callNode
	 * @param tds
	 * @param rootTDS
	 * @throws Exception
	 */
    public static void testCall(Tree callNode,SymbolTable tds, SymbolTable rootTDS) throws LoocException {

            // Test the receiver: this / super / idf
            String receiver = callNode.getChild(callNode.getChildCount() - 1).getText();
            String called = callNode.getChild(0).getText();
            SymbolTable symbolTableReceiver = getSymbolTable(receiver, tds, rootTDS);
            int actualNbParams = callNode.getChildCount() == 3 ? callNode.getChild(1).getChildCount() : 0;
            // Check if method exists

            if(symbolTableReceiver.get(called) == null || !symbolTableReceiver.get(called).getName().equals(Entry.METHOD))
                throw new UndeclaredMethodException(CommonTreeParser.filename, CommonTreeParser.node, called);


            ArrayList<Parameter> list = Util.getParameters(Util.getSymbolTable(receiver,tds,rootTDS).getLink(called));
            //System.out.println("list"+list);
            // Check Number of params
            if(list.size() != actualNbParams)
                throw new InexactParamsNumberException(CommonTreeParser.filename, CommonTreeParser.node, called);


            // Check the Actualparams type
            for(int i=0; i<actualNbParams; i++){
	            Tree effectiveParam = callNode.getChild(1).getChild(i);
                if(!Util.subTreeType(effectiveParam, tds, rootTDS).equals(list.get(i).get(Entry.TYPE))){
                    throw new ParameterTypeMismatchException(CommonTreeParser.filename, CommonTreeParser.node,Util.getType(callNode.getChild(1).getChild(i).getText(),tds),list.get(i).get(Entry.TYPE),callNode.getChild(1).getChild(i).getText());
                }
            }

    }


	/**
	 * Return parameters of a method
	 * @param tds
	 * @return
	 */
	private static ArrayList<Parameter> getParameters(SymbolTable tds){
        ArrayList<Parameter> list= new ArrayList<>();
        for(String key: tds.getKeyEntries()) {
            if(tds.get(key).getName().equals(Entry.PARAMETER))
                list.add((Parameter)tds.get(key));
        }
        list.sort(new Comparator<Parameter>() {
            @Override
            public int compare(Parameter o1, Parameter o2) {
                return o1.getOrder() - o2.getOrder();
            }
        });
        return list;

    }


	/**
	 * Return the return type of a method
	 * @param node
	 * @param tds
	 * @param rootTDS
	 * @return
	 * @throws Exception
	 */
    private static String getTypeReturnByMethod(Tree node, SymbolTable tds,SymbolTable rootTDS) throws LoocException {
        String receiver = node.getChild(node.getChildCount() - 1).getText();
        String called = node.getChild(0).getText();
        SymbolTable symbolTableReceiver = Util.getSymbolTable(receiver, tds, rootTDS);

        return symbolTableReceiver.get(called).get(Entry.RETURN_TYPE);
    }


	/**
	 * Detect semantic error if a class is undeclared
	 * @param className
	 * @param tds
	 * @throws Exception
	 */
	public static void undeclaredClass(String className, SymbolTable tds) throws LoocException {
    	throw new UndeclaredClassException(CommonTreeParser.filename, CommonTreeParser.node, className);
    }


	/**
	 * Detect semantic error if a token is not declared before usage
	 * @param tokenName
	 * @param tds
	 * @throws Exception
	 */
	public static void undeclaredToken(String tokenName, SymbolTable tds) throws LoocException {
    	throw new UndeclaredVariableException(CommonTreeParser.filename, CommonTreeParser.node, tokenName);
	}

	/**
	 * Detect semantic error in case of undeclared inheritance class
	 * @param className
	 * @param tds
	 * @throws Exception
	 */
	public static void undeclaredInheritance(String className, SymbolTable tds) throws LoocException {
		throw new UndeclaredInheritanceException(CommonTreeParser.filename, CommonTreeParser.node, className);
	}


	/**
	 * Detect semantic error in case of unauthorized inheritance
	 * @param nodeTypeLeft
	 * @param nodeTypeRight
	 * @param rootTDS
	 * @return
	 * @throws Exception
	 */
    public static Boolean validInherit(String nodeTypeLeft, String nodeTypeRight, SymbolTable rootTDS) throws LoocException {

    	SymbolTable leftTDS = rootTDS.findClass(nodeTypeLeft);
    	if (leftTDS == null) {
    		return false;
	    }
	    else {
		    return  leftTDS.findClass(nodeTypeRight) != null;
	    }


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
    private static SymbolTable getSymbolTable(String receiver, SymbolTable currentTDS, SymbolTable rootTDS) throws LoocException {
        switch (receiver) {
            case Keywords.THIS:
                return currentTDS.getFather();
            case Keywords.SUPER:
                String inheritedClass = currentTDS.getFather().getFather().get(currentTDS.getFather().getName()).get(Entry.INHERIT);
                return rootTDS.findClass(inheritedClass);
            default:
                Entry e = currentTDS.getInfo(receiver);
                if(e == null || !(e.getName().equals(Entry.VARIABLE)))
                    throw new UndeclaredVariableException(CommonTreeParser.filename, CommonTreeParser.node, receiver);
                return rootTDS.findClass(e.get(Entry.TYPE));
        }
    }


	/**
	 * Return the type of a subtree expression
	 * @param node
	 * @param tds
	 * @param rootTDS
	 * @return
	 * @throws Exception
	 */
	public static String subTreeType(Tree node,SymbolTable tds, SymbolTable rootTDS) throws LoocException {
        switch (node.getText()) {
            case "PLUS":
                return Util.testTypeOper(subTreeType(node.getChild(0),tds, rootTDS),subTreeType(node.getChild(1),tds, rootTDS));
            case "DIFF":
                return Util.testTypeOper(subTreeType(node.getChild(0),tds, rootTDS),subTreeType(node.getChild(1),tds, rootTDS));
            case "MUL":
                return Util.testTypeOper(subTreeType(node.getChild(0),tds, rootTDS),subTreeType(node.getChild(1),tds, rootTDS));
            case "DIV":
                return Util.testTypeOper(subTreeType(node.getChild(0),tds, rootTDS),subTreeType(node.getChild(1),tds, rootTDS));
            case ">":
                return Util.testTypeOper(subTreeType(node.getChild(0),tds, rootTDS),subTreeType(node.getChild(1),tds, rootTDS));
            case ">=":
                return Util.testTypeOper(subTreeType(node.getChild(0),tds, rootTDS),subTreeType(node.getChild(1),tds, rootTDS));
            case "<":
                return Util.testTypeOper(subTreeType(node.getChild(0),tds, rootTDS),subTreeType(node.getChild(1),tds, rootTDS));
            case "<=":
                return Util.testTypeOper(subTreeType(node.getChild(0),tds, rootTDS),subTreeType(node.getChild(1),tds, rootTDS));
            case "==":
                return Util.testTypeOper(subTreeType(node.getChild(0),tds, rootTDS),subTreeType(node.getChild(1),tds, rootTDS));
            case "!=":
                return Util.testTypeOper(subTreeType(node.getChild(0),tds, rootTDS),subTreeType(node.getChild(1),tds, rootTDS));
            case Keywords.NEW:
                return node.getChild(0).getText();
            case Keywords.THIS:
                return Util.getSymbolTable(node.getText(), tds, rootTDS).getName();
            case "CALL":
                Util.testCall(node, tds, rootTDS);
                return Util.getTypeReturnByMethod(node, tds, rootTDS);
            case "-":
                return Util.subTreeType(node.getChild(0), tds, rootTDS);
            case Keywords.NIL:
                return Keywords.NIL;
            default:
                return Util.getType(node.getText(),tds);
        }
    }

	/**
	 * Detect semantic error on initialization
	 * @param symbol
	 * @param tds
	 * @param rootTDS
	 * @throws Exception
	 */
    public static void isInit(String symbol, SymbolTable tds, SymbolTable rootTDS) throws LoocException {
    	if (!tds.getInfo(symbol).isInit()) {
    		throw new VarUninitializedException(CommonTreeParser.filename, CommonTreeParser.node, symbol);
	    }
    }

	/**
	 * Detect semantic errors on affectation
	 * @param tree
	 * @param tds
	 * @param rootTDS
	 * @throws Exception
	 */
	public static void testAffectation(Tree tree, SymbolTable tds, SymbolTable rootTDS) throws LoocException {
		Entry entry = tds.getInfo(tree.getChild(0).getText());
		String rightNodeType= null;

		if (entry == null)
			Util.undeclaredToken(tree.getChild(0).getText(), tds);

		tds.getInfo(tree.getChild(0).getText()).setInit(true);
		switch (tree.getChild(1).getText()) {
			case Keywords.NEW:
				// Check if the class has been declared previously

				if (rootTDS.findClass(tree.getChild(1).getChild(0).getText()) == null)
					Util.undeclaredClass(tree.getChild(1).getChild(0).getText(), tds);

				rightNodeType = tree.getChild(1).getChild(0).toString();
				if (!entry.get(Entry.TYPE).equals(rightNodeType)) {
					if (!Util.validInherit(entry.get(Entry.TYPE),rightNodeType, rootTDS)) {
						throw new MismatchTypeException(CommonTreeParser.filename, CommonTreeParser.node, rightNodeType, entry.get(Entry.TYPE), entry.getName());
					}

				}
				break;
			case Keywords.NIL:
				entry.put(Entry.NIL, "true");
				rightNodeType="nil";
				break;
			case "CALL":
				Util.testCall(tree.getChild(1), tds, rootTDS);
				break;
			default:
				rightNodeType = Util.subTreeType(tree.getChild(1), tds, rootTDS);
		}

		if (!entry.get(Entry.TYPE).equals(rightNodeType)) {
			if(!rightNodeType.equals("nil")) {
				if (!Util.validInherit(entry.get(Entry.TYPE),rightNodeType, rootTDS)) {
					throw new MismatchTypeException(CommonTreeParser.filename, CommonTreeParser.node, rightNodeType, entry.get(Entry.TYPE), entry.getName());
				}
			}
		}
	}
}
