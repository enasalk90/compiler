// File: AST/python/ImportItemsNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

import java.util.*;

public class ImportItemsNode extends AstNode {
    private final List<String> names = new ArrayList<>();

    public ImportItemsNode(int line) { super("import_items", line); }

    public List<String> getNames() { return names; }
    public void addName(String n) { if (n != null) names.add(n); }

    @Override
    protected String prettyExtra() { return " " + names; }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
