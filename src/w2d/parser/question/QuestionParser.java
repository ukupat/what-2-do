package w2d.parser.question;

import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.log4j.Logger;
import w2d.antlr.gen.GrammarParser;
import w2d.question.Question;

import java.util.HashMap;
import java.util.Map;

public class QuestionParser {

	private static final Logger log = Logger.getLogger(QuestionParser.class);

	public static Map<String, Question> questions = new HashMap<String, Question>();

	public static void parseQuestion(ParseTree tree) {
		String variableName = parseVariableName(tree);
		ParseTree question = tree.getChild(2);

		if (question instanceof GrammarParser.CheckboxQuestionContext) {
			CheckboxParser.parse(question, variableName);
		} else if (question instanceof GrammarParser.SelectQuestionContext) {
		}
	}

	private static String parseVariableName(ParseTree tree) {
		return tree.getChild(0).getText();
	}

	protected static String parseLabel(ParseTree tree) {
		for (int i = 0; i < tree.getChildCount(); i ++) {
			if (tree.getChild(i) instanceof GrammarParser.ObjectFieldValueContext) {
				log.info("Found question label: " + tree.getChild(i).getText());

				return tree.getChild(i).getText();
			}
		}
		return ""; // TODO what happens when label not found
	}
}
