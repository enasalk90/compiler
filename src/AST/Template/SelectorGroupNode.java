package AST.Template;

import AST.core.*;
import java.util.*;

public class SelectorGroupNode extends AstNode {
    private List<SelectorAtomNode> atoms = new ArrayList<>();

    public SelectorGroupNode(String nodeName, int lineNumber) { super(nodeName, lineNumber); }

    public List<SelectorAtomNode> getAtoms() { return atoms; }
    public void setAtoms(List<SelectorAtomNode> atoms) { this.atoms = atoms; }

    @Override public <R> R accept(AST.core.AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override public String toString() { return "SelectorGroupNode{atoms=" + atoms.size() + ", line=" + getLineNumber() + "}\n"; }
}
