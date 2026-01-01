package AST.Template;

import AST.core.*;

public class DoctypeNode extends AstNode {
    private String raw;

    public DoctypeNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public String getRaw() { return raw; }
    public void setRaw(String raw) { this.raw = raw; }

    @Override public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() {
        return "DoctypeNode{name=" + getNodeName() + ", line=" + getLineNumber() + ", raw=" + raw + "}\n";
    }
}
