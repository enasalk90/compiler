// ===============================
// 1) AST Core (OOP + Inheritance + Polymorphism)
// File: ast/AstNode.java
// ===============================
package AST.core;

import java.util.*;

public abstract class AstNode {
    private final String nodeName;     // required
    private final int line;            // required
    private final List<AstNode> children = new ArrayList<>();

    protected AstNode(String nodeName, int line) {
        this.nodeName = Objects.requireNonNull(nodeName);
        this.line = line;
    }

    public final String getNodeName() { return nodeName; }
    public final int getLineNumber() { return line; }
    public final List<AstNode> getChildren() { return Collections.unmodifiableList(children); }

    public final void addChild(AstNode child) {
        if (child != null) children.add(child);
    }

    public final void addChildren(AstNode... nodes) {
        if (nodes == null) return;
        for (AstNode n : nodes) addChild(n);
    }

    // Polymorphism: Visitor double-dispatch
    public abstract <R> R accept(AstVisitor<R> visitor);

    // Pretty print (tree)
    public final String pretty() {
        StringBuilder sb = new StringBuilder();
        prettyInto(sb, "", true);
        return sb.toString();
    }

    protected void prettyInto(StringBuilder sb, String indent, boolean isLast) {
        sb.append(indent)
                .append(isLast ? "└─ " : "├─ ")
                .append(getClass().getSimpleName())
                .append("(").append(nodeName).append(", line=").append(line).append(")")
                .append(prettyExtra())
                .append("\n");

        String nextIndent = indent + (isLast ? "   " : "│  ");
        for (int i = 0; i < children.size(); i++) {
            children.get(i).prettyInto(sb, nextIndent, i == children.size() - 1);
        }
    }

    // Overridable: extra info per node type
    protected String prettyExtra() { return ""; }
}
