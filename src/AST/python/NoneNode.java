// File: AST/python/NoneNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class NoneNode extends AstNode {
    public NoneNode(int line) { super("NONE", line); }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
