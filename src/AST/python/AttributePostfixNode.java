// File: AST/python/AttributePostfixNode.java
package AST.python;

import AST.core.AstVisitor;

public class AttributePostfixNode extends PostfixNode {
    private String attrName;

    public AttributePostfixNode(int line) { super("postfix_attr", line); }

    public void setAttrName(String attrName) { this.attrName = attrName; }

    @Override
    protected String prettyExtra() { return " [attr=" + attrName + "]"; }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }
}
