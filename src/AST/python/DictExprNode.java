// File: AST/python/DictExprNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class DictExprNode extends AstNode {
    public DictExprNode(int line) { super("dict_expr", line); }

    public void addItem(DictItemNode item) { addChild(item); }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
