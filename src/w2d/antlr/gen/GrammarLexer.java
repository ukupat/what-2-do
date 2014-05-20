// Generated from /Users/ukupat/Development/University/AKT/Project/src/w2d/antlr/Grammar.g4 by ANTLR 4.x
package w2d.antlr.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, Assignment=7, KeyAndValueSeparator=8, 
		Variable=9, String=10, Documentation=11, Comment=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'"
	};
	public static final String[] ruleNames = {
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "Assignment", "KeyAndValueSeparator", 
		"Variable", "String", "Documentation", "Comment"
	};


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16v\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\n\3\n\7\nM\n\n\f\n\16\nP\13\n\3\13\3\13\7\13T\n\13\f\13\16\13W\13\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\7\f_\n\f\f\f\16\fb\13\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\7\rm\n\r\f\r\16\rp\13\r\3\r\3\r\3\r\3\r\3\r\4`n\2\16"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\5\4\2C\\"+
		"c|\6\2\62;C\\aac|\5\2\f\f\17\17$$y\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5(\3\2\2\2"+
		"\7.\3\2\2\2\t\60\3\2\2\2\13\62\3\2\2\2\r\64\3\2\2\2\17C\3\2\2\2\21G\3"+
		"\2\2\2\23J\3\2\2\2\25Q\3\2\2\2\27Z\3\2\2\2\31h\3\2\2\2\33\34\7p\2\2\34"+
		"\35\7g\2\2\35\36\7y\2\2\36\37\7\"\2\2\37 \7U\2\2 !\7g\2\2!\"\7n\2\2\""+
		"#\7g\2\2#$\7e\2\2$%\7v\2\2%&\7\"\2\2&\'\7}\2\2\'\4\3\2\2\2()\7n\2\2)*"+
		"\7c\2\2*+\7d\2\2+,\7g\2\2,-\7n\2\2-\6\3\2\2\2./\7\f\2\2/\b\3\2\2\2\60"+
		"\61\7%\2\2\61\n\3\2\2\2\62\63\7\177\2\2\63\f\3\2\2\2\64\65\7p\2\2\65\66"+
		"\7g\2\2\66\67\7y\2\2\678\7\"\2\289\7E\2\29:\7j\2\2:;\7g\2\2;<\7e\2\2<"+
		"=\7m\2\2=>\7d\2\2>?\7q\2\2?@\7z\2\2@A\7\"\2\2AB\7}\2\2B\16\3\2\2\2CD\7"+
		"\"\2\2DE\7?\2\2EF\7\"\2\2F\20\3\2\2\2GH\7<\2\2HI\7\"\2\2I\22\3\2\2\2J"+
		"N\t\2\2\2KM\t\3\2\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\24\3\2\2"+
		"\2PN\3\2\2\2QU\7$\2\2RT\n\4\2\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2"+
		"\2VX\3\2\2\2WU\3\2\2\2XY\7$\2\2Y\26\3\2\2\2Z[\7\61\2\2[\\\7,\2\2\\`\3"+
		"\2\2\2]_\13\2\2\2^]\3\2\2\2_b\3\2\2\2`a\3\2\2\2`^\3\2\2\2ac\3\2\2\2b`"+
		"\3\2\2\2cd\7,\2\2de\7\61\2\2ef\3\2\2\2fg\b\f\2\2g\30\3\2\2\2hi\7\61\2"+
		"\2ij\7\61\2\2jn\3\2\2\2km\13\2\2\2lk\3\2\2\2mp\3\2\2\2no\3\2\2\2nl\3\2"+
		"\2\2oq\3\2\2\2pn\3\2\2\2qr\7\61\2\2rs\7p\2\2st\3\2\2\2tu\b\r\2\2u\32\3"+
		"\2\2\2\7\2NU`n\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}