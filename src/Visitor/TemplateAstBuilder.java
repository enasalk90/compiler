package Visitor;

import AST.core.*;
import AST.Template.*;
import org.antlr.v4.runtime.*;
import java.util.*;

import Grammer.TemplateParserBaseVisitor;
import Grammer.TemplateParser;

public class TemplateAstBuilder extends TemplateParserBaseVisitor<AstNode> {

    private static int line(ParserRuleContext ctx) {
        return (ctx != null && ctx.getStart() != null) ? ctx.getStart().getLine() : 0;
    }

    public HtmlDocumentNode build(TemplateParser.HtmlDocumentContext ctx) {
        return (HtmlDocumentNode) visitHtmlDocument(ctx);
    }

    @Override public AstNode visitHtmlDocument(TemplateParser.HtmlDocumentContext ctx) {
        HtmlDocumentNode n = new HtmlDocumentNode("htmlDocument", line(ctx));

        if (ctx.doctype() != null) {
            var dt = (DoctypeNode) visitDoctype(ctx.doctype());
            n.setDoctype(dt);
            n.addChild(dt);
        }

        List<NodeNode> list = new ArrayList<>();
        for (var c : ctx.node()) {
            var nd = (NodeNode) visitNode(c);
            list.add(nd);
            n.addChild(nd);
        }
        n.setNodes(list);

        return n;
    }

    @Override public AstNode visitDoctype(TemplateParser.DoctypeContext ctx) {
        DoctypeNode n = new DoctypeNode("doctype", line(ctx));
        n.setRaw(ctx.getText());
        return n;
    }

    @Override public AstNode visitNode(TemplateParser.NodeContext ctx) {
        NodeNode n = new NodeNode("node", line(ctx));

        if (ctx.styleElement()!=null) {
            var se = (StyleElementNode) visitStyleElement(ctx.styleElement());
            n.setStyleElement(se);
            n.addChild(se);
        } else if (ctx.element()!=null) {
            var el = (ElementNode) visitElement(ctx.element());
            n.setElement(el);
            n.addChild(el);
        } else if (ctx.jinjaStmt()!=null) {
            var js = (AST.Template.JinjaStmtNode) visitJinjaStmt(ctx.jinjaStmt());
            n.setJinjaStmt(js);
            n.addChild(js);
        } else if (ctx.jinjaExpr()!=null) {
            var je = (AST.Template.JinjaExprNode) visitJinjaExpr(ctx.jinjaExpr());
            n.setJinjaExpr(je);
            n.addChild(je);
        } else if (ctx.text()!=null) {
            var tx = (TextNode) visitText(ctx.text());
            n.setText(tx);
            n.addChild(tx);
        }

        return n;
    }

    @Override public AstNode visitStyleElement(TemplateParser.StyleElementContext ctx) {
        StyleElementNode n = new StyleElementNode("styleElement", line(ctx));

        var css = (CssStylesheetNode) visitCssStylesheet(ctx.cssStylesheet());
        n.setCssStylesheet(css);
        n.addChild(css);

        return n;
    }

    @Override public AstNode visitElement(TemplateParser.ElementContext ctx) {
        ElementNode n = new ElementNode("element", line(ctx));

        if (ctx.voidElement()!=null) {
            var ve = (VoidElementNode) visitVoidElement(ctx.voidElement());
            n.setVoidElement(ve);
            n.addChild(ve);
        } else if (ctx.emptyElement()!=null) {
            var ee = (EmptyElementNode) visitEmptyElement(ctx.emptyElement());
            n.setEmptyElement(ee);
            n.addChild(ee);
        } else if (ctx.normalElement()!=null) {
            var ne = (NormalElementNode) visitNormalElement(ctx.normalElement());
            n.setNormalElement(ne);
            n.addChild(ne);
        }

        return n;
    }

    @Override public AstNode visitNormalElement(TemplateParser.NormalElementContext ctx) {
        NormalElementNode n = new NormalElementNode("normalElement", line(ctx));

        var st = (StartTagNode) visitStartTag(ctx.startTag());
        n.setStartTag(st);
        n.addChild(st);

        List<NodeNode> kids = new ArrayList<>();
        for (var c : ctx.node()) {
            var kid = (NodeNode) visitNode(c);
            kids.add(kid);
            n.addChild(kid);
        }
        n.setChildren(kids);

        var et = (EndTagNode) visitEndTag(ctx.endTag());
        n.setEndTag(et);
        n.addChild(et);

        return n;
    }

