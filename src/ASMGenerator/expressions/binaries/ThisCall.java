package ASMGenerator.expressions.binaries;

import ASMGenerator.expressions.Variable;
import TDS.SymbolTable;

/**
 * Created by quentin on 21/05/2017.
 */
public class ThisCall extends Variable {

	public ThisCall(TDS.entries.Variable v, SymbolTable TDS) {
		super(v, TDS);
	}

}
