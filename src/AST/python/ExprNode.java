// File: AST/python/ExprNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class ExprNode extends AstNode {
    private AstNode inner; // عادة ConditionalExprNode

    public ExprNode(int line) { super("expr", line); }

    public AstNode getInner() { return inner; }
    public void setInner(AstNode inner) {
        this.inner = inner;
        addChild(inner);
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
