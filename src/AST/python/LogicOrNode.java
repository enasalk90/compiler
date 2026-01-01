// File: AST/python/LogicOrNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class LogicOrNode extends AstNode {
    private AstNode left;
    private AstNode right;

    public LogicOrNode(int line) { super("logic_or", line); }

    public void setLeft(AstNode left) { this.left = left; addChild(left); }
    public void setRight(AstNode right) { this.right = right; addChild(right); }

    @Override
    protected String prettyExtra() { return " [op=OR]"; }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
