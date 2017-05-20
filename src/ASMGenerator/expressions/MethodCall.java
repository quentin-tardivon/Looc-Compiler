package ASMGenerator.expressions;

import ASMGenerator.ASMUtils;
import TDS.Entry;
import TDS.SymbolTable;
import TDS.entries.*;
import org.antlr.runtime.tree.Tree;

/**
 * Created by quentin on 14/05/2017.
 */
public class MethodCall extends Expression{
	public static final int OFFSET_ENV = 4;
	String nameMeth;
	SymbolTable tds;
	String nameCaller;
	Tree tree;

	public MethodCall(String nameMeth, SymbolTable tds, String nameCaller) {

		this.tds = tds;
		this.nameMeth = nameMeth;
		this.nameCaller = nameCaller;
	}

	public MethodCall(Tree tree, SymbolTable tds) {
		this.tds = tds;
		this.tree = tree;
		this.nameMeth = tree.getChild(0).getText();
		this.nameCaller = tree.getChild(tree.getChildCount()-1).getText();
	}

	@Override
	public String generate() {

		String buf = "";
		for (int i=0; i < this.tree.getChild(1).getChildCount(); i++) {
			System.out.println(tree.getChild(1).getChild(i).getText());
			buf = ASMUtils.formatASM("", "LDW", "R0, #-" + ((TDS.entries.Variable) this.tds.get(tree.getChild(1).getChild(i).getText())).getDepl() + OFFSET_ENV)
					+ ASMUtils.formatASM("", "STW", "R0, -(SP)");
		}
		return ASMUtils.formatASM("", "LDW", "R0, #-" + ((TDS.entries.Variable) this.tds.get(this.nameCaller)).getDepl() + OFFSET_ENV)
				+ ASMUtils.formatASM("", "STW", "R0, -(SP)") //TODO finir d'empiler l'env là: paramètre et appelant
				+ buf
				+ ASMUtils.formatASM("", "JSR", "@"+this.tds.getInfo(this.nameCaller).get(Entry.TYPE) + this.nameMeth)
				+ ASMUtils.formatASM("", "ADI", "SP, SP, #2");
	}


	@Override
	public String getType() {
		return null;
	}
}
