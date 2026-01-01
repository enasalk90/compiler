// File: AST/python/DecoratorNode.java
package AST.python;

import AST.core.AstVisitor;

public class DecoratorNode extends StatementNode {
    private ExprNode expr;

    public DecoratorNode(int line) { super("decorator", line); }

    public ExprNode getExpr() { return expr; }
    public void setExpr(ExprNode expr) {
        this.expr = expr;
        addChild(expr);
    }

    @Override
    public <R> R accept(AST.core.AstVisitor<R> visitor) { return visitor.visit(this); }
}
