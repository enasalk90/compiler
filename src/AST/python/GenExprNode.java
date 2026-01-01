// File: AST/python/GenExprNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class GenExprNode extends AstNode {
    private GenForExprNode genFor;

    public GenExprNode(int line) { super("gen_expr", line); }

    public void setGenFor(GenForExprNode genFor) { this.genFor = genFor; addChild(genFor); }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
