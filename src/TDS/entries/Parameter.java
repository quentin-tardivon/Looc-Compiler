package TDS.entries;

import TDS.Entry;

/**
 * @author Maxime Escamez
 * @author Théo Le Donné
 * @author Quentin Tardivon
 * @author Yann Prono
 */
public class Parameter extends Variable {

	private int order;

	public Parameter(String type) {
		super(Entry.PARAMETER, type);
		this.order=0;
	}

	public Parameter(String type, int order) {
		super(Entry.PARAMETER, type);
		this.order=order;
	}
	public int getOrder(){
		return this.order;

	}

	public String toString() {
		return super.toString()
				+ String.format(" - %-10s -> %d\n", "Order", this.order);
	}

}