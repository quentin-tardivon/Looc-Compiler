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


program: 		class_decl var_decl* instruction+;

class_decl:		'class' CLASS inheritance '(' ')';

inheritance: 	'inherits' CLASS 
				|
				;

var_decl: 		'var' IDF ':' type;

type: 			'int' | 'string';

 //#### Not working because 'return' symbol cannot be used in java ....
return_decl: 	'return(' expression ')';


instruction: 	IDF ':=' expression 
				| 'for' IDF 'in' expression '..' expression 'do' instruction+ 'end'
	      		| print;

expression: 	IDF expressionbis | INT expressionbis;

expressionbis: 	OPER expression  | INT | IDF | ;	

print:			'write' expression;



/**----------------------
	Terminal symbols
------------------------*/


CLASS: 	('A'..'Z')('a'..'z'|'A'..'Z')*;

IDF: 	('a'..'z')('a'..'z'|'A'..'Z')*;

INT:	'0'..'9'+;

OPER: 	'+'|'-'|'*'|'<'|'<='|'>'|'>='|'=='|'!=';

WS: 	(' '|'\t'|'\n')+{$channel=HIDDEN;};

NEWLINE: '\r'? '\n';