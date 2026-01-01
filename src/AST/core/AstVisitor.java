package AST.core;

public interface AstVisitor<R> {


    // Default fallback
    default R visitDefault(AstNode n) { return null; }

    R visit(AST.Template.HtmlDocumentNode n);
    R visit(AST.Template.DoctypeNode n);
    R visit(AST.Template.NodeNode n);
    R visit(AST.Template.StyleElementNode n);
    R visit(AST.Template.ElementNode n);
    R visit(AST.Template.NormalElementNode n);
    R visit(AST.Template.StartTagNode n);
    R visit(AST.Template.EndTagNode n);
    R visit(AST.Template.EmptyElementNode n);
    R visit(AST.Template.VoidElementNode n);
    R visit(AST.Template.AttributeNode n);
    R visit(AST.Template.AttrValueNode n);
    R visit(AST.Template.JinjaStmtNode n);
    R visit(AST.Template.JinjaExprNode n);
    R visit(AST.Template.TextNode n);
    R visit(AST.Template.CssStylesheetNode n);
    R visit(AST.Template.CssRuleNode n);
    R visit(AST.Template.SelectorListNode n);
    R visit(AST.Template.SelectorGroupNode n);
    R visit(AST.Template.SelectorAtomNode n);
    R visit(AST.Template.CssDeclNode n);
    R visit(AST.Template.CssValueNode n);
    R visit(AST.Template.CssValuePartNode n);

    // ===============================
    // Python AST visits
    // ===============================
    default R visit(AST.python.ProgramNode n) { return visitDefault(n); }
    default R visit(AST.python.StatementNode n) { return visitDefault(n); }

    default R visit(AST.python.ImportStmtNode n) { return visitDefault(n); }
    default R visit(AST.python.ImportItemsNode n) { return visitDefault(n); }
    default R visit(AST.python.DecoratorNode n) { return visitDefault(n); }

    default R visit(AST.python.FuncDefNode n) { return visitDefault(n); }
    default R visit(AST.python.ParamListNode n) { return visitDefault(n); }
    default R visit(AST.python.SuiteNode n) { return visitDefault(n); }

    default R visit(AST.python.IfStmtNode n) { return visitDefault(n); }
    default R visit(AST.python.ReturnStmtNode n) { return visitDefault(n); }

    default R visit(AST.python.ExprListNode n) { return visitDefault(n); }
    default R visit(AST.python.AssignStmtNode n) { return visitDefault(n); }
    default R visit(AST.python.ExprStmtNode n) { return visitDefault(n); }

    default R visit(AST.python.ExprNode n) { return visitDefault(n); }
    default R visit(AST.python.ConditionalExprNode n) { return visitDefault(n); }
    default R visit(AST.python.LogicOrNode n) { return visitDefault(n); }
    default R visit(AST.python.LogicAndNode n) { return visitDefault(n); }
    default R visit(AST.python.ComparisonNode n) { return visitDefault(n); }

    default R visit(AST.python.ArithExprNode n) { return visitDefault(n); }
    default R visit(AST.python.TermNode n) { return visitDefault(n); }

    default R visit(AST.python.FactorNode n) { return visitDefault(n); }
    default R visit(AST.python.PostfixNode n) { return visitDefault(n); }
    default R visit(AST.python.CallPostfixNode n) { return visitDefault(n); }
    default R visit(AST.python.SubscriptPostfixNode n) { return visitDefault(n); }
    default R visit(AST.python.AttributePostfixNode n) { return visitDefault(n); }

    default R visit(AST.python.PrimaryNode n) { return visitDefault(n); }
    default R visit(AST.python.NameNode n) { return visitDefault(n); }
    default R visit(AST.python.NumberNode n) { return visitDefault(n); }
    default R visit(AST.python.StringNode n) { return visitDefault(n); }
    default R visit(AST.python.BoolNode n) { return visitDefault(n); }
    default R visit(AST.python.NoneNode n) { return visitDefault(n); }

    default R visit(AST.python.ListExprNode n) { return visitDefault(n); }
    default R visit(AST.python.DictExprNode n) { return visitDefault(n); }
    default R visit(AST.python.TupleExprNode n) { return visitDefault(n); }

    default R visit(AST.python.GenExprNode n) { return visitDefault(n); }
    default R visit(AST.python.GenForExprNode n) { return visitDefault(n); }

    default R visit(AST.python.ArgListNode n) { return visitDefault(n); }
    default R visit(AST.python.ArgumentNode n) { return visitDefault(n); }

    default R visit(AST.python.DictItemNode n) { return visitDefault(n); }

    // ===============================
    // إن كنت تحتاج Template AST (اتركها كما هي لديك)
    // ضع default لها أيضاً لتفادي إلزامية التنفيذ.
    // ===============================
}
