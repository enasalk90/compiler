// File: AST/python/PrimaryNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class PrimaryNode extends AstNode {
    private AstNode value; // NameNode/NumberNode/.../ListExprNode/...

    public PrimaryNode(int line) { super("primary", line); }

    public void setValue(AstNode value) { this.value = value; addChild(value); }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
