// File: AST/python/FactorNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class FactorNode extends AstNode {
    private PrimaryNode primary;

    public FactorNode(int line) { super("factor", line); }

    public void setPrimary(PrimaryNode primary) { this.primary = primary; addChild(primary); }

    public void addPostfix(PostfixNode p) { addChild(p); }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
