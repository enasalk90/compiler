package AST.Template;

import AST.core.*;
import java.util.*;

public class SelectorListNode extends AstNode {
    private List<SelectorGroupNode> groups = new ArrayList<>();

    public SelectorListNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public List<SelectorGroupNode> getGroups() { return groups; }
    public void setGroups(List<SelectorGroupNode> groups) { this.groups = groups; }

    @Override public <R> R accept(AST.core.AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() { return "SelectorListNode{groups=" + groups.size() + ", line=" + getLineNumber() + "}\n"; }
}
