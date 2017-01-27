grammar Looc;

options {
	k=1;
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


class_decl:		'class' CLASS ('inherit' CLASS)?  '='  '('class_item_decl')';


class_item_decl :	var_decl* method_decl*;


method_decl : 	'method' IDF '('method_args*')' function_decl;

function_decl : ':' type'{'var_decl* instruction+'}'
		| '{'var_decl* instruction+ '}';


method_args : IDF':'type (','IDF':'type)*;


var_decl: 		'var' IDF ':' type ';';


type: 			'int' | 'string' | CLASS;



instruction: 		IDF ':=' expression ';'
					| 'for' IDF 'in' expression '..' expression 'do' instruction+ 'end'
					| 'if'  expression 'then' instruction ('else' instruction)? 'fi'
	      			| print
	      			|'do' expression';'  //problem here
	      			|return_decl ';';

expression : 	IDF expressionbis //il peut y avoir le vide
					| INT expressionbis
					| STRING // Maybe add expressionbis
					| 'new' CLASS |'this' expressionbis |'super' expressionbis;

expressionbis : 	OPER expression
					| '+' expression
					| '-' expression
					| '/' expression
					| '*' expression
					| '.' IDF '('(expression(','expression)*)?')'
					| ;

print:			'write' expression ';' ;

return_decl: 	'return''(' expression ')';



/**----------------------
	Terminal symbols
------------------------*/


IDF: 	('a'..'z')('a'..'z'|'A'..'Z'|'0'..'9')*;

CLASS:	('A'..'Z')('a'..'z'|'A'..'Z')*;

INT:	'0'..'9'+;

STRING: '"'(.)*'"';

OPER: 	'<'|'<='|'>'|'>='|'=='|'!=';

WS: 	(' '|'\t'|'\n')+{$channel=HIDDEN;};

NEWLINE: '\r'? '\n';

COMMENT
    : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

LINE_COMMENT
		    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
		    ;
