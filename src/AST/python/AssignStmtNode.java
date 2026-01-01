// File: AST/python/AssignStmtNode.java
package AST.python;

import AST.core.AstVisitor;

public class AssignStmtNode extends StatementNode {
    private ExprNode left;
    private ExprNode right;

    public AssignStmtNode(int line) { super("assign_stmt", line); }

    public void setLeft(ExprNode left) { this.left = left; addChild(left); }
    public void setRight(ExprNode right) { this.right = right; addChild(right); }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }
}
