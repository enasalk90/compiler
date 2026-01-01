// File: AST/python/StringNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class StringNode extends AstNode {
    private final String text;

    public StringNode(int line, String text) {
        super("STRING", line);
        this.text = text;
    }

    @Override
    protected String prettyExtra() { return " [value=" + text + "]"; }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
