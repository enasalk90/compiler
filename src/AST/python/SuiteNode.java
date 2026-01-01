// File: AST/python/SuiteNode.java
package AST.python;

import AST.core.AstNode;
import AST.core.AstVisitor;

import java.util.*;

public class SuiteNode extends AstNode {
    private final List<StatementNode> statements = new ArrayList<>();

    public SuiteNode(int line) { super("suite", line); }

    public List<StatementNode> getStatements() { return statements; }

    public void addStatement(StatementNode st) {
        if (st != null) {
            statements.add(st);
            addChild(st);
        }
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }

    @Override
    public String toString() { return pretty(); }
}
