// File: AST/python/LogicAndNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class LogicAndNode extends AstNode {
    private AstNode left;
    private AstNode right;

    public LogicAndNode(int line) { super("logic_and", line); }

    public void setLeft(AstNode left) { this.left = left; addChild(left); }
    public void setRight(AstNode right) { this.right = right; addChild(right); }

    @Override
    protected String prettyExtra() { return " [op=AND]"; }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
