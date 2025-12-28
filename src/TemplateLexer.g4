lexer grammar TemplateLexer;

// =====================
// DATA mode (outside tags)
// =====================

DOCTYPE
  : '<!DOCTYPE' .*? '>'
  ;

// style open ينتقل مباشرة إلى CSS
STYLE_OPEN
  : '<style' .*? '>' -> pushMode(CSS)
  ;

// Jinja chunks in HTML text
JINJA_EXPR
  : '{{' .*? '}}'
  ;

JINJA_STMT
  : '{%' .*? '%}'
  ;

// دخول تاغ عادي: نُصدر LT ثم ننتقل إلى TAG mode
LT
  : '<' -> pushMode(TAG)
  ;

// نص خارج التاغات (لا يحتوي < ولا يبدأ Jinja)
HTML_TEXT
  : ( ~[<{] | '{' ~[{%] )+
  ;

WS_DATA
  : [ \t\r\n]+ -> skip
  ;

// =====================
// TAG mode (inside < ... >)
// =====================

mode TAG;

GT
  : '>' -> popMode
  ;

SLASH : '/';
EQ    : '=';

// اسم التاغ/الأتربيوت
NAME
  : [a-zA-Z_:] [a-zA-Z0-9_:\-.]*
  ;

ATTR_STRING
  : '"' ( '\\' . | ~["\\] )* '"'
  | '\'' ( '\\' . | ~['\\] )* '\''
  ;

// مسافات داخل التاغ
WS_TAG
  : [ \t\r\n]+ -> skip
  ;

// =====================
// CSS mode (inside <style> ... </style>)
// =====================

mode CSS;

STYLE_CLOSE
  : '</style>' -> popMode
  ;

LBRACE : '{';
RBRACE : '}';
COLON  : ':';
SEMI   : ';';
COMMA  : ',';
DOT    : '.';
HASH   : '#';
STAR   : '*';

CSS_IDENT
  : [a-zA-Z_-] [a-zA-Z0-9_-]*
  ;

CSS_NUMBER
  : [0-9]+ ('.' [0-9]+)?
  ;

CSS_DIMENSION
  : CSS_NUMBER [a-zA-Z]+
  ;

CSS_PERCENT
  : CSS_NUMBER '%'
  ;

CSS_HASHCOLOR
  : '#' [0-9a-fA-F]{3} ([0-9a-fA-F]{3})?
  ;

CSS_STRING
  : '"' ( '\\' . | ~["\\] )* '"'
  | '\'' ( '\\' . | ~['\\] )* '\''
  ;

WS_CSS
  : [ \t\r\n]+ -> skip
  ;

// أي شيء آخر داخل CSS نتجاهله
CSS_OTHER
  : . -> skip
  ;