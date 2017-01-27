grammar Looc;

options {
	k=1;
	backtrack=no;
}

@header {
	import java.util.HashMap;
}

@members {
	HashMap<String, Integer> memory = new HashMap<String, Integer>();
}

/**----------------------
	Nonterminal symbols
------------------------*/


program: 		class_decl* var_decl* instruction+;


class_decl:		'class' CLASS '=' '('class_item_decl')';


class_item_decl :	var_decl* method_decl*;


method_decl : 	'method' IDF '('method_args*')' function_decl;

function_decl : ':' type'{'var_decl* instruction+'}' 
		| '{'var_decl* instruction+ '}';


method_args : IDF':'type (','IDF':'type)*;


var_decl: 		'var' IDF ':' type ';';


type: 			'int' | 'string' | CLASS;



instruction: 	IDF ':=' expression ';'{memory.put($IDF.text, new Integer($expression.value));}
				| 'for' IDF 'in' expression '..' expression 'do' instruction+ 'end'
				| 'if'  expression 'then' instruction ('else' instruction)? 'fi'
	      			| print
	      			|'do' expression'.'IDF'('(expression(','expression)*)?')'';'  //problem here
	      			|return_decl ';';

expression returns [int value]: 	IDF expressionbis
					| INT {$value = Integer.parseInt($INT.text);} expressionbis
					| 'new' CLASS |'this'|'super';

expressionbis returns [int value]: 	OPER expression
					| '+' e=expression {$value += $e.value;}
					| '-' e=expression {$value -= $e.value;}
					| '/' e=expression {$value /= $e.value;}
					| '*' e=expression {$value *= $e.value;}
					|'.'IDF'('expression(','expression)*')'
					| ;

print:			'write' IDF {System.out.println(memory.get($IDF.text));}';' ;

return_decl: 	'return''(' expression ')';



/**----------------------
	Terminal symbols
------------------------*/


IDF: 	('a'..'z')('a'..'z'|'A'..'Z')*;

CLASS:	('A'..'Z')('a'..'z'|'A'..'Z')*;

INT:	'0'..'9'+;

OPER: 	'<'|'<='|'>'|'>='|'=='|'!=';

WS: 	(' '|'\t'|'\n')+{$channel=HIDDEN;};

NEWLINE: '\r'? '\n';
