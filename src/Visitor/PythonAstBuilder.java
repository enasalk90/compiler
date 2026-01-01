// ===============================
// Python AST Builder Visitor
// File: Visitor/PythonAstBuilder.java
// ===============================
package Visitor;

import AST.core.AstNode;
import AST.python.*;
import Grammer.*;
import org.antlr.v4.runtime.Token;

public class PythonAstBuilder extends parserpythonBaseVisitor<AstNode> {

    private int lineOf(Token t) { return (t == null) ? -1 : t.getLine(); }

    // program : (statement | NEWLINE)* EOF ;
    @Override
    public AstNode visitProgram(parserpython.ProgramContext ctx) {
        ProgramNode p = new ProgramNode(lineOf(ctx.start));
        for (var stCtx : ctx.statement()) {
            StatementNode st = (StatementNode) visit(stCtx);
            p.addStatement(st);
        }
        // تخزين صحيح + طباعة عند التنفيذ:
        System.out.println(p.pretty());
        return p;
    }

    // statement : import_stmt | decorator | funcdef | if_stmt | return_stmt | assign_stmt | expr_stmt ;
    @Override
    public AstNode visitStatement(parserpython.StatementContext ctx) {
        if (ctx.import_stmt() != null) return visit(ctx.import_stmt());
        if (ctx.decorator() != null) return visit(ctx.decorator());
        if (ctx.funcdef() != null) return visit(ctx.funcdef());
        if (ctx.if_stmt() != null) return visit(ctx.if_stmt());
        if (ctx.return_stmt() != null) return visit(ctx.return_stmt());
        if (ctx.assign_stmt() != null) return visit(ctx.assign_stmt());
        if (ctx.expr_stmt() != null) return visit(ctx.expr_stmt());
        return null;
    }

    // import_stmt : IMPORT import_items | FROM NAME IMPORT import_items ;
    @Override
    public AstNode visitImport_stmt(parserpython.Import_stmtContext ctx) {
        ImportStmtNode n = new ImportStmtNode(lineOf(ctx.start));
        if (ctx.FROM() != null) {
            n.setFromImport(true);
            n.setFromModule(ctx.NAME().getText());
        } else {
            n.setFromImport(false);
        }
        n.setItems((ImportItemsNode) visit(ctx.import_items()));
        return n;
    }

    // import_items : NAME (COMMA NAME)* ;
    @Override
    public AstNode visitImport_items(parserpython.Import_itemsContext ctx) {
        ImportItemsNode items = new ImportItemsNode(lineOf(ctx.start));
        for (var t : ctx.NAME()) items.addName(t.getText());
        return items;
    }

    // decorator : AT expr NEWLINE ;
    @Override
    public AstNode visitDecorator(parserpython.DecoratorContext ctx) {
        DecoratorNode d = new DecoratorNode(lineOf(ctx.start));
        d.setExpr((ExprNode) visit(ctx.expr()));
        return d;
    }

    // funcdef : DEF NAME LPAREN param_list? RPAREN COLON suite ;
    @Override
    public AstNode visitFuncdef(parserpython.FuncdefContext ctx) {
        FuncDefNode f = new FuncDefNode(lineOf(ctx.start));
        f.setName(ctx.NAME().getText());
        if (ctx.param_list() != null) f.setParams((ParamListNode) visit(ctx.param_list()));
        f.setSuite((SuiteNode) visit(ctx.suite()));
        return f;
    }

    // param_list : NAME (COMMA NAME)* ;
    @Override
    public AstNode visitParam_list(parserpython.Param_listContext ctx) {
        ParamListNode p = new ParamListNode(lineOf(ctx.start));
        for (var t : ctx.NAME()) p.addParam(t.getText());
        return p;
    }

    // suite : NEWLINE statement+ ;
    @Override
    public AstNode visitSuite(parserpython.SuiteContext ctx) {
        SuiteNode s = new SuiteNode(lineOf(ctx.start));
        for (var st : ctx.statement()) s.addStatement((StatementNode) visit(st));
        return s;
    }

