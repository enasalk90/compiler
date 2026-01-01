// File: AST/python/TupleExprNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class TupleExprNode extends AstNode {
    public TupleExprNode(int line) { super("tuple_expr", line); }

    public void addElement(ExprNode e) { addChild(e); }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
