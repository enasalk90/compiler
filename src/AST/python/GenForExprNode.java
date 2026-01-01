// File: AST/python/GenForExprNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class GenForExprNode extends AstNode {
    private ExprNode yieldExpr;
    private String varName;
    private ExprNode inExpr;
    private ExprNode ifExpr; // optional

    public GenForExprNode(int line) { super("gen_for_expr", line); }

    public void setYieldExpr(ExprNode e) { this.yieldExpr = e; addChild(e); }
    public void setVarName(String v) { this.varName = v; }
    public void setInExpr(ExprNode e) { this.inExpr = e; addChild(e); }
    public void setIfExpr(ExprNode e) { this.ifExpr = e; addChild(e); }

    @Override
    protected String prettyExtra() { return " [var=" + varName + "]"; }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
