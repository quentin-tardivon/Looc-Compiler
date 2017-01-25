grammar Looc;

@header {
	import java.util.HashMap;
}

@members {
	HashMap<String, Integer> memory = new HashMap<String, Integer>();
}

/**----------------------
	Nonterminal symbols
------------------------*/


program: 		var_decl* instruction+;

//class_decl:		'class' CLASS inheritance '(' ')';

//inheritance: 	'inherits' CLASS 
				//|
				//;

var_decl: 		'var' IDF ':' type ';';

type: 			'int' 
			| 'string';

// #### Not working because 'return' symbol cannot be used in java ....
//return_decl: 	'return(' expression ')';


instruction: 	IDF ':=' expression ';'{memory.put($IDF.text, new Integer($expression.value));}
				| 'for' IDF 'in' expression '..' expression 'do' instruction+ 'end'
				| 'if'  expression 'then' instruction ('else' instruction)? 'fi'
	      			| print;

expression returns [int value]: 	IDF expressionbis
					| INT {$value = Integer.parseInt($INT.text);} expressionbis;

expressionbis returns [int value]: 	OPER expression  
					| '+' e=expression {$value += $e.value;}
					| '-' e=expression {$value -= $e.value;}
					| '/' e=expression {$value /= $e.value;}
					| '*' e=expression {$value *= $e.value;}
					| ;	

print:			'write' IDF {System.out.println(memory.get($IDF.text));}';' ;



/**----------------------
	Terminal symbols
------------------------*/


//CLASS: 	('A'..'Z')('a'..'z'|'A'..'Z')*;

IDF: 	('a'..'z')('a'..'z'|'A'..'Z')*;

INT:	'0'..'9'+;

OPER: 	'<'|'<='|'>'|'>='|'=='|'!=';

WS: 	(' '|'\t'|'\n')+{$channel=HIDDEN;};

NEWLINE: '\r'? '\n';