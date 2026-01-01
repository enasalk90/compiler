lexer grammar lexerpython;

// ========= Whitespace & Comments =========
NEWLINE : '\r'? '\n' ;
WS      : [ \t]+ -> skip ;
COMMENT : '#' ~[\r\n]* -> skip ;

// ========= Keywords =========
IMPORT  : 'import' ;
FROM    : 'from' ;
AS      : 'as' ;
DEF     : 'def' ;
RETURN  : 'return' ;
IF      : 'if' ;
ELSE    : 'else' ;
FOR     : 'for' ;
IN      : 'in' ;
IS      : 'is' ;
AND     : 'and' ;
OR      : 'or' ;
NOT     : 'not' ;
TRUE    : 'True' ;
FALSE   : 'False' ;
NONE    : 'None' ;

// ========= Decorators / other =========
AT      : '@' ;

// ========= Operators (longer before shorter) =========
EQ      : '==' ;
ASSIGN  : '=' ;
PLUS    : '+' ;
MINUS   : '-' ;
STAR    : '*' ;
DIV     : '/' ;
MOD     : '%' ;

// ========= Symbols =========
LPAREN  : '(' ;
RPAREN  : ')' ;
LBRACK  : '[' ;
RBRACK  : ']' ;
LBRACE  : '{' ;
RBRACE  : '}' ;
COMMA   : ',' ;
COLON   : ':' ;
DOT     : '.' ;

// ========= Literals =========
NUMBER  : [0-9]+ ('.' [0-9]+)? ;
STRING
    : '"' (~["\r\n])* '"'
    | '\'' (~['\r\n])* '\''
    ;

// ========= Identifiers =========
NAME : [a-zA-Z_][a-zA-Z0-9_]* ;
