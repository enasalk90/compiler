package AST.Template;

import AST.core.*;
import java.util.*;

public class CssRuleNode extends AstNode {
    private SelectorListNode selectorList;
    private List<CssDeclNode> declarations = new ArrayList<>();

    public CssRuleNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public SelectorListNode getSelectorList() { return selectorList; }
    public void setSelectorList(SelectorListNode selectorList) { this.selectorList = selectorList; }

    public List<CssDeclNode> getDeclarations() { return declarations; }
    public void setDeclarations(List<CssDeclNode> declarations) { this.declarations = declarations; }

    @Override public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.openScope("CssRuleNode{line=" + getLineNumber() + "}");
        if (selectorList != null) sb.append(selectorList);
        for (CssDeclNode d : declarations) sb.append(d);
        sb.closeScope("}");
        return sb.toString();
    }
}