    @Override public AstNode visitStartTag(TemplateParser.StartTagContext ctx) {
        StartTagNode n = new StartTagNode("startTag", line(ctx));
        n.setTagName(ctx.NAME().getText());

        List<AttributeNode> attrs = new ArrayList<>();
        for (var a : ctx.attribute()) {
            var at = (AttributeNode) visitAttribute(a);
            attrs.add(at);
            n.addChild(at);
        }
        n.setAttributes(attrs);

        return n;
    }

    @Override public AstNode visitEndTag(TemplateParser.EndTagContext ctx) {
        EndTagNode n = new EndTagNode("endTag", line(ctx));
        n.setTagName(ctx.NAME().getText());
        return n;
    }

    @Override public AstNode visitVoidElement(TemplateParser.VoidElementContext ctx) {
        VoidElementNode n = new VoidElementNode("voidElement", line(ctx));
        n.setTagName(ctx.NAME().getText());

        List<AttributeNode> attrs = new ArrayList<>();
        for (var a : ctx.attribute()) {
            var at = (AttributeNode) visitAttribute(a);
            attrs.add(at);
            n.addChild(at);
        }
        n.setAttributes(attrs);

        return n;
    }

    @Override public AstNode visitEmptyElement(TemplateParser.EmptyElementContext ctx) {
        EmptyElementNode n = new EmptyElementNode("emptyElement", line(ctx));
        n.setTagName(ctx.NAME().getText());

        List<AttributeNode> attrs = new ArrayList<>();
        for (var a : ctx.attribute()) {
            var at = (AttributeNode) visitAttribute(a);
            attrs.add(at);
            n.addChild(at);
        }
        n.setAttributes(attrs);

        return n;
    }

    @Override public AstNode visitAttribute(TemplateParser.AttributeContext ctx) {
        AttributeNode n = new AttributeNode("attribute", line(ctx));
        n.setName(ctx.NAME().getText());

        if (ctx.attrValue()!=null) {
            var v = (AttrValueNode) visitAttrValue(ctx.attrValue());
            n.setValue(v);
            n.addChild(v);
        }

        return n;
    }

    @Override public AstNode visitAttrValue(TemplateParser.AttrValueContext ctx) {
        AttrValueNode n = new AttrValueNode("attrValue", line(ctx));

        if (ctx.ATTR_STRING()!=null) {
            n.setAttrString(ctx.ATTR_STRING().getText());
        } else if (ctx.jinjaExpr()!=null) {
            var je = (AST.Template.JinjaExprNode) visitJinjaExpr(ctx.jinjaExpr());
            n.setJinjaExpr(je);
            n.addChild(je);
        } else if (ctx.NAME()!=null) {
            n.setNameToken(ctx.NAME().getText());
        }

        return n;
    }

    @Override public AstNode visitJinjaStmt(TemplateParser.JinjaStmtContext ctx) {
        AST.Template.JinjaStmtNode n = new AST.Template.JinjaStmtNode("jinjaStmt", line(ctx));
        n.setRaw(ctx.getText());
        return n;
    }

    @Override public AstNode visitJinjaExpr(TemplateParser.JinjaExprContext ctx) {
        AST.Template.JinjaExprNode n = new AST.Template.JinjaExprNode("jinjaExpr", line(ctx));
        n.setRaw(ctx.getText());
        return n;
    }

    @Override public AstNode visitText(TemplateParser.TextContext ctx) {
        TextNode n = new TextNode("text", line(ctx));
        n.setText(ctx.getText());
        return n;
    }

    // CSS
    @Override public AstNode visitCssStylesheet(TemplateParser.CssStylesheetContext ctx) {
        CssStylesheetNode n = new CssStylesheetNode("cssStylesheet", line(ctx));

        List<CssRuleNode> rules = new ArrayList<>();
        for (var r : ctx.cssRule()) {
            var rule = (CssRuleNode) visitCssRule(r);
            rules.add(rule);
            n.addChild(rule);
        }
        n.setRules(rules);

        return n;
    }

