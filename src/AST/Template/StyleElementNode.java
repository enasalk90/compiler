package AST.Template;

import AST.core.*;

public class StyleElementNode extends AstNode {
    private CssStylesheetNode cssStylesheet;

    public StyleElementNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public CssStylesheetNode getCssStylesheet() { return cssStylesheet; }
    public void setCssStylesheet(CssStylesheetNode cssStylesheet) { this.cssStylesheet = cssStylesheet; }

    @Override public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.openScope("StyleElementNode{name=" + getNodeName() + ", line=" + getLineNumber() + "}");
        if (cssStylesheet != null) sb.append(cssStylesheet);
        sb.closeScope("}");
        return sb.toString();
    }
}
