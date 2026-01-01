package AST.Template;

import AST.core.*;

public class AttributeNode extends AstNode {
    private String name;
    private AttrValueNode value; // optional

    public AttributeNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public AttrValueNode getValue() { return value; }
    public void setValue(AttrValueNode value) { this.value = value; }

    @Override public <R> R accept(AST.core.AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.openScope("AttributeNode{name=" + getNodeName() + ", line=" + getLineNumber() + ", attr=" + name + "}");
        if (value != null) sb.append(value);
        sb.closeScope("}");
        return sb.toString();
    }
}