    @Override public AstNode visitCssRule(TemplateParser.CssRuleContext ctx) {
        CssRuleNode n = new CssRuleNode("cssRule", line(ctx));

        var sl = (SelectorListNode) visitSelectorList(ctx.selectorList());
        n.setSelectorList(sl);
        n.addChild(sl);

        List<CssDeclNode> decls = new ArrayList<>();
        for (var d : ctx.cssDecl()) {
            var decl = (CssDeclNode) visitCssDecl(d);
            decls.add(decl);
            n.addChild(decl);
        }
        n.setDeclarations(decls);

        return n;
    }

    @Override public AstNode visitSelectorList(TemplateParser.SelectorListContext ctx) {
        SelectorListNode n = new SelectorListNode("selectorList", line(ctx));

        List<SelectorGroupNode> groups = new ArrayList<>();
        for (var g : ctx.selectorGroup()) {
            var grp = (SelectorGroupNode) visitSelectorGroup(g);
            groups.add(grp);
            n.addChild(grp);
        }
        n.setGroups(groups);

        return n;
    }

    @Override public AstNode visitSelectorGroup(TemplateParser.SelectorGroupContext ctx) {
        SelectorGroupNode n = new SelectorGroupNode("selectorGroup", line(ctx));

        List<SelectorAtomNode> atoms = new ArrayList<>();
        for (var a : ctx.selectorAtom()) {
            var at = (SelectorAtomNode) visitSelectorAtom(a);
            atoms.add(at);
            n.addChild(at);
        }
        n.setAtoms(atoms);

        return n;
    }

    @Override public AstNode visitSelectorAtom(TemplateParser.SelectorAtomContext ctx) {
        SelectorAtomNode n = new SelectorAtomNode("selectorAtom", line(ctx));
        n.setRaw(ctx.getText());
        return n;
    }

    @Override public AstNode visitCssDecl(TemplateParser.CssDeclContext ctx) {
        CssDeclNode n = new CssDeclNode("cssDecl", line(ctx));

        n.setProperty(ctx.CSS_IDENT().getText());

        var v = (CssValueNode) visitCssValue(ctx.cssValue());
        n.setValue(v);
        n.addChild(v);

        return n;
    }

    @Override public AstNode visitCssValue(TemplateParser.CssValueContext ctx) {
        CssValueNode n = new CssValueNode("cssValue", line(ctx));

        List<CssValuePartNode> parts = new ArrayList<>();
        for (var p : ctx.cssValuePart()) {
            var part = (CssValuePartNode) visitCssValuePart(p);
            parts.add(part);
            n.addChild(part);
        }
        n.setParts(parts);

        return n;
    }

    @Override public AstNode visitCssValuePart(TemplateParser.CssValuePartContext ctx) {
        CssValuePartNode n = new CssValuePartNode("cssValuePart", line(ctx));
        n.setRaw(ctx.getText());
        return n;
    }
}

