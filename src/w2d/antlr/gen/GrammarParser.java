// Generated from /Users/ukupat/Development/University/AKT/Project/src/w2d/antlr/Grammar.g4 by ANTLR 4.x
package w2d.antlr.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, Assignment=7, KeyAndValueSeparator=8, 
		Variable=9, String=10, Documentation=11, Comment=12;
	public static final String[] tokenNames = {
		"<INVALID>", "'new Select {'", "'label'", "'\n'", "'#'", "'}'", "'new Checkbox {'", 
		"' = '", "': '", "Variable", "String", "Documentation", "Comment"
	};
	public static final int
		RULE_script = 0, RULE_sentences = 1, RULE_sentence = 2, RULE_question = 3, 
		RULE_questionVariable = 4, RULE_select = 5, RULE_checkbox = 6, RULE_fields = 7, 
		RULE_label = 8, RULE_customField = 9, RULE_fieldValue = 10;
	public static final String[] ruleNames = {
		"script", "sentences", "sentence", "question", "questionVariable", "select", 
		"checkbox", "fields", "label", "customField", "fieldValue"
	};

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ScriptContext extends ParserRuleContext {
		public SentencesContext sentences() {
			return getRuleContext(SentencesContext.class,0);
		}
		public ScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_script; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitScript(this);
		}
	}

	public final ScriptContext script() throws RecognitionException {
		ScriptContext _localctx = new ScriptContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_script);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22); sentences();
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

	public static class SentencesContext extends ParserRuleContext {
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public SentencesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentences; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSentences(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSentences(this);
		}
	}

	public final SentencesContext sentences() throws RecognitionException {
		SentencesContext _localctx = new SentencesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sentences);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24); sentence();
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(25); match(T__3);
				setState(26); sentence();
				}
				}
				setState(31);
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

	public static class SentenceContext extends ParserRuleContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSentence(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sentence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); question();
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

	public static class QuestionContext extends ParserRuleContext {
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
	 
		public QuestionContext() { }
		public void copyFrom(QuestionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QuestionSentenceContext extends QuestionContext {
		public QuestionVariableContext questionVariable() {
			return getRuleContext(QuestionVariableContext.class,0);
		}
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public TerminalNode Assignment() { return getToken(GrammarParser.Assignment, 0); }
		public CheckboxContext checkbox() {
			return getRuleContext(CheckboxContext.class,0);
		}
		public QuestionSentenceContext(QuestionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterQuestionSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitQuestionSentence(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_question);
		try {
			setState(42);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new QuestionSentenceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(34); questionVariable();
				setState(35); match(Assignment);
				setState(36); select();
				}
				break;
			case 2:
				_localctx = new QuestionSentenceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(38); questionVariable();
				setState(39); match(Assignment);
				setState(40); checkbox();
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

	public static class QuestionVariableContext extends ParserRuleContext {
		public QuestionVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionVariable; }
	 
		public QuestionVariableContext() { }
		public void copyFrom(QuestionVariableContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QuestionVariableNameContext extends QuestionVariableContext {
		public TerminalNode Variable() { return getToken(GrammarParser.Variable, 0); }
		public QuestionVariableNameContext(QuestionVariableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterQuestionVariableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitQuestionVariableName(this);
		}
	}

	public final QuestionVariableContext questionVariable() throws RecognitionException {
		QuestionVariableContext _localctx = new QuestionVariableContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_questionVariable);
		try {
			_localctx = new QuestionVariableNameContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(44); match(T__2);
			setState(45); match(Variable);
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

	public static class SelectContext extends ParserRuleContext {
		public SelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select; }
	 
		public SelectContext() { }
		public void copyFrom(SelectContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SelectQuestionContext extends SelectContext {
		public FieldsContext fields() {
			return getRuleContext(FieldsContext.class,0);
		}
		public SelectQuestionContext(SelectContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSelectQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSelectQuestion(this);
		}
	}

	public final SelectContext select() throws RecognitionException {
		SelectContext _localctx = new SelectContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_select);
		try {
			_localctx = new SelectQuestionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(47); match(T__5);
			setState(48); fields();
			setState(49); match(T__1);
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

	public static class CheckboxContext extends ParserRuleContext {
		public CheckboxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_checkbox; }
	 
		public CheckboxContext() { }
		public void copyFrom(CheckboxContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CheckboxQuestionContext extends CheckboxContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public CheckboxQuestionContext(CheckboxContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCheckboxQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCheckboxQuestion(this);
		}
	}

	public final CheckboxContext checkbox() throws RecognitionException {
		CheckboxContext _localctx = new CheckboxContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_checkbox);
		try {
			_localctx = new CheckboxQuestionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(51); match(T__0);
			setState(52); label();
			setState(53); match(T__1);
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

	public static class FieldsContext extends ParserRuleContext {
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public CustomFieldContext customField() {
			return getRuleContext(CustomFieldContext.class,0);
		}
		public FieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fields; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFields(this);
		}
	}

	public final FieldsContext fields() throws RecognitionException {
		FieldsContext _localctx = new FieldsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fields);
		try {
			setState(57);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(55); label();
				}
				break;
			case Variable:
				enterOuterAlt(_localctx, 2);
				{
				setState(56); customField();
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

	public static class LabelContext extends ParserRuleContext {
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
	 
		public LabelContext() { }
		public void copyFrom(LabelContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LabelFieldContext extends LabelContext {
		public TerminalNode KeyAndValueSeparator() { return getToken(GrammarParser.KeyAndValueSeparator, 0); }
		public FieldValueContext fieldValue() {
			return getRuleContext(FieldValueContext.class,0);
		}
		public LabelFieldContext(LabelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterLabelField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitLabelField(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_label);
		try {
			_localctx = new LabelFieldContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(59); match(T__4);
			setState(60); match(KeyAndValueSeparator);
			setState(61); fieldValue();
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

	public static class CustomFieldContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(GrammarParser.String, 0); }
		public TerminalNode KeyAndValueSeparator() { return getToken(GrammarParser.KeyAndValueSeparator, 0); }
		public TerminalNode Variable() { return getToken(GrammarParser.Variable, 0); }
		public CustomFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_customField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCustomField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCustomField(this);
		}
	}

	public final CustomFieldContext customField() throws RecognitionException {
		CustomFieldContext _localctx = new CustomFieldContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_customField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63); match(Variable);
			setState(64); match(KeyAndValueSeparator);
			setState(65); match(String);
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

	public static class FieldValueContext extends ParserRuleContext {
		public FieldValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldValue; }
	 
		public FieldValueContext() { }
		public void copyFrom(FieldValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ObjectFieldValueContext extends FieldValueContext {
		public TerminalNode String() { return getToken(GrammarParser.String, 0); }
		public ObjectFieldValueContext(FieldValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterObjectFieldValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitObjectFieldValue(this);
		}
	}

	public final FieldValueContext fieldValue() throws RecognitionException {
		FieldValueContext _localctx = new FieldValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_fieldValue);
		try {
			_localctx = new ObjectFieldValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(67); match(String);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16H\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\3\3\3\3\3\3\7\3\36\n\3\f\3\16\3!\13\3\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5-\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\5\t<\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\2?\2\30\3\2\2\2\4\32\3\2\2\2\6\""+
		"\3\2\2\2\b,\3\2\2\2\n.\3\2\2\2\f\61\3\2\2\2\16\65\3\2\2\2\20;\3\2\2\2"+
		"\22=\3\2\2\2\24A\3\2\2\2\26E\3\2\2\2\30\31\5\4\3\2\31\3\3\2\2\2\32\37"+
		"\5\6\4\2\33\34\7\5\2\2\34\36\5\6\4\2\35\33\3\2\2\2\36!\3\2\2\2\37\35\3"+
		"\2\2\2\37 \3\2\2\2 \5\3\2\2\2!\37\3\2\2\2\"#\5\b\5\2#\7\3\2\2\2$%\5\n"+
		"\6\2%&\7\t\2\2&\'\5\f\7\2\'-\3\2\2\2()\5\n\6\2)*\7\t\2\2*+\5\16\b\2+-"+
		"\3\2\2\2,$\3\2\2\2,(\3\2\2\2-\t\3\2\2\2./\7\6\2\2/\60\7\13\2\2\60\13\3"+
		"\2\2\2\61\62\7\3\2\2\62\63\5\20\t\2\63\64\7\7\2\2\64\r\3\2\2\2\65\66\7"+
		"\b\2\2\66\67\5\22\n\2\678\7\7\2\28\17\3\2\2\29<\5\22\n\2:<\5\24\13\2;"+
		"9\3\2\2\2;:\3\2\2\2<\21\3\2\2\2=>\7\4\2\2>?\7\n\2\2?@\5\26\f\2@\23\3\2"+
		"\2\2AB\7\13\2\2BC\7\n\2\2CD\7\f\2\2D\25\3\2\2\2EF\7\f\2\2F\27\3\2\2\2"+
		"\5\37,;";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}