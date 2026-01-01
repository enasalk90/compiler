package AST.Template;

import AST.core.*;

public class CssValuePartNode extends AstNode {
    private String raw; // CSS_IDENT | CSS_NUMBER | CSS_DIMENSION | ...

    public CssValuePartNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public String getRaw() { return raw; }
    public void setRaw(String raw) { this.raw = raw; }

    @Override public <R> R accept(AST.core.AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() { return "CssValuePartNode{raw=" + raw + ", line=" + getLineNumber() + "}\n"; }
}
