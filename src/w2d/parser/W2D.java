package w2d.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.log4j.Logger;
import w2d.activity.Activity;
import w2d.antlr.ExceptionErrorStrategy;
import w2d.antlr.gen.GrammarLexer;
import w2d.antlr.gen.GrammarParser;
import w2d.parser.activity.ActivityParser;
import w2d.parser.question.QuestionParser;
import w2d.parser.rule.RuleParser;
import w2d.question.Question;
import w2d.rule.Rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class W2D {

	private final Logger log = Logger.getLogger(W2D.class);

	private String script;

	public W2D(String script) {
		this.script = script;
	}

	public void readTheScript() {
		ParseTree tree = createParseTree();

		if (ExceptionErrorStrategy.errors.isEmpty()) {
			parseTreeToObjects(tree);
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

	public List<String> getParsingErrors() {
		List<String> errors = ExceptionErrorStrategy.errors;
		ExceptionErrorStrategy.cleanErrors();

		return errors;
	}

	public List<Question> getQuestions() {
		return new ArrayList<Question>(QuestionParser.questions.values());
	}

	public List<Activity> getActivitiesToShow() {
		checkRules();
		return filterActivities();
	}

	private void checkRules() {
		log.info("Checking rules");

		for (Map.Entry<String, Rule> el : RuleParser.rules.entrySet()) {
			el.getValue().setSatisfied();

			log.info("Rule " + el.getKey() + " is " + el.getValue().satisfied);
		}
	}

	private List<Activity> filterActivities() {
		List<Activity> activities = new ArrayList<Activity>();

		for (Map.Entry<String, Activity> el : ActivityParser.activities.entrySet()) {
			if (activityRulesAreSatisfied(el.getValue())) {
				activities.add(el.getValue());
			}
		}
		return activities;
	}

	private Boolean activityRulesAreSatisfied(Activity activity) {
		for (Map.Entry<Rule, Boolean> el : activity.rules.entrySet()) {
			if (el.getKey().satisfied != el.getValue()) {
				return false;
			}
		}
		return true;
	}

	public static void resetParsers() {
		QuestionParser.questions = new HashMap<String, Question>();
		RuleParser.rules = new HashMap<String, Rule>();
		ActivityParser.activities = new HashMap<String, Activity>();
	}
}
