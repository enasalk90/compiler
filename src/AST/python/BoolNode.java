// File: AST/python/BoolNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class BoolNode extends AstNode {
    private final boolean value;

    public BoolNode(int line, boolean value) {
        super("BOOL", line);
        this.value = value;
    }

    @Override
    protected String prettyExtra() { return " [value=" + value + "]"; }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
