grammar Looc;

options {
	k=1;
	output=AST;
}
tokens{
	CLASS_DEC;
	VAR_DEC;
	ROOT;
	FORMAL_PARAM;
	FORMAL_PARAMS;
	EFFECTIVE_PARAMS;
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
	PRINT;
	AFFECT;
	MUL;
	DIV;
	NEG;
	RETURN;
	WRITE;
	READ;
	ACCESS;
	THIS;
	CALL;
	SUPER;
	BLOCK;
	VARS;
	METHODS;
	ATTRIBUTES;
	ATTR_DEC;
}


@lexer::header {
package core;
}

@parser::header {
package core;
}


/**----------------------
	Nonterminal symbols
------------------------*/


program: 			class_decl* var_decl* instruction+ -> ^(ROOT class_decl* var_decl* instruction+) ;

class_decl:			'class' CLASS ('inherit' CLASS)?  '=' '('class_item_decl')' -> ^(CLASS_DEC CLASS (CLASS)? class_item_decl);



class_item_decl:	attr_decl* method_decl* -> ^(ATTRIBUTES attr_decl*)? ^(METHODS method_decl*)?;


method_decl: 		'method' IDF '(' method_args? ')' function_decl -> ^(METHOD IDF method_args? function_decl);

function_decl: 		':' type'{'var_decl* instruction+'}' -> type ^(BODY var_decl* instruction+)
					|'{'var_decl* instruction+ '}' -> ^(BODY var_decl* instruction+);


// define the list of parameters for a function
method_args: 	method_arg (',' method_arg)* -> ^(FORMAL_PARAMS method_arg (method_arg)*);
// Define an formal paramater
method_arg: IDF ':' type -> ^(FORMAL_PARAM IDF type);

var_decl: 	'var' IDF ':' type ';' -> ^(VAR_DEC IDF type);
attr_decl: 	'var' IDF ':' type ';' -> ^(ATTR_DEC IDF type);


type: 		'int' -> 'int'
					|'string' -> 'string'
					| CLASS -> CLASS;


instruction: 	IDF ':=' expression ';' -> ^(AFFECT IDF  expression)
			| 'for' IDF 'in' expression '..' expression 'do' instruction+ 'end' -> ^(FOR IDF expression expression ^(BODY instruction+))
			| 'if' expression 'then' a+=instruction+ ('else' b+=instruction+)? 'fi' -> ^(IF expression ^(THEN $a+) (^(ELSE $b+))?) //problem here
			| print
	      		|'do' expression ';' -> ^(DO expression)
	      		| '{' var_decl* instruction+ '}' -> ^(BLOCK var_decl* instruction+)
	   		|return_decl ';' -> ^(RETURN return_decl)
	     		|read';' -> ^(READ read);

expression : 	 operation
		| 'new' CLASS -> ^('new' CLASS);//|'this' expressionbis |'super' expressionbis;


operation : (multiop -> multiop) ('+' mult=multiop -> ^(PLUS $operation $mult)
		|'-' mult=multiop -> ^(DIFF $operation $mult))*;

multiop : (comparaison -> comparaison) ('*' cmp=comparaison -> ^(MUL $multiop $cmp)
		|'/' cmp=comparaison -> ^(DIV $multiop $cmp))*;

comparaison
	: moinsunaire (OPER^ moinsunaire)?;

moinsunaire
	: ('-'^)? atom;

atom: INT
	| STRING
	| IDF^ (call^)?
	| 'this'^ (call^)?
	| 'super'^ (call^)?
	| '(' expression ')' -> expression;


call	: '.' IDF '('(expression(','expression)*)?')' -> ^(CALL IDF (^(EFFECTIVE_PARAMS (expression(expression)*)?))?);

print:		'write' expression ';' -> ^(WRITE expression);

return_decl: 	'return''(' expression ')' -> expression ;

read	:	'read' IDF -> IDF;



/**----------------------
	Terminal symbols
------------------------*/


IDF: 	('a'..'z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

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