package AST.Template;

import AST.core.*;

public class ElementNode extends AstNode {
    private VoidElementNode voidElement;
    private EmptyElementNode emptyElement;
    private NormalElementNode normalElement;

    public ElementNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public VoidElementNode getVoidElement() { return voidElement; }
    public void setVoidElement(VoidElementNode voidElement) { this.voidElement = voidElement; }

    public EmptyElementNode getEmptyElement() { return emptyElement; }
    public void setEmptyElement(EmptyElementNode emptyElement) { this.emptyElement = emptyElement; }

    public NormalElementNode getNormalElement() { return normalElement; }
    public void setNormalElement(NormalElementNode normalElement) { this.normalElement = normalElement; }

    @Override public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.openScope("ElementNode{name=" + getNodeName() + ", line=" + getLineNumber() + "}");
        if (voidElement != null) sb.append(voidElement);
        else if (emptyElement != null) sb.append(emptyElement);
        else if (normalElement != null) sb.append(normalElement);
        sb.closeScope("}");
        return sb.toString();
    }
}
