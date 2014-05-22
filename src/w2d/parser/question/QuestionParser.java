package w2d.parser.question;

import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.log4j.Logger;
import w2d.antlr.gen.GrammarParser;
import w2d.question.Question;

import java.util.HashMap;
import java.util.Map;

public class QuestionParser {

	private final Logger log = Logger.getLogger(QuestionParser.class);

	public static Map<String, Question> questions = new HashMap<String, Question>();

	public void parse(ParseTree tree) {
		String variableName = parseVariableName(tree);
		ParseTree question = tree.getChild(2);

		if (question instanceof GrammarParser.CheckboxQuestionContext) {
			new CheckboxParser().parse(question, variableName);
		} else if (question instanceof GrammarParser.SelectQuestionContext) {
			// TODO select question
		}
	}

	private String parseVariableName(ParseTree tree) {
		return tree.getChild(0).getText();
	}

	protected String parseLabel(ParseTree tree) {
		for (int i = 0; i < tree.getChildCount(); i ++) {
			if (tree.getChild(i) instanceof GrammarParser.ObjectFieldValueContext) {
				log.info("Found question label: " + tree.getChild(i).getText());

				return tree.getChild(i).getText();
			}
		}
		return "";
	}
}
