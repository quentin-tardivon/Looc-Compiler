grammar Looc;

@header {
  import java.util.HashMap;
}

@members {
  HashMap<String, Integer> memory = new HashMap<String, Integer>();
}

program: var_decl* instruction+;

var_decl: 'var' IDF ':' type;

type: 'int'
      |'string';

return: 'return('expression')';

instruction : IDF':='expression 
	      |'for' IDF 'in' expression '..' expression 'do' instruction+ 'end'
	      | print;
	      
	          
expression : IDF expressionbis | INT expressionbis;

expressionbis : OPER expression  | INT | IDF | ;	

print	:	'write' expression;

IDF : ('a'..'z')('a'..'z'|'A'..'Z')* ;

INT :   '0'..'9'+ ;

OPER : '+'|'-'|'*'|'<'|'<='|'>'|'>='|'=='|'!=' ;

WS : (' '|'\t'|'\n')+{$channel=HIDDEN;} ;
