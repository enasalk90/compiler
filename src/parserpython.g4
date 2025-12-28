parser grammar parserpython;

options { tokenVocab=lexerpython; }

// =====================
// Entry points
// =====================

file
  : templateFile EOF
  | pythonFile EOF
  ;

// =====================
// Jinja2 Template Parser
// =====================

templateFile
  : templateItem*
  ;

templateItem
  : jinjaStmt
  | jinjaExpr
  | TEMPLATE_TEXT
  ;

jinjaStmt
  : JINJA_STMT_OPEN stmtBody JINJA_STMT_CLOSE
  ;

stmtBody
  : jinjaExtends
  | jinjaBlock
  | jinjaEndBlock
  | jinjaFor
  | jinjaEndFor
  | jinjaIf
  | jinjaEndIf
  | pythonSmallStmtList?
  ;

jinjaExtends
  : EXTENDS STRING
  ;

jinjaBlock
  : BLOCK NAME
  ;

jinjaEndBlock
  : ENDBLOCK
  ;

jinjaFor
  : FOR NAME IN pyExpr
  ;

jinjaEndFor
  : ENDFOR
  ;

jinjaIf
  : IF pyExpr
  ;

jinjaEndIf
  : ENDIF
  ;

jinjaExpr
  : JINJA_EXPR_OPEN pyExpr JINJA_EXPR_CLOSE
  ;

// =====================
// Python Parser (subset)
// =====================

pythonFile
  : pyStmt*
  ;

pyStmt
  : pySimpleStmt
  | pyCompoundStmt
  ;

pySimpleStmt
  : pythonSmallStmtList NEWLINE
  | NEWLINE
  ;

pythonSmallStmtList
  : pySmallStmt (SEMI pySmallStmt)* SEMI?
  ;

pySmallStmt
  : pyImportFrom
  | pyAssign
  | pyReturn
  | pyExprStmt
  ;

pyImportFrom
  : FROM dottedName IMPORT importTargets
  ;

dottedName
  : NAME (DOT NAME)*
  ;

importTargets
  : NAME (COMMA NAME)*
  ;

pyAssign
  : (pyTarget ASSIGN)+ pyExpr
  ;

pyTarget
  : NAME
  | pyAtom trailer+
  ;

pyReturn
  : RETURN pyExpr?
  ;

pyExprStmt
  : pyExpr
  ;

pyCompoundStmt
  : pyDecorator* pyFuncDef
  | pyIfStmt
  ;

pyDecorator
  : AT pyAtom trailer* NEWLINE
  ;

pyFuncDef
  : DEF NAME LPAREN pyParamList? RPAREN COLON NEWLINE INDENT pyStmt* DEDENT
  ;

pyParamList
  : NAME (COMMA NAME)* COMMA?
  ;

pyIfStmt
  : IF pyExpr COLON NEWLINE INDENT pyStmt* DEDENT (ELSE COLON NEWLINE INDENT pyStmt* DEDENT)?
  ;

// ---------------------
// Expressions (subset)
// ---------------------

pyExpr
  : pyOrExpr
  ;

pyOrExpr
  : pyAndExpr (OR pyAndExpr)*
  ;

pyAndExpr
  : pyNotExpr (AND pyNotExpr)*
  ;

pyNotExpr
  : NOT pyNotExpr
  | pyCmpExpr
  ;

pyCmpExpr
  : pyArithExpr (cmpOp pyArithExpr)*
  ;

cmpOp
  : EQEQ | NOTEQ | LT | GT | LTE | GTE | IN | IS
  ;

pyArithExpr
  : pyTerm ((PLUS | MINUS) pyTerm)*
  ;

pyTerm
  : pyFactor ((STAR | SLASH | PERCENT) pyFactor)*
  ;

pyFactor
  : (PLUS | MINUS) pyFactor
  | pyPower
  ;

pyPower
  : pyAtom trailer*
  ;

trailer
  : LPAREN pyArgList? RPAREN
  | LBRACK pySubscript RBRACK
  | DOT NAME
  ;

pySubscript
  : pyExpr
  ;

pyArgList
  : pyArgument (COMMA pyArgument)* COMMA?
  ;

pyArgument
  : NAME ASSIGN pyExpr
  | pyExpr
  ;

pyAtom
  : NAME
  | NONE
  | TRUE
  | FALSE
  | NUMBER
  | STRING
  | pyList
  | pyDict
  | LPAREN pyParenInner? RPAREN
  ;

pyParenInner
  : pyExpr
  | pyGenExpr
  ;

pyGenExpr
  : pyExpr FOR NAME IN pyExpr (IF pyExpr)?
  ;

pyList
  : LBRACK (pyExpr (COMMA pyExpr)*)? COMMA? RBRACK
  ;

pyDict
  : LBRACE (pyKvPair (COMMA pyKvPair)*)? COMMA? RBRACE
  ;

pyKvPair
  : pyExpr COLON pyExpr
  ;