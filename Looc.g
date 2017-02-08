grammar Looc;

options {
	k=1;
	output=AST;
}

tokens {
 PLUS;
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


program:  class_decl* var_decl* instruction+;


class_decl: 'class' CLASS ('inherit' CLASS)?  '='  '('class_item_decl')';


class_item_decl: var_decl* method_decl*;


method_decl: 	'method' IDF '(' method_args? ')' function_decl;

function_decl: 	':' type'{'var_decl* instruction+'}'
		|'{'var_decl* instruction+ '}';


method_args: 	IDF':'type (','IDF':'type)*;


var_decl: 	'var' IDF ':' type ';' -> ^('var' IDF type);


type: 		'int' -> 'int'
		|'string' -> 'int'
		| CLASS -> CLASS;


instruction: 	IDF ':=' expression ';' -> ^(':=' IDF  expression)
		| 'for' IDF 'in' expression '..' expression 'do' instruction+ 'end' -> ^('for' IDF expression expression ^('do' instruction+))
		| 'if' expression 'then' instruction* ('else' instruction*)? 'fi'
		| print
	      	|'do' expression';'  //problem here
	      	|return_decl ';'
	      	|read';';

expression : 	 operation
		| 'new' CLASS ;//|'this' expressionbis |'super' expressionbis;


operation : multiop (('+'^|'-'^) multiop)*;	   	

multiop : comparaison (('*'^|'/'^) comparaison )*;

comparaison
	: moinsunaire (OPER^ moinsunaire)?;

moinsunaire
	: ('-')? atom;

atom: INT
	| STRING
	| IDF ('.' IDF '('(expression(','expression)*)?')')?
	| 'this' ('.' IDF '('(expression(','expression)*)?')')? //intégration des possibilités de expressionbis ?
	| 'super' ('.' IDF '('(expression(','expression)*)?')')? //
	| '(' expression ')' -> expression;

print:		'write' expression ';'
		;

return_decl: 	'return''(' expression ')';

read	:	'read' IDF;



/**----------------------
	Terminal symbols
------------------------*/


IDF: 	('a'..'z')('a'..'z'|'A'..'Z'|'0'..'9')*;

CLASS:	('A'..'Z')('a'..'z'|'A'..'Z')*;

INT:	'0'..'9'+;

STRING: '"'(.)*'"';

OPER: 	'<'|'<='|'>'|'>='|'=='|'!=';

WS: 	(' '|'\t'|'\n')+ {$channel=HIDDEN;};

NEWLINE: '\r'? '\n';

COMMENT
	: '/*' (.*) '*/' { $channel=HIDDEN; } ;

LINE_COMMENT
	: '//' (.*) '\n' { $channel=HIDDEN; } ;