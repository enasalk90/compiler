// File: AST/python/ComparisonNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class ComparisonNode extends AstNode {
    private AstNode left;
    private AstNode right;     // optional
    private String op;         // "==" or "is" or null

    public ComparisonNode(int line) { super("comparison", line); }

    public void setLeft(AstNode left) { this.left = left; addChild(left); }
    public void setRight(AstNode right) { this.right = right; addChild(right); }
    public void setOp(String op) { this.op = op; }

    @Override
    protected String prettyExtra() { return " [op=" + op + "]"; }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
