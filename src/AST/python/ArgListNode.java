// File: AST/python/ArgListNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class ArgListNode extends AstNode {
    public ArgListNode(int line) { super("arg_list", line); }

    public void addArgument(ArgumentNode a) { addChild(a); }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
