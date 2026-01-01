// TemplateParser.g4
parser grammar TemplateParser;

options { tokenVocab=TemplateLexer; visitor= true;}

htmlDocument
  : doctype? node* EOF
  ;

doctype
  : DOCTYPE
  ;

node
  : styleElement
  | element
  | jinjaStmt
  | jinjaExpr
  | text
  ;

styleElement
  : STYLE_OPEN cssStylesheet STYLE_CLOSE
  ;

element
  : voidElement
  | emptyElement
  | normalElement
  ;

normalElement
  : startTag node* endTag
  ;

startTag
  : LT NAME attribute* GT
  ;

endTag
  : LT SLASH NAME GT
  ;

// self-closing: <tag ... />
emptyElement
  : LT NAME attribute* SLASH GT
  ;

// void elements: <meta ...> <img ...> <input ...>
voidElement
  : LT NAME attribute* GT
  ;

attribute
  : NAME (EQ attrValue)?
  ;

attrValue
  : ATTR_STRING
  | jinjaExpr
  | NAME
  ;

jinjaStmt
  : JINJA_STMT
  ;

jinjaExpr
  : JINJA_EXPR
  ;

text
  : HTML_TEXT
  ;

// ============ CSS ============
cssStylesheet
  : cssRule*
  ;

cssRule
  : selectorList LBRACE cssDecl* RBRACE
  ;

selectorList
  : selectorGroup (COMMA selectorGroup)*
  ;

selectorGroup
  : selectorAtom+
  ;

selectorAtom
  : CSS_IDENT
  | DOT CSS_IDENT
  | HASH CSS_IDENT
  | STAR
  ;

cssDecl
  : CSS_IDENT COLON cssValue SEMI?
  ;

cssValue
  : cssValuePart+
  ;

cssValuePart
  : CSS_IDENT
  | CSS_NUMBER
  | CSS_DIMENSION
  | CSS_PERCENT
  | CSS_HASHCOLOR
  | CSS_STRING
  | DOT
  | SLASH
  | COMMA
  ;