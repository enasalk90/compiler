// File: AST/python/ConditionalExprNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class ConditionalExprNode extends AstNode {
    // logic_or (IF logic_or ELSE conditional_expr)?
    private AstNode condition;  // logic_or (بعد IF)
    private AstNode thenExpr;   // logic_or (قبل IF)
    private AstNode elseExpr;   // conditional_expr (بعد ELSE) optional

    public ConditionalExprNode(int line) { super("conditional_expr", line); }

    public void setThenExpr(AstNode thenExpr) { this.thenExpr = thenExpr; addChild(thenExpr); }
    public void setCondition(AstNode condition) { this.condition = condition; addChild(condition); }
    public void setElseExpr(AstNode elseExpr) { this.elseExpr = elseExpr; addChild(elseExpr); }

    @Override
    protected String prettyExtra() { return (elseExpr != null ? " [ternary=true]" : " [ternary=false]"); }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
