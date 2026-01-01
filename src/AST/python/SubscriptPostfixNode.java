// File: AST/python/SubscriptPostfixNode.java
package AST.python;

import AST.core.AstVisitor;

public class SubscriptPostfixNode extends PostfixNode {
    private ExprNode index;

    public SubscriptPostfixNode(int line) { super("postfix_subscript", line); }

    public void setIndex(ExprNode idx) { this.index = idx; addChild(idx); }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }
}
