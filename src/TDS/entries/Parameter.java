package TDS.entries;

import TDS.Entry;
import core.Keywords;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class Parameter extends Variable {

	private int order;
	private int depl;

	public Parameter(String type) {
		super(Entry.PARAMETER, type);
		this.order=0;
		this.depl=0;
	}

	public Parameter(String type, int order) {
		super(Entry.PARAMETER, type);
		this.order=order;
		if (type.equals(Keywords.INTEGER)) this.depl=-((order+1)*2);
		else if (type.equals(Keywords.STRING)) System.out.println("Zut, c'est une chaine de caractère");
		System.out.println("Param type : " + type + " Depl : " + depl);

	}

	public int getOrder(){
		return this.order;

	}
	public int getDepl(){
		return this.depl;
	}

	public String toString() {
		return super.toString() + " Order: " + this.order + " Depl : " + this.depl;
	}

}