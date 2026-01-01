// File: AST/python/ExprListNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

import java.util.*;

public class ExprListNode extends AstNode {
    private final List<ExprNode> exprs = new ArrayList<>();

    public ExprListNode(int line) { super("expr_list", line); }

    public List<ExprNode> getExprs() { return exprs; }

    public void addExpr(ExprNode e) {
        if (e != null) {
            exprs.add(e);
            addChild(e);
        }
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