//package Visitor;
//
//import AST.core.*;
//import AST.Template.*;
//import org.antlr.v4.runtime.*;
//import java.util.*;
//
//import Grammer.TemplateParserBaseVisitor;
//import Grammer.TemplateParser;
//
//public class TemplateAstBuilder extends TemplateParserBaseVisitor<AstNode> {
//
//    private static int line(ParserRuleContext ctx) {
//        return (ctx != null && ctx.getStart() != null) ? ctx.getStart().getLine() : 0;
//    }
//
//    public HtmlDocumentNode build(TemplateParser.HtmlDocumentContext ctx) {
//        return (HtmlDocumentNode) visitHtmlDocument(ctx);
//    }
//
//    @Override public AstNode visitHtmlDocument(TemplateParser.HtmlDocumentContext ctx) {
//        HtmlDocumentNode n = new HtmlDocumentNode("htmlDocument", line(ctx));
//        if (ctx.doctype() != null) n.setDoctype((DoctypeNode) visitDoctype(ctx.doctype()));
//        List<NodeNode> list = new ArrayList<>();
//        for (var c : ctx.node()) list.add((NodeNode) visitNode(c));
//        n.setNodes(list);
//        return n;
//    }
//
//    @Override public AstNode visitDoctype(TemplateParser.DoctypeContext ctx) {
//        DoctypeNode n = new DoctypeNode("doctype", line(ctx));
//        n.setRaw(ctx.getText());
//        return n;
//    }
//
//    @Override public AstNode visitNode(TemplateParser.NodeContext ctx) {
//        NodeNode n = new NodeNode("node", line(ctx));
//        if (ctx.styleElement()!=null) n.setStyleElement((StyleElementNode) visitStyleElement(ctx.styleElement()));
//        else if (ctx.element()!=null) n.setElement((ElementNode) visitElement(ctx.element()));
//        else if (ctx.jinjaStmt()!=null) n.setJinjaStmt((AST.Template.JinjaStmtNode) visitJinjaStmt(ctx.jinjaStmt()));
//        else if (ctx.jinjaExpr()!=null) n.setJinjaExpr((AST.Template.JinjaExprNode) visitJinjaExpr(ctx.jinjaExpr()));
//        else if (ctx.text()!=null) n.setText((TextNode) visitText(ctx.text()));
//        return n;
//    }
//
//    @Override public AstNode visitStyleElement(TemplateParser.StyleElementContext ctx) {
//        StyleElementNode n = new StyleElementNode("styleElement", line(ctx));
//        n.setCssStylesheet((CssStylesheetNode) visitCssStylesheet(ctx.cssStylesheet()));
//        return n;
//    }
//
//    @Override public AstNode visitElement(TemplateParser.ElementContext ctx) {
//        ElementNode n = new ElementNode("element", line(ctx));
//        if (ctx.voidElement()!=null) n.setVoidElement((VoidElementNode) visitVoidElement(ctx.voidElement()));
//        else if (ctx.emptyElement()!=null) n.setEmptyElement((EmptyElementNode) visitEmptyElement(ctx.emptyElement()));
//        else if (ctx.normalElement()!=null) n.setNormalElement((NormalElementNode) visitNormalElement(ctx.normalElement()));
//        return n;
//    }
//
//    @Override public AstNode visitNormalElement(TemplateParser.NormalElementContext ctx) {
//        NormalElementNode n = new NormalElementNode("normalElement", line(ctx));
//        n.setStartTag((StartTagNode) visitStartTag(ctx.startTag()));
//        List<NodeNode> kids = new ArrayList<>();
//        for (var c : ctx.node()) kids.add((NodeNode) visitNode(c));
//        n.setChildren(kids);
//        n.setEndTag((EndTagNode) visitEndTag(ctx.endTag()));
//        return n;
//    }
//
//    @Override public AstNode visitStartTag(TemplateParser.StartTagContext ctx) {
//        StartTagNode n = new StartTagNode("startTag", line(ctx));
//        n.setTagName(ctx.NAME().getText());
//        List<AttributeNode> attrs = new ArrayList<>();
//        for (var a : ctx.attribute()) attrs.add((AttributeNode) visitAttribute(a));
//        n.setAttributes(attrs);
//        return n;
//    }
//
//    @Override public AstNode visitEndTag(TemplateParser.EndTagContext ctx) {
//        EndTagNode n = new EndTagNode("endTag", line(ctx));
//        n.setTagName(ctx.NAME().getText());
//        return n;
//    }
//
//    @Override public AstNode visitVoidElement(TemplateParser.VoidElementContext ctx) {
//        VoidElementNode n = new VoidElementNode("voidElement", line(ctx));
//        n.setTagName(ctx.NAME().getText());
//        List<AttributeNode> attrs = new ArrayList<>();
//        for (var a : ctx.attribute()) attrs.add((AttributeNode) visitAttribute(a));
//        n.setAttributes(attrs);
//        return n;
//    }
//
//    @Override public AstNode visitEmptyElement(TemplateParser.EmptyElementContext ctx) {
//        EmptyElementNode n = new EmptyElementNode("emptyElement", line(ctx));
//        n.setTagName(ctx.NAME().getText());
//        List<AttributeNode> attrs = new ArrayList<>();
//        for (var a : ctx.attribute()) attrs.add((AttributeNode) visitAttribute(a));
//        n.setAttributes(attrs);
//        return n;
//    }
//
//    @Override public AstNode visitAttribute(TemplateParser.AttributeContext ctx) {
//        AttributeNode n = new AttributeNode("attribute", line(ctx));
//        n.setName(ctx.NAME().getText());
//        if (ctx.attrValue()!=null) n.setValue((AttrValueNode) visitAttrValue(ctx.attrValue()));
//        return n;
//    }
//
//    @Override public AstNode visitAttrValue(TemplateParser.AttrValueContext ctx) {
//        AttrValueNode n = new AttrValueNode("attrValue", line(ctx));
//        if (ctx.ATTR_STRING()!=null) n.setAttrString(ctx.ATTR_STRING().getText());
//        else if (ctx.jinjaExpr()!=null) n.setJinjaExpr((AST.Template.JinjaExprNode) visitJinjaExpr(ctx.jinjaExpr()));
//        else if (ctx.NAME()!=null) n.setNameToken(ctx.NAME().getText());
//        return n;
//    }
//
//    @Override public AstNode visitJinjaStmt(TemplateParser.JinjaStmtContext ctx) {
//        AST.Template.JinjaStmtNode n = new AST.Template.JinjaStmtNode("jinjaStmt", line(ctx));
//        n.setRaw(ctx.getText());
//        return n;
//    }
//
//    @Override public AstNode visitJinjaExpr(TemplateParser.JinjaExprContext ctx) {
//        AST.Template.JinjaExprNode n = new AST.Template.JinjaExprNode("jinjaExpr", line(ctx));
//        n.setRaw(ctx.getText());
//        return n;
//    }
//
//    @Override public AstNode visitText(TemplateParser.TextContext ctx) {
//        TextNode n = new TextNode("text", line(ctx));
//        n.setText(ctx.getText());
//        return n;
//    }
//
//    // CSS
//    @Override public AstNode visitCssStylesheet(TemplateParser.CssStylesheetContext ctx) {
//        CssStylesheetNode n = new CssStylesheetNode("cssStylesheet", line(ctx));
//        List<CssRuleNode> rules = new ArrayList<>();
//        for (var r : ctx.cssRule()) rules.add((CssRuleNode) visitCssRule(r));
//        n.setRules(rules);
//        return n;
//    }
//
//    @Override public AstNode visitCssRule(TemplateParser.CssRuleContext ctx) {
//        CssRuleNode n = new CssRuleNode("cssRule", line(ctx));
//        n.setSelectorList((SelectorListNode) visitSelectorList(ctx.selectorList()));
//        List<CssDeclNode> decls = new ArrayList<>();
//        for (var d : ctx.cssDecl()) decls.add((CssDeclNode) visitCssDecl(d));
//        n.setDeclarations(decls);
//        return n;
//    }
//
//    @Override public AstNode visitSelectorList(TemplateParser.SelectorListContext ctx) {
//        SelectorListNode n = new SelectorListNode("selectorList", line(ctx));
//        List<SelectorGroupNode> groups = new ArrayList<>();
//        for (var g : ctx.selectorGroup()) groups.add((SelectorGroupNode) visitSelectorGroup(g));
//        n.setGroups(groups);
//        return n;
//    }
//
//    @Override public AstNode visitSelectorGroup(TemplateParser.SelectorGroupContext ctx) {
//        SelectorGroupNode n = new SelectorGroupNode("selectorGroup", line(ctx));
//        List<SelectorAtomNode> atoms = new ArrayList<>();
//        for (var a : ctx.selectorAtom()) atoms.add((SelectorAtomNode) visitSelectorAtom(a));
//        n.setAtoms(atoms);
//        return n;
//    }
//
//    @Override public AstNode visitSelectorAtom(TemplateParser.SelectorAtomContext ctx) {
//        SelectorAtomNode n = new SelectorAtomNode("selectorAtom", line(ctx));
//        n.setRaw(ctx.getText());
//        return n;
//    }
//
//    @Override public AstNode visitCssDecl(TemplateParser.CssDeclContext ctx) {
//        CssDeclNode n = new CssDeclNode("cssDecl", line(ctx));
//        n.setProperty(ctx.CSS_IDENT().getText());
//        n.setValue((CssValueNode) visitCssValue(ctx.cssValue()));
//        return n;
//    }
//
//    @Override public AstNode visitCssValue(TemplateParser.CssValueContext ctx) {
//        CssValueNode n = new CssValueNode("cssValue", line(ctx));
//        List<CssValuePartNode> parts = new ArrayList<>();
//        for (var p : ctx.cssValuePart()) parts.add((CssValuePartNode) visitCssValuePart(p));
//        n.setParts(parts);
//        return n;
//    }
//
//    @Override public AstNode visitCssValuePart(TemplateParser.CssValuePartContext ctx) {
//        CssValuePartNode n = new CssValuePartNode("cssValuePart", line(ctx));
//        n.setRaw(ctx.getText());
//        return n;
//    }
//}