    // if_stmt : IF expr COLON suite (ELSE COLON suite)? ;
    @Override
    public AstNode visitIf_stmt(parserpython.If_stmtContext ctx) {
        IfStmtNode n = new IfStmtNode(lineOf(ctx.start));
        n.setCondition((ExprNode) visit(ctx.expr()));
        n.setThenSuite((SuiteNode) visit(ctx.suite(0)));
        if (ctx.ELSE() != null) n.setElseSuite((SuiteNode) visit(ctx.suite(1)));
        return n;
    }

    // return_stmt : RETURN expr_list? ;
    @Override
    public AstNode visitReturn_stmt(parserpython.Return_stmtContext ctx) {
        ReturnStmtNode n = new ReturnStmtNode(lineOf(ctx.start));
        if (ctx.expr_list() != null) n.setExprList((ExprListNode) visit(ctx.expr_list()));
        return n;
    }

    // expr_list : expr (COMMA expr)* ;
    @Override
    public AstNode visitExpr_list(parserpython.Expr_listContext ctx) {
        ExprListNode list = new ExprListNode(lineOf(ctx.start));
        for (var e : ctx.expr()) list.addExpr((ExprNode) visit(e));
        return list;
    }

    // assign_stmt : expr ASSIGN expr ;
    @Override
    public AstNode visitAssign_stmt(parserpython.Assign_stmtContext ctx) {
        AssignStmtNode a = new AssignStmtNode(lineOf(ctx.start));
        a.setLeft((ExprNode) visit(ctx.expr(0)));
        a.setRight((ExprNode) visit(ctx.expr(1)));
        return a;
    }

    // expr_stmt : expr ;
    @Override
    public AstNode visitExpr_stmt(parserpython.Expr_stmtContext ctx) {
        ExprStmtNode e = new ExprStmtNode(lineOf(ctx.start));
        e.setExpr((ExprNode) visit(ctx.expr()));
        return e;
    }

    // expr : conditional_expr ;
    @Override
    public AstNode visitExpr(parserpython.ExprContext ctx) {
        ExprNode e = new ExprNode(lineOf(ctx.start));
        e.setInner(visit(ctx.conditional_expr()));
        return e;
    }

    // conditional_expr : logic_or (IF logic_or ELSE conditional_expr)? ;
    @Override
    public AstNode visitConditional_expr(parserpython.Conditional_exprContext ctx) {
        ConditionalExprNode n = new ConditionalExprNode(lineOf(ctx.start));
        n.setThenExpr(visit(ctx.logic_or(0)));
        if (ctx.IF() != null) {
            n.setCondition(visit(ctx.logic_or(1)));
            n.setElseExpr(visit(ctx.conditional_expr()));
        }
        return n;
    }

    // logic_or : logic_or OR logic_and | logic_and ;
    @Override
    public AstNode visitLogic_or(parserpython.Logic_orContext ctx) {
        if (ctx.logic_or() == null) {
            return visit(ctx.logic_and());
        }
        LogicOrNode n = new LogicOrNode(lineOf(ctx.start));
        n.setLeft(visit(ctx.logic_or()));
        n.setRight(visit(ctx.logic_and()));
        return n;
    }

    // logic_and : logic_and AND comparison | comparison ;
    @Override
    public AstNode visitLogic_and(parserpython.Logic_andContext ctx) {
        if (ctx.logic_and() == null) {
            return visit(ctx.comparison());
        }
        LogicAndNode n = new LogicAndNode(lineOf(ctx.start));
        n.setLeft(visit(ctx.logic_and()));
        n.setRight(visit(ctx.comparison()));
        return n;
    }

