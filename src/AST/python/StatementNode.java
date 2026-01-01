// File: AST/python/StatementNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public abstract class StatementNode extends AstNode {
    protected StatementNode(String nodeName, int line) { super(nodeName, line); }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
