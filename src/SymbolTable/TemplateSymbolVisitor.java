package SymbolTable;

import AST.core.AstNode;
import AST.Template.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateSymbolVisitor {

    private final SymbolTable sym = new SymbolTable();

    // كلمات نتجاهلها عند استخراج identifiers
    private static final Set<String> IGNORE = Set.of(
            "for","in","if","else","endif","endfor","true","false","none","and","or","not",
            "endblock","block","macro","endmacro","set","include","extends","with","without","context"
    );

    // identifier regex
    private static final Pattern IDENT = Pattern.compile("[A-Za-z_][A-Za-z0-9_]*");

    // {% for p in products %}
    private static final Pattern FOR_STMT =
            Pattern.compile("\\{%-?\\s*for\\s+([A-Za-z_][A-Za-z0-9_]*)\\s+in\\s+(.+?)\\s*-?%\\}");

    // {% endfor %}
    private static final Pattern ENDFOR_STMT =
            Pattern.compile("\\{%-?\\s*endfor\\s*-?%\\}");

    // {% if condition %}
    private static final Pattern IF_STMT =
            Pattern.compile("\\{%-?\\s*if\\s+(.+?)\\s*-?%\\}");

    // {% endif %}
    private static final Pattern ENDIF_STMT =
            Pattern.compile("\\{%-?\\s*endif\\s*-?%\\}");

    // {% set x = expr %}
    private static final Pattern SET_STMT =
            Pattern.compile("\\{%-?\\s*set\\s+([A-Za-z_][A-Za-z0-9_]*)\\s*=\\s*(.+?)\\s*-?%\\}");

    // {% include "x.html" %}
    private static final Pattern INCLUDE_STMT =
            Pattern.compile("\\{%-?\\s*include\\s+(\"[^\"]+\"|'[^']+')\\s*-?%\\}");

    // {% extends "base.html" %}
    private static final Pattern EXTENDS_STMT =
            Pattern.compile("\\{%-?\\s*extends\\s+(\"[^\"]+\"|'[^']+')\\s*-?%\\}");

    public SymbolTable collect(HtmlDocumentNode doc) {
        if (doc == null) return sym;

        // scope global موجود تلقائياً
        walk(doc);
        return sym;
    }

    private void walk(AstNode n) {
        if (n == null) return;

        if (n instanceof JinjaExprNode) {
            handleJinjaExpr((JinjaExprNode) n);
        } else if (n instanceof JinjaStmtNode) {
            handleJinjaStmt((JinjaStmtNode) n);
        }

        for (AstNode c : n.getChildren()) walk(c);
    }

    private void handleJinjaExpr(JinjaExprNode n) {
        String raw = n.getRaw();
        if (raw == null) return;

        // مثال raw: {{ products }} أو {{ product.name }}
        Set<String> ids = extractIdentifiers(raw);
        for (String id : ids) {
            sym.use(new Row(id, "use", "jinja_expr", n.getLineNumber()));
        }
    }

    private void handleJinjaStmt(JinjaStmtNode n) {
        String raw = n.getRaw();
        if (raw == null) return;

        // 1) for
        Matcher mf = FOR_STMT.matcher(raw);
        if (mf.find()) {
            String loopVar = mf.group(1);
            String iterExpr = mf.group(2);

            sym.enterScope("for@line" + n.getLineNumber());
            sym.define(new Row(loopVar, "loop_var", "jinja_for", n.getLineNumber()));

            // identifiers used in iterable expression
            for (String id : extractIdentifiers(iterExpr)) {
                if (!id.equals(loopVar)) {
                    sym.use(new Row(id, "use", "jinja_for_iter", n.getLineNumber()));
                }
            }
            return;
        }

        // 2) endfor
        if (ENDFOR_STMT.matcher(raw).find()) {
            sym.exitScope();
            return;
        }

        // 3) if
        Matcher mi = IF_STMT.matcher(raw);
        if (mi.find()) {
            String cond = mi.group(1);
            sym.enterScope("if@line" + n.getLineNumber());
            for (String id : extractIdentifiers(cond)) {
                sym.use(new Row(id, "use", "jinja_if_cond", n.getLineNumber()));
            }
            return;
        }

        // 4) endif
        if (ENDIF_STMT.matcher(raw).find()) {
            sym.exitScope();
            return;
        }

        // 5) set
        Matcher ms = SET_STMT.matcher(raw);
        if (ms.find()) {
            String name = ms.group(1);
            String expr = ms.group(2);

            sym.define(new Row(name, "template_var", "jinja_set", n.getLineNumber()));
            for (String id : extractIdentifiers(expr)) {
                if (!id.equals(name)) {
                    sym.use(new Row(id, "use", "jinja_set_expr", n.getLineNumber()));
                }
            }
            return;
        }

        // 6) include
        Matcher minc = INCLUDE_STMT.matcher(raw);
        if (minc.find()) {
            String tpl = stripQuotes(minc.group(1));
            sym.define(new Row(tpl, "include", "jinja_include", n.getLineNumber()));
            return;
        }

        // 7) extends
        Matcher mex = EXTENDS_STMT.matcher(raw);
        if (mex.find()) {
            String tpl = stripQuotes(mex.group(1));
            sym.define(new Row(tpl, "extends", "jinja_extends", n.getLineNumber()));
            return;
        }

        // default: سجل identifiers كـ use (تحليل عام لأي stmt آخر)
        for (String id : extractIdentifiers(raw)) {
            sym.use(new Row(id, "use", "jinja_stmt", n.getLineNumber()));
        }
    }

    private String stripQuotes(String s) {
        if (s == null) return null;
        s = s.trim();
        if ((s.startsWith("\"") && s.endsWith("\"")) || (s.startsWith("'") && s.endsWith("'"))) {
            return s.substring(1, s.length() - 1);
        }
        return s;
    }

    private Set<String> extractIdentifiers(String s) {
        Set<String> out = new LinkedHashSet<>();
        Matcher m = IDENT.matcher(s);
        while (m.find()) {
            String id = m.group();
            if (!IGNORE.contains(id)) out.add(id);
        }
        return out;
    }
}
