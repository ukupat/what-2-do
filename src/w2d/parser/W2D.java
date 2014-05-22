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
import w2d.parser.activity.ActivityParser;
import w2d.parser.question.QuestionParser;
import w2d.parser.rule.RuleParser;
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
		parseTreeToObjects(tree);

		if (!ExceptionErrorStrategy.errors.isEmpty()) {
			Gui.showErrors(ExceptionErrorStrategy.errors);
			ExceptionErrorStrategy.cleanErrors();
		} else {
			Gui.showQuestions(new ArrayList<Question>(QuestionParser.questions.values()));
		}
	}

	private ParseTree createParseTree() throws RecognitionException {
		ANTLRInputStream input = new ANTLRInputStream(script);
		GrammarLexer lexer = new GrammarLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);
		GrammarParser parser = new GrammarParser(tokens);

		parser.setErrorHandler(new ExceptionErrorStrategy());

		ParseTree tree = parser.sentences();

		return tree;
	}

	private void parseTreeToObjects(ParseTree tree) {
		for (int i = 0; i < tree.getChildCount(); i ++) {
			if (tree.getChild(i) instanceof GrammarParser.SentenceContext) {
				ParseTree sentenceTree = tree.getChild(i).getChild(0);

				if (sentenceTree instanceof GrammarParser.QuestionSentenceContext) {
					log.info("Tree parser found Question sentence: " + sentenceTree.getText());

					new QuestionParser().parse(sentenceTree);
				} else if (sentenceTree instanceof GrammarParser.RuleSentenceContext) {
					log.info("Tree parser found Rule sentence: " + sentenceTree.getText());

					new RuleParser().parse(sentenceTree);
				} else if (sentenceTree instanceof GrammarParser.ActivitySentenceContext) {
					log.info("Tree parser found Activity sentence: " + sentenceTree.getText());

					new ActivityParser().parse(sentenceTree);
				}
			}
		}
	}
}
