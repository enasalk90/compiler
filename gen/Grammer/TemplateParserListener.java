// Generated from C:/Users/Abdullah/Desktop/complier/src/Grammer/TemplateParser.g4 by ANTLR 4.13.2
package Grammer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TemplateParser}.
 */
public interface TemplateParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TemplateParser#htmlDocument}.
	 * @param ctx the parse tree
	 */
	void enterHtmlDocument(TemplateParser.HtmlDocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#htmlDocument}.
	 * @param ctx the parse tree
	 */
	void exitHtmlDocument(TemplateParser.HtmlDocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#doctype}.
	 * @param ctx the parse tree
	 */
	void enterDoctype(TemplateParser.DoctypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#doctype}.
	 * @param ctx the parse tree
	 */
	void exitDoctype(TemplateParser.DoctypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#node}.
	 * @param ctx the parse tree
	 */
	void enterNode(TemplateParser.NodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#node}.
	 * @param ctx the parse tree
	 */
	void exitNode(TemplateParser.NodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#styleElement}.
	 * @param ctx the parse tree
	 */
	void enterStyleElement(TemplateParser.StyleElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#styleElement}.
	 * @param ctx the parse tree
	 */
	void exitStyleElement(TemplateParser.StyleElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(TemplateParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(TemplateParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#normalElement}.
	 * @param ctx the parse tree
	 */
	void enterNormalElement(TemplateParser.NormalElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#normalElement}.
	 * @param ctx the parse tree
	 */
	void exitNormalElement(TemplateParser.NormalElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#startTag}.
	 * @param ctx the parse tree
	 */
	void enterStartTag(TemplateParser.StartTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#startTag}.
	 * @param ctx the parse tree
	 */
	void exitStartTag(TemplateParser.StartTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#endTag}.
	 * @param ctx the parse tree
	 */
	void enterEndTag(TemplateParser.EndTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#endTag}.
	 * @param ctx the parse tree
	 */
	void exitEndTag(TemplateParser.EndTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#emptyElement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyElement(TemplateParser.EmptyElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#emptyElement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyElement(TemplateParser.EmptyElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#voidElement}.
	 * @param ctx the parse tree
	 */
	void enterVoidElement(TemplateParser.VoidElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#voidElement}.
	 * @param ctx the parse tree
	 */
	void exitVoidElement(TemplateParser.VoidElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(TemplateParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(TemplateParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void enterAttrValue(TemplateParser.AttrValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void exitAttrValue(TemplateParser.AttrValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#jinjaStmt}.
	 * @param ctx the parse tree
	 */
	void enterJinjaStmt(TemplateParser.JinjaStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#jinjaStmt}.
	 * @param ctx the parse tree
	 */
	void exitJinjaStmt(TemplateParser.JinjaStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExpr(TemplateParser.JinjaExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExpr(TemplateParser.JinjaExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(TemplateParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(TemplateParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#cssStylesheet}.
	 * @param ctx the parse tree
	 */
	void enterCssStylesheet(TemplateParser.CssStylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#cssStylesheet}.
	 * @param ctx the parse tree
	 */
	void exitCssStylesheet(TemplateParser.CssStylesheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void enterCssRule(TemplateParser.CssRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void exitCssRule(TemplateParser.CssRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#selectorList}.
	 * @param ctx the parse tree
	 */
	void enterSelectorList(TemplateParser.SelectorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#selectorList}.
	 * @param ctx the parse tree
	 */
	void exitSelectorList(TemplateParser.SelectorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#selectorGroup}.
	 * @param ctx the parse tree
	 */
	void enterSelectorGroup(TemplateParser.SelectorGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#selectorGroup}.
	 * @param ctx the parse tree
	 */
	void exitSelectorGroup(TemplateParser.SelectorGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#selectorAtom}.
	 * @param ctx the parse tree
	 */
	void enterSelectorAtom(TemplateParser.SelectorAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#selectorAtom}.
	 * @param ctx the parse tree
	 */
	void exitSelectorAtom(TemplateParser.SelectorAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#cssDecl}.
	 * @param ctx the parse tree
	 */
	void enterCssDecl(TemplateParser.CssDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#cssDecl}.
	 * @param ctx the parse tree
	 */
	void exitCssDecl(TemplateParser.CssDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssValue(TemplateParser.CssValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssValue(TemplateParser.CssValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#cssValuePart}.
	 * @param ctx the parse tree
	 */
	void enterCssValuePart(TemplateParser.CssValuePartContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#cssValuePart}.
	 * @param ctx the parse tree
	 */
	void exitCssValuePart(TemplateParser.CssValuePartContext ctx);
}