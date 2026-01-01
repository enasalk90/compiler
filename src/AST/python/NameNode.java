// File: AST/python/NameNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class NameNode extends AstNode {
    private final String name;

    public NameNode(int line, String name) {
        super("NAME", line);
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    protected String prettyExtra() { return " [name=" + name + "]"; }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
