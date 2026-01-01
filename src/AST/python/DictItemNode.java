// File: AST/python/DictItemNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class DictItemNode extends AstNode {
    private ExprNode key;
    private ExprNode value;

    public DictItemNode(int line) { super("dict_item", line); }

    public void setKey(ExprNode key) { this.key = key; addChild(key); }
    public void setValue(ExprNode value) { this.value = value; addChild(value); }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
