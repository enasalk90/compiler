package AST.Template;

import AST.core.*;
import java.util.*;

public class CssStylesheetNode extends AstNode {
    private List<CssRuleNode> rules = new ArrayList<>();

    public CssStylesheetNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public List<CssRuleNode> getRules() { return rules; }
    public void setRules(List<CssRuleNode> rules) { this.rules = rules; }

    @Override public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.openScope("CssStylesheetNode{name=" + getNodeName() + ", line=" + getLineNumber() + "}");
        for (CssRuleNode r : rules) sb.append(r);
        sb.closeScope("}");
        return sb.toString();
    }
}
