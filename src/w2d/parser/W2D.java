package w2d.parser;

import gui.Gui;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.log4j.Logger;
import w2d.antlr.ExceptionErrorStrategy;
import w2d.antlr.gen.GrammarLexer;
import w2d.antlr.gen.GrammarParser;
import w2d.parser.question.QuestionParser;
import w2d.question.Question;

import java.util.ArrayList;

public class W2D {

	private final Logger log = Logger.getLogger(W2D.class);

	private String script;

	public W2D(String script) {
		this.script = script;
	}

	public void readTheScript() {
		ParseTree tree = createParseTree();

		if (!ExceptionErrorStrategy.errors.isEmpty()) {
			Gui.showErrors(ExceptionErrorStrategy.errors);

			ExceptionErrorStrategy.cleanErrors();
		} else {
			parseTreeToObjects(tree);

			Gui.showQuestions(new ArrayList<Question>(QuestionParser.questions.values()));
		}
	}

	private ParseTree createParseTree() throws RecognitionException {
		ANTLRInputStream input = new ANTLRInputStream(script);
		GrammarLexer lexer = new GrammarLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokens);

		parser.setErrorHandler(new ExceptionErrorStrategy());

		ParseTree tree = parser.script();

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
