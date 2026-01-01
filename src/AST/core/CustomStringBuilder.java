package AST.core;

public class CustomStringBuilder {
    private final StringBuilder sb = new StringBuilder();
    private int level = 0;

    public CustomStringBuilder append(Object o) { sb.append(o); return this; }
    public CustomStringBuilder append(char c) { sb.append(c); return this; }
    public CustomStringBuilder append(String s) { sb.append(s); return this; }
    public CustomStringBuilder newLine() { sb.append('\n'); return this; }

    public CustomStringBuilder indent() {
        for (int i = 0; i < level; i++) sb.append("    ");
        return this;
    }

    public CustomStringBuilder openScope(String header) {
        indent().append(header).append('\n');
        level++;
        return this;
    }

    public CustomStringBuilder closeScope(String footer) {
        level = Math.max(0, level - 1);
        indent().append(footer).append('\n');
        return this;
    }

    @Override public String toString() { return sb.toString(); }
}
