package AST.Template;

import AST.core.*;
import java.util.*;

public class CssValueNode extends AstNode {
    private List<CssValuePartNode> parts = new ArrayList<>();

    public CssValueNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public List<CssValuePartNode> getParts() { return parts; }
    public void setParts(List<CssValuePartNode> parts) { this.parts = parts; }

    @Override public <R> R accept(AST.core.AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() { return "CssValueNode{parts=" + parts.size() + ", line=" + getLineNumber() + "}\n"; }
}
