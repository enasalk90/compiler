package AST.Template;

import AST.core.*;

public class CssDeclNode extends AstNode {
    private String property;
    private CssValueNode value;

    public CssDeclNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public String getProperty() { return property; }
    public void setProperty(String property) { this.property = property; }

    public CssValueNode getValue() { return value; }
    public void setValue(CssValueNode value) { this.value = value; }

    @Override public <R> R accept(AST.core.AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() {
        return "CssDeclNode{prop=" + property + ", line=" + getLineNumber() + "}\n";
    }
}
