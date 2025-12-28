lexer grammar lexerpython;

// ---- Jinja delimiters ----
JINJA_STMT_OPEN  : '{%';
JINJA_STMT_CLOSE : '%}';
JINJA_EXPR_OPEN  : '{{';
JINJA_EXPR_CLOSE : '}}';

// ---- Jinja keywords ----
EXTENDS   : 'extends';
BLOCK     : 'block';
ENDBLOCK  : 'endblock';
FOR       : 'for';
ENDFOR    : 'endfor';
IF        : 'if';
ENDIF     : 'endif';

// ---- Python keywords ----
FROM      : 'from';
IMPORT    : 'import';
DEF       : 'def';
RETURN    : 'return';
ELSE      : 'else';
OR        : 'or';
AND       : 'and';
NOT       : 'not';
IN        : 'in';
IS        : 'is';
NONE      : 'None';
TRUE      : 'True';
FALSE     : 'False';

// ---- Operators / punctuation ----
AT        : '@';
ASSIGN    : '=';
EQEQ      : '==';
NOTEQ     : '!=';
LTE       : '<=';
GTE       : '>=';
LT        : '<';
GT        : '>';
PLUS      : '+';
MINUS     : '-';
STAR      : '*';
SLASH     : '/';
PERCENT   : '%';
LPAREN    : '(';
RPAREN    : ')';
LBRACK    : '[';
RBRACK    : ']';
LBRACE    : '{';
RBRACE    : '}';
COLON     : ':';
COMMA     : ',';
DOT       : '.';
SEMI      : ';';

// ---- Identifiers & literals ----
NAME
  : [a-zA-Z_] [a-zA-Z0-9_]*
  ;

NUMBER
  : [0-9]+ ('.' [0-9]+)?
  ;

STRING
  : '"' ( '\\' . | ~["\\] )* '"'
  | '\'' ( '\\' . | ~['\\] )* '\''
  ;

// ---- Template raw text (outside {{ }} and {% %}) ----
TEMPLATE_TEXT
  : ( ~[{] | '{' ~[{%] )+
  ;

// ---- Newlines / spaces / comments ----
NEWLINE
  : ('\r'? '\n')+
  ;

WS
  : [ \t]+ -> channel(HIDDEN)
  ;

COMMENT
  : '#' ~[\r\n]* -> skip
  ;

// =====================
// INDENT/DEDENT placeholders
// =====================
// ملاحظة: لعمل Python indentation فعلي يلزم منطق إضافي (stack/denter).
INDENT : '<INDENT>';
DEDENT : '<DEDENT>';