parser grammar parserpython;

options { tokenVocab=lexerpython; }

// ========= Program =========
program
    : (statement | NEWLINE)* EOF
    ;

// ========= Statements =========
statement
    : import_stmt
    | decorator
    | funcdef
    | if_stmt
    | return_stmt
    | assign_stmt
    | expr_stmt
    ;

// ========= Import =========
import_stmt
    : IMPORT import_items
    | FROM NAME IMPORT import_items
    ;

import_items
    : NAME (COMMA NAME)*
    ;

// ========= Decorator =========
decorator
    : AT expr NEWLINE
    ;

// ========= Function =========
funcdef
    : DEF NAME LPAREN param_list? RPAREN COLON suite
    ;

param_list
    : NAME (COMMA NAME)*
    ;

// ========= Suite (Python-like block) =========
suite
    : NEWLINE statement+
    ;

//suite
//    : NEWLINE INDENT statement+ DEDENT
//    ;


// ========= If =========
if_stmt
    : IF expr COLON suite (ELSE COLON suite)?
    ;

// ========= Return =========
return_stmt
    : RETURN expr_list?
    ;

// ========= Expression list =========
expr_list
    : expr (COMMA expr)*
    ;

// ========= Assignment =========
assign_stmt
    : expr ASSIGN expr
    ;

// ========= Expression statement =========
expr_stmt
    : expr
    ;

// ========= Expressions: conditional -> logic -> comparison -> arithmetic =========
expr
    : conditional_expr
    ;

// conditional (ternary) expression: a if b else c
conditional_expr
    : logic_or (IF logic_or ELSE conditional_expr)?
    ;

// logical operators
logic_or
    : logic_or OR logic_and
    | logic_and
    ;

logic_and
    : logic_and AND comparison
    | comparison
    ;

// comparisons (==, is)
comparison
    : arith_expr ((EQ | IS) arith_expr)?
    ;

// arithmetic
arith_expr
    : arith_expr PLUS term
    | arith_expr MINUS term
    | term
    ;

term
    : term STAR factor
    | term DIV factor
    | term MOD factor
    | factor
    ;

// ========= Factor / Calls / Subscripts / Attributes =========
// primary + postfix* supports chains like a.b().c[x]
factor
    : primary postfix*
    ;

// postfix operators
postfix
    : LPAREN arg_list? RPAREN
    | LBRACK expr RBRACK
    | DOT NAME
    ;

// ========= Primary expressions =========
primary
    : NAME
    | NUMBER
    | STRING
    | TRUE
    | FALSE
    | NONE
    | list_expr
    | dict_expr
    | tuple_expr
    | gen_expr                // parenthesized generator
    | LPAREN expr RPAREN
    ;

// ========= Generator expressions =========
// parenthesized: (x for x in xs if ...)
gen_expr
    : LPAREN gen_for_expr RPAREN
    ;

// unparenthesized generator used as an argument: expr FOR NAME IN expr (IF expr)?
gen_for_expr
    : expr FOR NAME IN expr (IF expr)?
    ;

// ========= Arguments =========
// allow NEWLINEs inside arg lists so multi-line calls parse
arg_list
    : NEWLINE* argument (COMMA NEWLINE* argument)* (COMMA NEWLINE*)?
    ;

argument
    : gen_for_expr       // generator used without parentheses as an argument (e.g. max(p["id"] for p in products))
    | expr
    | NAME ASSIGN expr
    ;

// ========= Tuple =========
tuple_expr
    : LPAREN expr (COMMA expr)+ RPAREN
    ;

// ========= List =========
list_expr
    : LBRACK
        ( NEWLINE*
          expr (COMMA NEWLINE* expr)* (COMMA NEWLINE*)?
        )?
      RBRACK
    ;

// ========= Dict =========
dict_expr
    : LBRACE
        ( NEWLINE*
          dict_item (COMMA NEWLINE* dict_item)* (COMMA NEWLINE*)?
        )?
      RBRACE
    ;

dict_item
    : expr COLON expr
    ;