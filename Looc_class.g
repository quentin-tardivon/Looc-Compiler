grammar LOOC;

@header {
import java.util.HashMap;
}

@members {
HashMap<String,Integer>  memory = new HashMap<String,Integer>();
}

/**
		Grammar
*/

program: 		class_def
				;

class_def: 		'class' CLASS_NAME inheritance '(' ')'
				;

inheritance: 	'inherits' CLASS_NAME
				|
				;

CLASS_NAME: 'A'..'Z'+('a'..'z'|'A'..'Z')* ;

WS  :   (' '|'\t')+ {$channel=HIDDEN;} ;
NEWLINE:'\r'? '\n' ;
