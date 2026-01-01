// File: AST/python/ImportStmtNode.java
package AST.python;

import AST.core.AstVisitor;

public class ImportStmtNode extends StatementNode {
    private boolean isFromImport;
    private String fromModule; // NAME after FROM
    private ImportItemsNode items;

    public ImportStmtNode(int line) { super("import_stmt", line); }

    public boolean isFromImport() { return isFromImport; }
    public void setFromImport(boolean fromImport) { isFromImport = fromImport; }

    public String getFromModule() { return fromModule; }
    public void setFromModule(String fromModule) { this.fromModule = fromModule; }

    public ImportItemsNode getItems() { return items; }
    public void setItems(ImportItemsNode items) {
        this.items = items;
        addChild(items);
    }

    @Override
    protected String prettyExtra() {
        return " [fromImport=" + isFromImport + (fromModule != null ? ", module=" + fromModule : "") + "]";
    }

    @Override
    public <R> R accept(AstVisitor<R> visitor) { return visitor.visit(this); }
}
