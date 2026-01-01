package AST.Template;

import AST.core.*;

public class AttrValueNode extends AstNode {
    private String attrString;
    private JinjaExprNode jinjaExpr;
    private String nameToken;

    public AttrValueNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public String getAttrString() { return attrString; }
    public void setAttrString(String attrString) { this.attrString = attrString; }

    public JinjaExprNode getJinjaExpr() { return jinjaExpr; }
    public void setJinjaExpr(JinjaExprNode jinjaExpr) { this.jinjaExpr = jinjaExpr; }

    public String getNameToken() { return nameToken; }
    public void setNameToken(String nameToken) { this.nameToken = nameToken; }

    @Override public <R> R accept(AST.core.AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() {
        return "AttrValueNode{name=" + getNodeName() + ", line=" + getLineNumber() +
                ", str=" + attrString + ", jinja=" + (jinjaExpr != null) + ", name=" + nameToken + "}\n";
    }
}
