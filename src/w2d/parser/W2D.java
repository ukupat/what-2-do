package w2d.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.log4j.Logger;
import w2d.antlr.gen.GrammarLexer;
import w2d.antlr.gen.GrammarParser;

public class W2D {

	private final Logger log = Logger.getLogger(W2D.class);

	private String script;

	public W2D(String script) {
		this.script = script;
	}

	public void readTheScript() {
		ParseTree tree = createParseTree();
		parseTreeToObjects(tree);
	}

	private ParseTree createParseTree() {
		ANTLRInputStream input = new ANTLRInputStream(script);
		GrammarLexer lexer = new GrammarLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokens);

		ParseTree tree = parser.question();

		return tree;
	}

	private void parseTreeToObjects(ParseTree tree) {
		if (tree instanceof GrammarParser.QuestionSentenceContext) {
			log.info("Found question sentence: " + tree.getText());

			QuestionParser.parseQuestion(tree);
		} else {
			parseTreeToObjects(tree.getChild(0));
			return;
		}
	}
}
