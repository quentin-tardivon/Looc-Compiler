grammar Looc;

options {
	k=1;
	output=AST;
}

tokens{
	CLASS_DEC;
	ROOT;
	BLOCK;
	BODY;
	METHOD;
	FOR;
	IF;
	EGAL;
	DO;
	PLUS;
	DIFF;
	THEN;
	ELSE;
	}




/**----------------------
	Nonterminal symbols
------------------------*/


program: 			class_decl* var_decl* instruction+ -> ^(ROOT class_decl* var_decl* instruction+) ;

class_decl:			'class' CLASS ('inherit' CLASS)?  '=' '('class_item_decl')' -> ^(CLASS_DEC CLASS ('inherit' CLASS)? class_item_decl);



class_item_decl:	var_decl* method_decl* -> ^(BLOCK var_decl* method_decl*);


method_decl: 		'method' IDF '(' method_args? ')' function_decl -> ^(METHOD IDF method_args? function_decl);

function_decl: 		':' type'{'var_decl* instruction+'}' -> type ^(BODY var_decl* instruction+)
					|'{'var_decl* instruction+ '}' -> ^(BODY var_decl* instruction+);


method_args: 	IDF':'type (','IDF':'type)*;


var_decl: 	'var' IDF ':' type ';' -> ^('var' IDF type);


type: 				'int' -> 'int'
					|'string' -> 'string'
					| CLASS -> CLASS;


instruction: 		IDF ':=' expression ';' -> ^(':=' IDF  expression)
				| 'for' IDF 'in' expression '..' expression 'do' instruction+ 'end' -> ^(FOR IDF expression expression ^(BODY instruction+))
				| 'if' expression 'then' a=instruction* ('else' (b=instruction)+)? 'fi' -> ^(IF expression ^(THEN $a) (^(ELSE $b+))?) //problem here
				| print
	      			|'do' expression ';' -> ^(DO expression)
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
	: '//' (.*) '\n' { $channel=HIDDEN; };
