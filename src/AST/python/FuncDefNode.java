// File: AST/python/FuncDefNode.java
package AST.python;

import AST.core.AstVisitor;

public class FuncDefNode extends StatementNode {
    private String name;
    private ParamListNode params; // optional
    private SuiteNode suite;

    public FuncDefNode(int line) { super("funcdef", line); }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ParamListNode getParams() { return params; }
    public void setParams(ParamListNode params) {
        this.params = params;
        addChild(params);
    }

    public SuiteNode getSuite() { return suite; }
    public void setSuite(SuiteNode suite) {
        this.suite = suite;
        addChild(suite);
    }

    @Override
    protected String prettyExtra() { return " [name=" + name + "]"; }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }
}
