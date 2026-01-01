// File: AST/python/IfStmtNode.java
package AST.python;

import AST.core.AstVisitor;

public class IfStmtNode extends StatementNode {
    private ExprNode condition;
    private SuiteNode thenSuite;
    private SuiteNode elseSuite; // optional

    public IfStmtNode(int line) { super("if_stmt", line); }

    public void setCondition(ExprNode condition) {
        this.condition = condition;
        addChild(condition);
    }

    public void setThenSuite(SuiteNode thenSuite) {
        this.thenSuite = thenSuite;
        addChild(thenSuite);
    }

    public void setElseSuite(SuiteNode elseSuite) {
        this.elseSuite = elseSuite;
        addChild(elseSuite);
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }
}
