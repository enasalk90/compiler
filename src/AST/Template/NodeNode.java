package AST.Template;

import AST.core.*;

public class NodeNode extends AstNode {
    private StyleElementNode styleElement;
    private ElementNode element;
    private JinjaStmtNode jinjaStmt;
    private JinjaExprNode jinjaExpr;
    private TextNode text;

    public NodeNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public StyleElementNode getStyleElement() { return styleElement; }
    public void setStyleElement(StyleElementNode styleElement) { this.styleElement = styleElement; }

    public ElementNode getElement() { return element; }
    public void setElement(ElementNode element) { this.element = element; }

    public JinjaStmtNode getJinjaStmt() { return jinjaStmt; }
    public void setJinjaStmt(JinjaStmtNode jinjaStmt) { this.jinjaStmt = jinjaStmt; }

    public JinjaExprNode getJinjaExpr() { return jinjaExpr; }
    public void setJinjaExpr(JinjaExprNode jinjaExpr) { this.jinjaExpr = jinjaExpr; }

    public TextNode getText() { return text; }
    public void setText(TextNode text) { this.text = text; }

    @Override public <R> R accept(AST.core.AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.openScope("NodeNode{name=" + getNodeName() + ", line=" + getLineNumber() + "}");
        if (styleElement != null) sb.append(styleElement);
        else if (element != null) sb.append(element);
        else if (jinjaStmt != null) sb.append(jinjaStmt);
        else if (jinjaExpr != null) sb.append(jinjaExpr);
        else if (text != null) sb.append(text);
        sb.closeScope("}");
        return sb.toString();
    }
}
