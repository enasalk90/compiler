// File: SymbolTable/Row.java
package SymbolTable;

public class Row {
    private final String name;
    private final String kind;     // e.g. "import", "function", "variable"
    private final String typeInfo; // optional: module/type/...
    private final int line;

    public Row(String name, String kind, String typeInfo, int line) {
        this.name = name;
        this.kind = kind;
        this.typeInfo = typeInfo;
        this.line = line;
    }

    public String getName() { return name; }
    public String getKind() { return kind; }
    public String getTypeInfo() { return typeInfo; }
    public int getLine() { return line; }

    @Override
    public String toString() {
        return "Row{name='" + name + "', kind='" + kind + "', typeInfo='" + typeInfo + "', line=" + line + "}";
    }
}
