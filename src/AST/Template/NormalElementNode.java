package AST.Template;

import AST.core.*;
import java.util.*;

public class NormalElementNode extends AstNode {
    private StartTagNode startTag;
    private List<NodeNode> children = new ArrayList<>();
    private EndTagNode endTag;

    public NormalElementNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public StartTagNode getStartTag() { return startTag; }
    public void setStartTag(StartTagNode startTag) { this.startTag = startTag; }

//    public List<NodeNode> getChildren() { return children; }
    public void setChildren(List<NodeNode> children) { this.children = children; }

    public EndTagNode getEndTag() { return endTag; }
    public void setEndTag(EndTagNode endTag) { this.endTag = endTag; }

    @Override public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.openScope("NormalElementNode{name=" + getNodeName() + ", line=" + getLineNumber() + "}");
        if (startTag != null) sb.openScope("startTag").append(startTag).closeScope("end startTag");
        sb.openScope("children");
        for (NodeNode n : children) sb.append(n);
        sb.closeScope("end children");
        if (endTag != null) sb.openScope("endTag").append(endTag).closeScope("end endTag");
        sb.closeScope("}");
        return sb.toString();
    }
}
