// Generated from C:/Users/Abdullah/Desktop/complier/src/Grammer/TemplateParser.g4 by ANTLR 4.13.2
package Grammer;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TemplateParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TemplateParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TemplateParser#htmlDocument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlDocument(TemplateParser.HtmlDocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#doctype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoctype(TemplateParser.DoctypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNode(TemplateParser.NodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#styleElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyleElement(TemplateParser.StyleElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(TemplateParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#normalElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalElement(TemplateParser.NormalElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#startTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartTag(TemplateParser.StartTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#endTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndTag(TemplateParser.EndTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#emptyElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyElement(TemplateParser.EmptyElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#voidElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidElement(TemplateParser.VoidElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(TemplateParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#attrValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrValue(TemplateParser.AttrValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#jinjaStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaStmt(TemplateParser.JinjaStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExpr(TemplateParser.JinjaExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(TemplateParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#cssStylesheet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssStylesheet(TemplateParser.CssStylesheetContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#cssRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssRule(TemplateParser.CssRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#selectorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectorList(TemplateParser.SelectorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#selectorGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectorGroup(TemplateParser.SelectorGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#selectorAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectorAtom(TemplateParser.SelectorAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#cssDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssDecl(TemplateParser.CssDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValue(TemplateParser.CssValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#cssValuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValuePart(TemplateParser.CssValuePartContext ctx);
}