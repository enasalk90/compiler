// File: AST/python/ReturnStmtNode.java
package AST.python;

import AST.core.AstVisitor;

public class ReturnStmtNode extends StatementNode {
    private ExprListNode exprList; // optional

    public ReturnStmtNode(int line) { super("return_stmt", line); }

    public ExprListNode getExprList() { return exprList; }

    public void setExprList(ExprListNode exprList) {
        this.exprList = exprList;
        addChild(exprList);
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }
}
