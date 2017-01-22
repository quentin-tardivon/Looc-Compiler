grammar Looc;

@header {
  import java.util.HashMap;
}

@members {
  HashMap<String, Integer> memory = new HashMap<String, Integer>();
}

program: var_decl* ;



var_decl: 'var' IDF ':' type;

type: 'int' |
      'string';

IDF : ('a'..'z')('a'..'z'|'A'..'Z')* ;


WS : (' '|'\t'|'\n')+{$channel=HIDDEN;} ;
