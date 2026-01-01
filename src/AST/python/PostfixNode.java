// File: AST/python/PostfixNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public abstract class PostfixNode extends AstNode {
    protected PostfixNode(String nodeName, int line) { super(nodeName, line); }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