    // comparison : arith_expr ((EQ | IS) arith_expr)? ;
    @Override
    public AstNode visitComparison(parserpython.ComparisonContext ctx) {
        ComparisonNode n = new ComparisonNode(lineOf(ctx.start));
        n.setLeft(visit(ctx.arith_expr(0)));
        if (ctx.arith_expr().size() > 1) {
            n.setRight(visit(ctx.arith_expr(1)));
            n.setOp(ctx.EQ() != null ? "==" : "is");
        } else {
            n.setOp(null);
        }
        return n;
    }

    // arith_expr : arith_expr PLUS term | arith_expr MINUS term | term ;
    @Override
    public AstNode visitArith_expr(parserpython.Arith_exprContext ctx) {
        if (ctx.arith_expr() == null) return visit(ctx.term());

        ArithExprNode n = new ArithExprNode(lineOf(ctx.start));
        n.setLeft(visit(ctx.arith_expr()));
        n.setRight(visit(ctx.term()));
        n.setOp(ctx.PLUS() != null ? "+" : "-");
        return n;
    }

    // term : term STAR factor | term DIV factor | term MOD factor | factor ;
    @Override
    public AstNode visitTerm(parserpython.TermContext ctx) {
        if (ctx.term() == null) return visit(ctx.factor());

        TermNode n = new TermNode(lineOf(ctx.start));
        n.setLeft(visit(ctx.term()));
        n.setRight(visit(ctx.factor()));
        if (ctx.STAR() != null) n.setOp("*");
        else if (ctx.DIV() != null) n.setOp("/");
        else n.setOp("%");
        return n;
    }

    // factor : primary postfix* ;
    @Override
    public AstNode visitFactor(parserpython.FactorContext ctx) {
        FactorNode f = new FactorNode(lineOf(ctx.start));
        f.setPrimary((PrimaryNode) visit(ctx.primary()));
        for (var p : ctx.postfix()) f.addPostfix((PostfixNode) visit(p));
        return f;
    }

    // postfix : LPAREN arg_list? RPAREN | LBRACK expr RBRACK | DOT NAME ;
    @Override
    public AstNode visitPostfix(parserpython.PostfixContext ctx) {
        if (ctx.LPAREN() != null) {
            CallPostfixNode c = new CallPostfixNode(lineOf(ctx.start));
            if (ctx.arg_list() != null) c.setArgs((ArgListNode) visit(ctx.arg_list()));
            return c;
        }
        if (ctx.LBRACK() != null) {
            SubscriptPostfixNode s = new SubscriptPostfixNode(lineOf(ctx.start));
            s.setIndex((ExprNode) visit(ctx.expr()));
            return s;
        }
        AttributePostfixNode a = new AttributePostfixNode(lineOf(ctx.start));
        a.setAttrName(ctx.NAME().getText());
        return a;
    }

    // primary : NAME | NUMBER | STRING | TRUE | FALSE | NONE | list_expr | dict_expr | tuple_expr | gen_expr | LPAREN expr RPAREN ;
    @Override
    public AstNode visitPrimary(parserpython.PrimaryContext ctx) {
        PrimaryNode p = new PrimaryNode(lineOf(ctx.start));

        if (ctx.NAME() != null) p.setValue(new NameNode(lineOf(ctx.start), ctx.NAME().getText()));
        else if (ctx.NUMBER() != null) p.setValue(new NumberNode(lineOf(ctx.start), ctx.NUMBER().getText()));
        else if (ctx.STRING() != null) p.setValue(new StringNode(lineOf(ctx.start), ctx.STRING().getText()));
        else if (ctx.TRUE() != null) p.setValue(new BoolNode(lineOf(ctx.start), true));
        else if (ctx.FALSE() != null) p.setValue(new BoolNode(lineOf(ctx.start), false));
        else if (ctx.NONE() != null) p.setValue(new NoneNode(lineOf(ctx.start)));
        else if (ctx.list_expr() != null) p.setValue(visit(ctx.list_expr()));
        else if (ctx.dict_expr() != null) p.setValue(visit(ctx.dict_expr()));
        else if (ctx.tuple_expr() != null) p.setValue(visit(ctx.tuple_expr()));
        else if (ctx.gen_expr() != null) p.setValue(visit(ctx.gen_expr()));
        else if (ctx.expr() != null) p.setValue(visit(ctx.expr()));

        return p;
    }

