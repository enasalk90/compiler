package AST.Template;

import AST.core.*;
import java.util.*;

public class StartTagNode extends AstNode {
    private String tagName;
    private List<AttributeNode> attributes = new ArrayList<>();

    public StartTagNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public String getTagName() { return tagName; }
    public void setTagName(String tagName) { this.tagName = tagName; }

    public List<AttributeNode> getAttributes() { return attributes; }
    public void setAttributes(List<AttributeNode> attributes) { this.attributes = attributes; }

    @Override public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.openScope("StartTagNode{name=" + getNodeName() + ", line=" + getLineNumber() + ", tag=" + tagName + "}");
        sb.openScope("attributes");
        for (AttributeNode a : attributes) sb.append(a);
        sb.closeScope("end attributes");
        sb.closeScope("}");
        return sb.toString();
    }
}
