// File: AST/python/NumberNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class NumberNode extends AstNode {
    private final String text;

    public NumberNode(int line, String text) {
        super("NUMBER", line);
        this.text = text;
    }

    @Override
    protected String prettyExtra() { return " [value=" + text + "]"; }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
