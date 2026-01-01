// File: AST/python/ExprStmtNode.java
package AST.python;

import AST.core.AstVisitor;

public class ExprStmtNode extends StatementNode {
    private ExprNode expr;

    public ExprStmtNode(int line) { super("expr_stmt", line); }

    public void setExpr(ExprNode expr) { this.expr = expr; addChild(expr); }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }
}
