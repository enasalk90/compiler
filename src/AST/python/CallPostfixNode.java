// File: AST/python/CallPostfixNode.java
package AST.python;

import AST.core.AstVisitor;

public class CallPostfixNode extends PostfixNode {
    private ArgListNode args; // optional

    public CallPostfixNode(int line) { super("postfix_call", line); }

    public void setArgs(ArgListNode args) { this.args = args; addChild(args); }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }
}
