// Generated from C:/Users/Abdullah/Desktop/complier/src/Grammer/TemplateParser.g4 by ANTLR 4.13.2
package Grammer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TemplateParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOCTYPE=1, STYLE_OPEN=2, JINJA_EXPR=3, JINJA_STMT=4, LT=5, HTML_TEXT=6, 
		WS_DATA=7, GT=8, SLASH=9, EQ=10, NAME=11, ATTR_STRING=12, WS_TAG=13, STYLE_CLOSE=14, 
		LBRACE=15, RBRACE=16, COLON=17, SEMI=18, COMMA=19, DOT=20, HASH=21, STAR=22, 
		CSS_IDENT=23, CSS_NUMBER=24, CSS_DIMENSION=25, CSS_PERCENT=26, CSS_HASHCOLOR=27, 
		CSS_STRING=28, WS_CSS=29, CSS_OTHER=30;
	public static final int
		RULE_htmlDocument = 0, RULE_doctype = 1, RULE_node = 2, RULE_styleElement = 3, 
		RULE_element = 4, RULE_normalElement = 5, RULE_startTag = 6, RULE_endTag = 7, 
		RULE_emptyElement = 8, RULE_voidElement = 9, RULE_attribute = 10, RULE_attrValue = 11, 
		RULE_jinjaStmt = 12, RULE_jinjaExpr = 13, RULE_text = 14, RULE_cssStylesheet = 15, 
		RULE_cssRule = 16, RULE_selectorList = 17, RULE_selectorGroup = 18, RULE_selectorAtom = 19, 
		RULE_cssDecl = 20, RULE_cssValue = 21, RULE_cssValuePart = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"htmlDocument", "doctype", "node", "styleElement", "element", "normalElement", 
			"startTag", "endTag", "emptyElement", "voidElement", "attribute", "attrValue", 
			"jinjaStmt", "jinjaExpr", "text", "cssStylesheet", "cssRule", "selectorList", 
			"selectorGroup", "selectorAtom", "cssDecl", "cssValue", "cssValuePart"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'<'", null, null, "'>'", "'/'", "'='", 
			null, null, null, "'</style>'", "'{'", "'}'", "':'", "';'", "','", "'.'", 
			"'#'", "'*'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOCTYPE", "STYLE_OPEN", "JINJA_EXPR", "JINJA_STMT", "LT", "HTML_TEXT", 
			"WS_DATA", "GT", "SLASH", "EQ", "NAME", "ATTR_STRING", "WS_TAG", "STYLE_CLOSE", 
			"LBRACE", "RBRACE", "COLON", "SEMI", "COMMA", "DOT", "HASH", "STAR", 
			"CSS_IDENT", "CSS_NUMBER", "CSS_DIMENSION", "CSS_PERCENT", "CSS_HASHCOLOR", 
			"CSS_STRING", "WS_CSS", "CSS_OTHER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "TemplateParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TemplateParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlDocumentContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TemplateParser.EOF, 0); }
		public DoctypeContext doctype() {
			return getRuleContext(DoctypeContext.class,0);
		}
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public HtmlDocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlDocument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterHtmlDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitHtmlDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitHtmlDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlDocumentContext htmlDocument() throws RecognitionException {
		HtmlDocumentContext _localctx = new HtmlDocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_htmlDocument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOCTYPE) {
				{
				setState(46);
				doctype();
				}
			}

			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124L) != 0)) {
				{
				{
				setState(49);
				node();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoctypeContext extends ParserRuleContext {
		public TerminalNode DOCTYPE() { return getToken(TemplateParser.DOCTYPE, 0); }
		public DoctypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doctype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterDoctype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitDoctype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitDoctype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoctypeContext doctype() throws RecognitionException {
		DoctypeContext _localctx = new DoctypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_doctype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(DOCTYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NodeContext extends ParserRuleContext {
		public StyleElementContext styleElement() {
			return getRuleContext(StyleElementContext.class,0);
		}
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public JinjaStmtContext jinjaStmt() {
			return getRuleContext(JinjaStmtContext.class,0);
		}
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public NodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodeContext node() throws RecognitionException {
		NodeContext _localctx = new NodeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_node);
		try {
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STYLE_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				styleElement();
				}
				break;
			case LT:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				element();
				}
				break;
			case JINJA_STMT:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				jinjaStmt();
				}
				break;
			case JINJA_EXPR:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				jinjaExpr();
				}
				break;
			case HTML_TEXT:
				enterOuterAlt(_localctx, 5);
				{
				setState(63);
				text();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StyleElementContext extends ParserRuleContext {
		public TerminalNode STYLE_OPEN() { return getToken(TemplateParser.STYLE_OPEN, 0); }
		public CssStylesheetContext cssStylesheet() {
			return getRuleContext(CssStylesheetContext.class,0);
		}
		public TerminalNode STYLE_CLOSE() { return getToken(TemplateParser.STYLE_CLOSE, 0); }
		public StyleElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styleElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterStyleElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitStyleElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitStyleElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StyleElementContext styleElement() throws RecognitionException {
		StyleElementContext _localctx = new StyleElementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_styleElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(STYLE_OPEN);
			setState(67);
			cssStylesheet();
			setState(68);
			match(STYLE_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementContext extends ParserRuleContext {
		public VoidElementContext voidElement() {
			return getRuleContext(VoidElementContext.class,0);
		}
		public EmptyElementContext emptyElement() {
			return getRuleContext(EmptyElementContext.class,0);
		}
		public NormalElementContext normalElement() {
			return getRuleContext(NormalElementContext.class,0);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_element);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				voidElement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				emptyElement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				normalElement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NormalElementContext extends ParserRuleContext {
		public StartTagContext startTag() {
			return getRuleContext(StartTagContext.class,0);
		}
		public EndTagContext endTag() {
			return getRuleContext(EndTagContext.class,0);
		}
		public List<NodeContext> node() {
			return getRuleContexts(NodeContext.class);
		}
		public NodeContext node(int i) {
			return getRuleContext(NodeContext.class,i);
		}
		public NormalElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterNormalElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitNormalElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitNormalElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormalElementContext normalElement() throws RecognitionException {
		NormalElementContext _localctx = new NormalElementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_normalElement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			startTag();
			setState(79);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(76);
					node();
					}
					} 
				}
				setState(81);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(82);
			endTag();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartTagContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(TemplateParser.LT, 0); }
		public TerminalNode NAME() { return getToken(TemplateParser.NAME, 0); }
		public TerminalNode GT() { return getToken(TemplateParser.GT, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public StartTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterStartTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitStartTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitStartTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartTagContext startTag() throws RecognitionException {
		StartTagContext _localctx = new StartTagContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_startTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(LT);
			setState(85);
			match(NAME);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(86);
				attribute();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EndTagContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(TemplateParser.LT, 0); }
		public TerminalNode SLASH() { return getToken(TemplateParser.SLASH, 0); }
		public TerminalNode NAME() { return getToken(TemplateParser.NAME, 0); }
		public TerminalNode GT() { return getToken(TemplateParser.GT, 0); }
		public EndTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterEndTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitEndTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitEndTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndTagContext endTag() throws RecognitionException {
		EndTagContext _localctx = new EndTagContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_endTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(LT);
			setState(95);
			match(SLASH);
			setState(96);
			match(NAME);
			setState(97);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EmptyElementContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(TemplateParser.LT, 0); }
		public TerminalNode NAME() { return getToken(TemplateParser.NAME, 0); }
		public TerminalNode SLASH() { return getToken(TemplateParser.SLASH, 0); }
		public TerminalNode GT() { return getToken(TemplateParser.GT, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public EmptyElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterEmptyElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitEmptyElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitEmptyElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyElementContext emptyElement() throws RecognitionException {
		EmptyElementContext _localctx = new EmptyElementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_emptyElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(LT);
			setState(100);
			match(NAME);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(101);
				attribute();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			match(SLASH);
			setState(108);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VoidElementContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(TemplateParser.LT, 0); }
		public TerminalNode NAME() { return getToken(TemplateParser.NAME, 0); }
		public TerminalNode GT() { return getToken(TemplateParser.GT, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public VoidElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterVoidElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitVoidElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitVoidElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoidElementContext voidElement() throws RecognitionException {
		VoidElementContext _localctx = new VoidElementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_voidElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(LT);
			setState(111);
			match(NAME);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(112);
				attribute();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(TemplateParser.NAME, 0); }
		public TerminalNode EQ() { return getToken(TemplateParser.EQ, 0); }
		public AttrValueContext attrValue() {
			return getRuleContext(AttrValueContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(NAME);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(121);
				match(EQ);
				setState(122);
				attrValue();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttrValueContext extends ParserRuleContext {
		public TerminalNode ATTR_STRING() { return getToken(TemplateParser.ATTR_STRING, 0); }
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public TerminalNode NAME() { return getToken(TemplateParser.NAME, 0); }
		public AttrValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterAttrValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitAttrValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitAttrValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrValueContext attrValue() throws RecognitionException {
		AttrValueContext _localctx = new AttrValueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_attrValue);
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATTR_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(ATTR_STRING);
				}
				break;
			case JINJA_EXPR:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				jinjaExpr();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				match(NAME);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaStmtContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT() { return getToken(TemplateParser.JINJA_STMT, 0); }
		public JinjaStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaStmtContext jinjaStmt() throws RecognitionException {
		JinjaStmtContext _localctx = new JinjaStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_jinjaStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(JINJA_STMT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExprContext extends ParserRuleContext {
		public TerminalNode JINJA_EXPR() { return getToken(TemplateParser.JINJA_EXPR, 0); }
		public JinjaExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaExprContext jinjaExpr() throws RecognitionException {
		JinjaExprContext _localctx = new JinjaExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_jinjaExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(JINJA_EXPR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextContext extends ParserRuleContext {
		public TerminalNode HTML_TEXT() { return getToken(TemplateParser.HTML_TEXT, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(HTML_TEXT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssStylesheetContext extends ParserRuleContext {
		public List<CssRuleContext> cssRule() {
			return getRuleContexts(CssRuleContext.class);
		}
		public CssRuleContext cssRule(int i) {
			return getRuleContext(CssRuleContext.class,i);
		}
		public CssStylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssStylesheet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterCssStylesheet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitCssStylesheet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitCssStylesheet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssStylesheetContext cssStylesheet() throws RecognitionException {
		CssStylesheetContext _localctx = new CssStylesheetContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_cssStylesheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 15728640L) != 0)) {
				{
				{
				setState(136);
				cssRule();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssRuleContext extends ParserRuleContext {
		public SelectorListContext selectorList() {
			return getRuleContext(SelectorListContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(TemplateParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(TemplateParser.RBRACE, 0); }
		public List<CssDeclContext> cssDecl() {
			return getRuleContexts(CssDeclContext.class);
		}
		public CssDeclContext cssDecl(int i) {
			return getRuleContext(CssDeclContext.class,i);
		}
		public CssRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterCssRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitCssRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitCssRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssRuleContext cssRule() throws RecognitionException {
		CssRuleContext _localctx = new CssRuleContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_cssRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			selectorList();
			setState(143);
			match(LBRACE);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CSS_IDENT) {
				{
				{
				setState(144);
				cssDecl();
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(150);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectorListContext extends ParserRuleContext {
		public List<SelectorGroupContext> selectorGroup() {
			return getRuleContexts(SelectorGroupContext.class);
		}
		public SelectorGroupContext selectorGroup(int i) {
			return getRuleContext(SelectorGroupContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(TemplateParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(TemplateParser.COMMA, i);
		}
		public SelectorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterSelectorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitSelectorList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitSelectorList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorListContext selectorList() throws RecognitionException {
		SelectorListContext _localctx = new SelectorListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_selectorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			selectorGroup();
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(153);
				match(COMMA);
				setState(154);
				selectorGroup();
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectorGroupContext extends ParserRuleContext {
		public List<SelectorAtomContext> selectorAtom() {
			return getRuleContexts(SelectorAtomContext.class);
		}
		public SelectorAtomContext selectorAtom(int i) {
			return getRuleContext(SelectorAtomContext.class,i);
		}
		public SelectorGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterSelectorGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitSelectorGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitSelectorGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorGroupContext selectorGroup() throws RecognitionException {
		SelectorGroupContext _localctx = new SelectorGroupContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_selectorGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(160);
				selectorAtom();
				}
				}
				setState(163); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15728640L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SelectorAtomContext extends ParserRuleContext {
		public TerminalNode CSS_IDENT() { return getToken(TemplateParser.CSS_IDENT, 0); }
		public TerminalNode DOT() { return getToken(TemplateParser.DOT, 0); }
		public TerminalNode HASH() { return getToken(TemplateParser.HASH, 0); }
		public TerminalNode STAR() { return getToken(TemplateParser.STAR, 0); }
		public SelectorAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterSelectorAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitSelectorAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitSelectorAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorAtomContext selectorAtom() throws RecognitionException {
		SelectorAtomContext _localctx = new SelectorAtomContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_selectorAtom);
		try {
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CSS_IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				match(CSS_IDENT);
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				match(DOT);
				setState(167);
				match(CSS_IDENT);
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				match(HASH);
				setState(169);
				match(CSS_IDENT);
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				match(STAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssDeclContext extends ParserRuleContext {
		public TerminalNode CSS_IDENT() { return getToken(TemplateParser.CSS_IDENT, 0); }
		public TerminalNode COLON() { return getToken(TemplateParser.COLON, 0); }
		public CssValueContext cssValue() {
			return getRuleContext(CssValueContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(TemplateParser.SEMI, 0); }
		public CssDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterCssDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitCssDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitCssDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssDeclContext cssDecl() throws RecognitionException {
		CssDeclContext _localctx = new CssDeclContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_cssDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(CSS_IDENT);
			setState(174);
			match(COLON);
			setState(175);
			cssValue();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(176);
				match(SEMI);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssValueContext extends ParserRuleContext {
		public List<CssValuePartContext> cssValuePart() {
			return getRuleContexts(CssValuePartContext.class);
		}
		public CssValuePartContext cssValuePart(int i) {
			return getRuleContext(CssValuePartContext.class,i);
		}
		public CssValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterCssValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitCssValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitCssValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueContext cssValue() throws RecognitionException {
		CssValueContext _localctx = new CssValueContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_cssValue);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(180); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(179);
					cssValuePart();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(182); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssValuePartContext extends ParserRuleContext {
		public TerminalNode CSS_IDENT() { return getToken(TemplateParser.CSS_IDENT, 0); }
		public TerminalNode CSS_NUMBER() { return getToken(TemplateParser.CSS_NUMBER, 0); }
		public TerminalNode CSS_DIMENSION() { return getToken(TemplateParser.CSS_DIMENSION, 0); }
		public TerminalNode CSS_PERCENT() { return getToken(TemplateParser.CSS_PERCENT, 0); }
		public TerminalNode CSS_HASHCOLOR() { return getToken(TemplateParser.CSS_HASHCOLOR, 0); }
		public TerminalNode CSS_STRING() { return getToken(TemplateParser.CSS_STRING, 0); }
		public TerminalNode DOT() { return getToken(TemplateParser.DOT, 0); }
		public TerminalNode SLASH() { return getToken(TemplateParser.SLASH, 0); }
		public TerminalNode COMMA() { return getToken(TemplateParser.COMMA, 0); }
		public CssValuePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValuePart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterCssValuePart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitCssValuePart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitCssValuePart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValuePartContext cssValuePart() throws RecognitionException {
		CssValuePartContext _localctx = new CssValuePartContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_cssValuePart);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 530055680L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001e\u00bb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0003\u00000\b\u0000\u0001"+
		"\u0000\u0005\u00003\b\u0000\n\u0000\f\u00006\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002A\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004J\b"+
		"\u0004\u0001\u0005\u0001\u0005\u0005\u0005N\b\u0005\n\u0005\f\u0005Q\t"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006X\b\u0006\n\u0006\f\u0006[\t\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0005\bg\b\b\n\b\f\bj\t\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0005\tr\b\t\n\t\f\tu\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0003\n|\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0081"+
		"\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0005\u000f\u008a\b\u000f\n\u000f\f\u000f\u008d\t\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u0092\b\u0010\n\u0010\f\u0010\u0095"+
		"\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005"+
		"\u0011\u009c\b\u0011\n\u0011\f\u0011\u009f\t\u0011\u0001\u0012\u0004\u0012"+
		"\u00a2\b\u0012\u000b\u0012\f\u0012\u00a3\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00ac\b\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00b2\b\u0014\u0001"+
		"\u0015\u0004\u0015\u00b5\b\u0015\u000b\u0015\f\u0015\u00b6\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0000\u0000\u0017\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,\u0000"+
		"\u0001\u0003\u0000\t\t\u0013\u0014\u0017\u001c\u00bb\u0000/\u0001\u0000"+
		"\u0000\u0000\u00029\u0001\u0000\u0000\u0000\u0004@\u0001\u0000\u0000\u0000"+
		"\u0006B\u0001\u0000\u0000\u0000\bI\u0001\u0000\u0000\u0000\nK\u0001\u0000"+
		"\u0000\u0000\fT\u0001\u0000\u0000\u0000\u000e^\u0001\u0000\u0000\u0000"+
		"\u0010c\u0001\u0000\u0000\u0000\u0012n\u0001\u0000\u0000\u0000\u0014x"+
		"\u0001\u0000\u0000\u0000\u0016\u0080\u0001\u0000\u0000\u0000\u0018\u0082"+
		"\u0001\u0000\u0000\u0000\u001a\u0084\u0001\u0000\u0000\u0000\u001c\u0086"+
		"\u0001\u0000\u0000\u0000\u001e\u008b\u0001\u0000\u0000\u0000 \u008e\u0001"+
		"\u0000\u0000\u0000\"\u0098\u0001\u0000\u0000\u0000$\u00a1\u0001\u0000"+
		"\u0000\u0000&\u00ab\u0001\u0000\u0000\u0000(\u00ad\u0001\u0000\u0000\u0000"+
		"*\u00b4\u0001\u0000\u0000\u0000,\u00b8\u0001\u0000\u0000\u0000.0\u0003"+
		"\u0002\u0001\u0000/.\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u0000"+
		"04\u0001\u0000\u0000\u000013\u0003\u0004\u0002\u000021\u0001\u0000\u0000"+
		"\u000036\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000"+
		"\u0000\u000057\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000078\u0005"+
		"\u0000\u0000\u00018\u0001\u0001\u0000\u0000\u00009:\u0005\u0001\u0000"+
		"\u0000:\u0003\u0001\u0000\u0000\u0000;A\u0003\u0006\u0003\u0000<A\u0003"+
		"\b\u0004\u0000=A\u0003\u0018\f\u0000>A\u0003\u001a\r\u0000?A\u0003\u001c"+
		"\u000e\u0000@;\u0001\u0000\u0000\u0000@<\u0001\u0000\u0000\u0000@=\u0001"+
		"\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@?\u0001\u0000\u0000\u0000"+
		"A\u0005\u0001\u0000\u0000\u0000BC\u0005\u0002\u0000\u0000CD\u0003\u001e"+
		"\u000f\u0000DE\u0005\u000e\u0000\u0000E\u0007\u0001\u0000\u0000\u0000"+
		"FJ\u0003\u0012\t\u0000GJ\u0003\u0010\b\u0000HJ\u0003\n\u0005\u0000IF\u0001"+
		"\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IH\u0001\u0000\u0000\u0000"+
		"J\t\u0001\u0000\u0000\u0000KO\u0003\f\u0006\u0000LN\u0003\u0004\u0002"+
		"\u0000ML\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000"+
		"\u0000\u0000OP\u0001\u0000\u0000\u0000PR\u0001\u0000\u0000\u0000QO\u0001"+
		"\u0000\u0000\u0000RS\u0003\u000e\u0007\u0000S\u000b\u0001\u0000\u0000"+
		"\u0000TU\u0005\u0005\u0000\u0000UY\u0005\u000b\u0000\u0000VX\u0003\u0014"+
		"\n\u0000WV\u0001\u0000\u0000\u0000X[\u0001\u0000\u0000\u0000YW\u0001\u0000"+
		"\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0001\u0000\u0000\u0000[Y\u0001"+
		"\u0000\u0000\u0000\\]\u0005\b\u0000\u0000]\r\u0001\u0000\u0000\u0000^"+
		"_\u0005\u0005\u0000\u0000_`\u0005\t\u0000\u0000`a\u0005\u000b\u0000\u0000"+
		"ab\u0005\b\u0000\u0000b\u000f\u0001\u0000\u0000\u0000cd\u0005\u0005\u0000"+
		"\u0000dh\u0005\u000b\u0000\u0000eg\u0003\u0014\n\u0000fe\u0001\u0000\u0000"+
		"\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000"+
		"\u0000\u0000ik\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000kl\u0005"+
		"\t\u0000\u0000lm\u0005\b\u0000\u0000m\u0011\u0001\u0000\u0000\u0000no"+
		"\u0005\u0005\u0000\u0000os\u0005\u000b\u0000\u0000pr\u0003\u0014\n\u0000"+
		"qp\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000"+
		"\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000\u0000\u0000us\u0001\u0000"+
		"\u0000\u0000vw\u0005\b\u0000\u0000w\u0013\u0001\u0000\u0000\u0000x{\u0005"+
		"\u000b\u0000\u0000yz\u0005\n\u0000\u0000z|\u0003\u0016\u000b\u0000{y\u0001"+
		"\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|\u0015\u0001\u0000\u0000"+
		"\u0000}\u0081\u0005\f\u0000\u0000~\u0081\u0003\u001a\r\u0000\u007f\u0081"+
		"\u0005\u000b\u0000\u0000\u0080}\u0001\u0000\u0000\u0000\u0080~\u0001\u0000"+
		"\u0000\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0017\u0001\u0000"+
		"\u0000\u0000\u0082\u0083\u0005\u0004\u0000\u0000\u0083\u0019\u0001\u0000"+
		"\u0000\u0000\u0084\u0085\u0005\u0003\u0000\u0000\u0085\u001b\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0005\u0006\u0000\u0000\u0087\u001d\u0001\u0000"+
		"\u0000\u0000\u0088\u008a\u0003 \u0010\u0000\u0089\u0088\u0001\u0000\u0000"+
		"\u0000\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u001f\u0001\u0000\u0000"+
		"\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u008f\u0003\"\u0011\u0000"+
		"\u008f\u0093\u0005\u000f\u0000\u0000\u0090\u0092\u0003(\u0014\u0000\u0091"+
		"\u0090\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000\u0000\u0000\u0093"+
		"\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094"+
		"\u0096\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0096"+
		"\u0097\u0005\u0010\u0000\u0000\u0097!\u0001\u0000\u0000\u0000\u0098\u009d"+
		"\u0003$\u0012\u0000\u0099\u009a\u0005\u0013\u0000\u0000\u009a\u009c\u0003"+
		"$\u0012\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u009f\u0001\u0000"+
		"\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000"+
		"\u0000\u0000\u009e#\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a2\u0003&\u0013\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4%\u0001\u0000\u0000\u0000\u00a5"+
		"\u00ac\u0005\u0017\u0000\u0000\u00a6\u00a7\u0005\u0014\u0000\u0000\u00a7"+
		"\u00ac\u0005\u0017\u0000\u0000\u00a8\u00a9\u0005\u0015\u0000\u0000\u00a9"+
		"\u00ac\u0005\u0017\u0000\u0000\u00aa\u00ac\u0005\u0016\u0000\u0000\u00ab"+
		"\u00a5\u0001\u0000\u0000\u0000\u00ab\u00a6\u0001\u0000\u0000\u0000\u00ab"+
		"\u00a8\u0001\u0000\u0000\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ac"+
		"\'\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0017\u0000\u0000\u00ae\u00af"+
		"\u0005\u0011\u0000\u0000\u00af\u00b1\u0003*\u0015\u0000\u00b0\u00b2\u0005"+
		"\u0012\u0000\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b2)\u0001\u0000\u0000\u0000\u00b3\u00b5\u0003,\u0016"+
		"\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b7+\u0001\u0000\u0000\u0000\u00b8\u00b9\u0007\u0000\u0000\u0000"+
		"\u00b9-\u0001\u0000\u0000\u0000\u0011/4@IOYhs{\u0080\u008b\u0093\u009d"+
		"\u00a3\u00ab\u00b1\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}