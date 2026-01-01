// File: AST/python/ArithExprNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class ArithExprNode extends AstNode {
    private AstNode left;
    private AstNode right;
    private String op; // "+" or "-" or null (إذا كانت مجرد term)

    public ArithExprNode(int line) { super("arith_expr", line); }

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
