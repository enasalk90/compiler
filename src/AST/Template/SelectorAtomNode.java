package AST.Template;

import AST.core.*;

public class SelectorAtomNode extends AstNode {
    private String raw; // CSS_IDENT | .CSS_IDENT | #CSS_IDENT | *

    public SelectorAtomNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public String getRaw() { return raw; }
    public void setRaw(String raw) { this.raw = raw; }

    @Override public <R> R accept(AST.core.AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() { return "SelectorAtomNode{raw=" + raw + ", line=" + getLineNumber() + "}\n"; }
}
