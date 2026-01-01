package AST.Template;

import AST.core.*;
import java.util.*;

public class HtmlDocumentNode extends AstNode {
    private DoctypeNode doctype;                 // optional
    private List<NodeNode> nodes = new ArrayList<>();

    public HtmlDocumentNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public DoctypeNode getDoctype() { return doctype; }
    public void setDoctype(DoctypeNode doctype) { this.doctype = doctype; }

    public List<NodeNode> getNodes() { return nodes; }
    public void setNodes(List<NodeNode> nodes) { this.nodes = nodes; }

    @Override public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.openScope("HtmlDocumentNode{name=" + getNodeName() + ", line=" + getLineNumber() + "}");
        if (doctype != null) sb.openScope("doctype").append(doctype).closeScope("end doctype");
        sb.openScope("nodes");
        for (NodeNode n : nodes) sb.append(n);
        sb.closeScope("end nodes");
        sb.closeScope("}");
        return sb.toString();
    }
}
