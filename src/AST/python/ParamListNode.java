// File: AST/python/ParamListNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

import java.util.*;

public class ParamListNode extends AstNode {
    private final List<String> params = new ArrayList<>();

    public ParamListNode(int line) { super("param_list", line); }

    public List<String> getParams() { return params; }
    public void addParam(String p) { if (p != null) params.add(p); }

    @Override
    protected String prettyExtra() { return " " + params; }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
