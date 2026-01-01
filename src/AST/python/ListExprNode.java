// File: AST/python/ListExprNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class ListExprNode extends AstNode {
    public ListExprNode(int line) { super("list_expr", line); }

    public void addElement(ExprNode e) { addChild(e); }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
