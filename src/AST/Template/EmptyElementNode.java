package AST.Template;

import AST.core.*;
import java.util.*;

public class EmptyElementNode extends AstNode {
    private String tagName;
    private List<AttributeNode> attributes = new ArrayList<>();

    public EmptyElementNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public String getTagName() { return tagName; }
    public void setTagName(String tagName) { this.tagName = tagName; }

    public List<AttributeNode> getAttributes() { return attributes; }
    public void setAttributes(List<AttributeNode> attributes) { this.attributes = attributes; }

    @Override public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() {
        return "EmptyElementNode{name=" + getNodeName() + ", line=" + getLineNumber() + ", tag=" + tagName + "}\n";
    }
}
