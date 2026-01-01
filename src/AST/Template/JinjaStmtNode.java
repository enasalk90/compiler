package AST.Template;

import AST.core.*;

public class JinjaStmtNode extends AstNode {
    private String raw;

    public JinjaStmtNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public String getRaw() { return raw; }
    public void setRaw(String raw) { this.raw = raw; }

    @Override public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() {
        return "JinjaStmtNode{name=" + getNodeName() + ", line=" + getLineNumber() + ", raw=" + raw + "}\n";
    }
}
