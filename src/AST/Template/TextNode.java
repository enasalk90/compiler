package AST.Template;

import AST.core.*;

public class TextNode extends AstNode {
    private String text;

    public TextNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    @Override public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() {
        return "TextNode{name=" + getNodeName() + ", line=" + getLineNumber() + ", text=" + text + "}\n";
    }
}
