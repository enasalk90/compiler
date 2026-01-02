package SymbolTable;

import AST.core.AstNode;
import AST.python.*;

import java.util.List;

public class PythonSymbolVisitor {

    private final SymbolTable sym = new SymbolTable();

    public SymbolTable collect(ProgramNode program) {
        if (program == null) return sym;

        // global scope موجود تلقائياً
        for (StatementNode st : program.getStatements()) {
            visitStatement(st);
        }
        return sym;
    }

    private void visitStatement(StatementNode st) {
        if (st == null) return;

        if (st instanceof ImportStmtNode) {
            visitImport((ImportStmtNode) st);
            return;
        }
        if (st instanceof FuncDefNode) {
            visitFuncDef((FuncDefNode) st);
            return;
        }
        if (st instanceof AssignStmtNode) {
            visitAssign((AssignStmtNode) st);
            return;
        }
        if (st instanceof IfStmtNode) {
            visitIf((IfStmtNode) st);
            return;
        }

        // DecoratorNode, ReturnStmtNode, ExprStmtNode ... عادةً لا تعرّف رموز
        // لكن يمكن لاحقاً إضافة تحليل استعمالات resolve/use
    }

    private void visitImport(ImportStmtNode n) {
        if (n == null) return;
        ImportItemsNode items = n.getItems();
        if (items == null) return;

        boolean isFrom = n.isFromImport();
        String module = n.getFromModule();

        for (String name : items.getNames()) {
            String info = isFrom ? ("from " + module) : "import";
            sym.define(new Row(name, "import", info, n.getLineNumber()));
        }
    }

    private void visitFuncDef(FuncDefNode fn) {
        if (fn == null) return;

        // define function in current scope (global أو suite خارجي)
        sym.define(new Row(fn.getName(), "function", "def", fn.getLineNumber()));

        // enter function scope
        sym.enterScope("function:" + fn.getName());

        // define params
        if (fn.getParams() != null) {
            for (String p : fn.getParams().getParams()) {
                sym.define(new Row(p, "param", "parameter", fn.getLineNumber()));
            }
        }

        // visit body WITHOUT opening a suite scope (body is function scope)
        SuiteNode body = fn.getSuite();
        if (body != null) {
            for (StatementNode st : body.getStatements()) {
                visitStatementInsideFunction(st);
            }
        }

        sym.exitScope();
    }

    private void visitStatementInsideFunction(StatementNode st) {
        if (st == null) return;

        if (st instanceof AssignStmtNode) {
            visitAssign((AssignStmtNode) st);
            return;
        }
        if (st instanceof IfStmtNode) {
            visitIf((IfStmtNode) st);
            return;
        }
        if (st instanceof ImportStmtNode) {
            // نادراً داخل function ولكن مسموح
            visitImport((ImportStmtNode) st);
            return;
        }
        if (st instanceof FuncDefNode) {
            // nested function (valid in python)
            visitFuncDef((FuncDefNode) st);
            return;
        }
    }

    private void visitIf(IfStmtNode ifs) {
        if (ifs == null) return;

        // then suite: open suite scope
        SuiteNode thenSuite = firstSuiteChild(ifs, 0);
        if (thenSuite != null) {
            sym.enterScope("suite@if@line" + thenSuite.getLineNumber());
            for (StatementNode st : thenSuite.getStatements()) visitStatement(st);
            sym.exitScope();
        }

        // else suite: open suite scope
        SuiteNode elseSuite = firstSuiteChild(ifs, 1);
        if (elseSuite != null) {
            sym.enterScope("suite@else@line" + elseSuite.getLineNumber());
            for (StatementNode st : elseSuite.getStatements()) visitStatement(st);
            sym.exitScope();
        }
    }

    // لأن IfStmtNode في نسختك السابقة لا يملك getters للـ suites،
    // نستخرجها من children. ترتيب children عادة: condition, thenSuite, elseSuite
    private SuiteNode firstSuiteChild(IfStmtNode ifs, int index) {
        if (ifs == null) return null;
        List<AstNode> kids = ifs.getChildren();
        int count = 0;
        for (AstNode k : kids) {
            if (k instanceof SuiteNode) {
                if (count == index) return (SuiteNode) k;
                count++;
            }
        }
        return null;
    }

    private void visitAssign(AssignStmtNode a) {
        if (a == null) return;

        // تعريف متغير فقط إذا LHS اسم بسيط
        String lhs = tryExtractSimpleNameFromExpr(firstExprChild(a, 0));
        if (lhs != null) {
            sym.define(new Row(lhs, "variable", "assigned", a.getLineNumber()));
        }
    }

    // استخراج Expr من children (لأن AssignStmtNode قد لا يملك getters)
    private ExprNode firstExprChild(AstNode parent, int index) {
        if (parent == null) return null;
        int count = 0;
        for (AstNode c : parent.getChildren()) {
            if (c instanceof ExprNode) {
                if (count == index) return (ExprNode) c;
                count++;
            }
        }
        return null;
    }

    // نفس الفكرة: استخراج اسم متغير بسيط فقط (NAME بدون postfix)
    private String tryExtractSimpleNameFromExpr(ExprNode expr) {
        if (expr == null) return null;
        AstNode inner = expr.getInner();
        if (inner == null) return null;

        AstNode cur = inner;
        int safety = 0;
        while (cur != null && safety++ < 50) {
            if (cur instanceof NameNode) return ((NameNode) cur).getName();

            // إذا factor فيه postfix => ليس اسم بسيط
            if (cur instanceof FactorNode) {
                if (cur.getChildren().size() > 1) return null;
            }

            if (cur.getChildren().isEmpty()) break;
            cur = cur.getChildren().get(0);
        }
        return null;
    }
}
