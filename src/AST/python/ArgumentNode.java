// File: AST/python/ArgumentNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

public class ArgumentNode extends AstNode {
    // argument : gen_for_expr | expr | NAME ASSIGN expr
    public enum Kind { GEN_FOR, EXPR, KWARG }

    private Kind kind;
    private String kwName;   // for KWARG
    private AstNode value;   // GenForExprNode or ExprNode

    public ArgumentNode(int line) { super("argument", line); }

    public void setKind(Kind kind) { this.kind = kind; }
    public void setKwName(String kwName) { this.kwName = kwName; }
    public void setValue(AstNode value) { this.value = value; addChild(value); }

    @Override
    protected String prettyExtra() {
        return " [kind=" + kind + (kwName != null ? ", name=" + kwName : "") + "]";
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