    // gen_expr : LPAREN gen_for_expr RPAREN ;
    @Override
    public AstNode visitGen_expr(parserpython.Gen_exprContext ctx) {
        GenExprNode g = new GenExprNode(lineOf(ctx.start));
        g.setGenFor((GenForExprNode) visit(ctx.gen_for_expr()));
        return g;
    }

    // gen_for_expr : expr FOR NAME IN expr (IF expr)? ;
    @Override
    public AstNode visitGen_for_expr(parserpython.Gen_for_exprContext ctx) {
        GenForExprNode g = new GenForExprNode(lineOf(ctx.start));
        g.setYieldExpr((ExprNode) visit(ctx.expr(0)));
        g.setVarName(ctx.NAME().getText());
        g.setInExpr((ExprNode) visit(ctx.expr(1)));
        if (ctx.expr().size() > 2) g.setIfExpr((ExprNode) visit(ctx.expr(2)));
        return g;
    }

    // arg_list : NEWLINE* argument (COMMA NEWLINE* argument)* (COMMA NEWLINE*)? ;
    @Override
    public AstNode visitArg_list(parserpython.Arg_listContext ctx) {
        ArgListNode a = new ArgListNode(lineOf(ctx.start));
        for (var arg : ctx.argument()) a.addArgument((ArgumentNode) visit(arg));
        return a;
    }

    // argument : gen_for_expr | expr | NAME ASSIGN expr ;
    @Override
    public AstNode visitArgument(parserpython.ArgumentContext ctx) {
        ArgumentNode a = new ArgumentNode(lineOf(ctx.start));

        if (ctx.gen_for_expr() != null) {
            a.setKind(ArgumentNode.Kind.GEN_FOR);
            a.setValue(visit(ctx.gen_for_expr()));
        } else if (ctx.ASSIGN() != null) {
            a.setKind(ArgumentNode.Kind.KWARG);
            a.setKwName(ctx.NAME().getText());
            a.setValue(visit(ctx.expr()));
        } else {
            a.setKind(ArgumentNode.Kind.EXPR);
            a.setValue(visit(ctx.expr()));
        }
        return a;
    }

    // tuple_expr : LPAREN expr (COMMA expr)+ RPAREN ;
    @Override
    public AstNode visitTuple_expr(parserpython.Tuple_exprContext ctx) {
        TupleExprNode t = new TupleExprNode(lineOf(ctx.start));
        for (var e : ctx.expr()) t.addElement((ExprNode) visit(e));
        return t;
    }

    // list_expr : LBRACK ( NEWLINE* expr (COMMA NEWLINE* expr)* (COMMA NEWLINE*)? )? RBRACK ;
    @Override
    public AstNode visitList_expr(parserpython.List_exprContext ctx) {
        ListExprNode l = new ListExprNode(lineOf(ctx.start));
        for (var e : ctx.expr()) l.addElement((ExprNode) visit(e));
        return l;
    }

    // dict_expr : LBRACE ( NEWLINE* dict_item (COMMA NEWLINE* dict_item)* (COMMA NEWLINE*)? )? RBRACE ;
    @Override
    public AstNode visitDict_expr(parserpython.Dict_exprContext ctx) {
        DictExprNode d = new DictExprNode(lineOf(ctx.start));
        for (var it : ctx.dict_item()) d.addItem((DictItemNode) visit(it));
        return d;
    }

    // dict_item : expr COLON expr ;
    @Override
    public AstNode visitDict_item(parserpython.Dict_itemContext ctx) {
        DictItemNode it = new DictItemNode(lineOf(ctx.start));
        it.setKey((ExprNode) visit(ctx.expr(0)));
        it.setValue((ExprNode) visit(ctx.expr(1)));
        return it;
    }
}
