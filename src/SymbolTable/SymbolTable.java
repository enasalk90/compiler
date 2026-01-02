// File: SymbolTable/SymbolTable.java
package SymbolTable;

import java.util.*;

public class SymbolTable {

    private final Deque<Scope> stack = new ArrayDeque<>();
    private final Scope root;

    public SymbolTable() {
        root = new Scope("global", 0, null);
        stack.push(root);
    }

    public Scope root() { return root; }
    public Scope current() { return stack.peek(); }

    public void enterScope(String name) {
        Scope parent = current();
        int level = (parent == null) ? 0 : parent.getLevel() + 1;
        Scope child = new Scope(name, level, parent);
        stack.push(child);
    }

    public void exitScope() {
        if (stack.size() <= 1) return; // keep global
        stack.pop();
    }

    public boolean define(Row row) {
        Scope c = current();
        return c != null && c.define(row);
    }

    public void use(Row row) {
        Scope c = current();
        if (c != null) c.use(row);
    }

    public Row resolve(String name) {
        Scope c = current();
        return (c == null) ? null : c.resolve(name);
    }

    public void print() {
        System.out.println("==== SYMBOL TABLE (SCOPES) ====");
        printScope(root, "", true);
        System.out.println("================================");
    }

    private void printScope(Scope scope, String indent, boolean isLast) {
        System.out.print(indent);
        System.out.print(isLast ? "└─ " : "├─ ");
        System.out.println("Scope[" + scope.getName() + "] level=" + scope.getLevel());

        String nextIndent = indent + (isLast ? "   " : "│  ");

        // Definitions
        for (Row r : scope.getDefinitions()) {
            System.out.print(nextIndent);
            System.out.println("DEF • " + r);
        }

        // Usages
        for (Row r : scope.getUsages()) {
            System.out.print(nextIndent);
            System.out.println("USE • " + r);
        }

        // Children scopes
        List<Scope> kids = scope.getChildren();
        for (int i = 0; i < kids.size(); i++) {
            printScope(kids.get(i), nextIndent, i == kids.size() - 1);
        }
    }
}
