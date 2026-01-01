package AST.Template;

import AST.core.*;

public class EndTagNode extends AstNode {
    private String tagName;

    public EndTagNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public String getTagName() { return tagName; }
    public void setTagName(String tagName) { this.tagName = tagName; }

    @Override public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() {
        return "EndTagNode{name=" + getNodeName() + ", line=" + getLineNumber() + ", tag=" + tagName + "}\n";
    }
}
