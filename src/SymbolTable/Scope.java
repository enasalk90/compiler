package SymbolTable;

import java.util.*;

public class Scope {
    private final String name;
    private final int level;
    private final Scope parent;

    private final Map<String, Row> definitions = new LinkedHashMap<>();
    private final List<Row> usages = new ArrayList<>(); // لتسجيل "الاستخدامات" (مفيد للـ Template)
    private final List<Scope> children = new ArrayList<>();

    public Scope(String name, int level, Scope parent) {
        this.name = name;
        this.level = level;
        this.parent = parent;
        if (parent != null) parent.children.add(this);
    }

    public String getName() { return name; }
    public int getLevel() { return level; }
    public Scope getParent() { return parent; }

    public Collection<Row> getDefinitions() { return definitions.values(); }
    public List<Row> getUsages() { return Collections.unmodifiableList(usages); }
    public List<Scope> getChildren() { return Collections.unmodifiableList(children); }

    public boolean define(Row row) {
        if (row == null) return false;
        if (definitions.containsKey(row.getName())) return false; // already defined in this scope
        definitions.put(row.getName(), row);
        return true;
    }

    public void use(Row row) {
        if (row != null) usages.add(row);
    }

    public Row resolveLocal(String name) {
        return definitions.get(name);
    }

    public Row resolve(String name) {
        Scope cur = this;
        while (cur != null) {
            Row r = cur.resolveLocal(name);
            if (r != null) return r;
            cur = cur.parent;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Scope{name='" + name + "', level=" + level + ", defs=" + definitions.values() + ", uses=" + usages + "}";
    }
}
