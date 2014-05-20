package w2d.parser;

import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.log4j.Logger;
import w2d.antlr.gen.GrammarParser;
import w2d.question.Checkbox;
import w2d.question.Question;

import java.util.HashMap;
import java.util.Map;

public class QuestionParser {

	private static final Logger log = Logger.getLogger(QuestionParser.class);

	public static Map<String, Question> questions = new HashMap<String, Question>();

	public static void parseQuestion(ParseTree tree) {
		String variableName = tree.getChild(0).getText();
		String label = "";
		ParseTree checkboxTree = tree.getChild(2);

		for (int i = 0; i < checkboxTree.getChildCount(); i ++) {
			if (checkboxTree.getChild(i) instanceof GrammarParser.LabelFieldContext) {
				label = parseLabel(checkboxTree.getChild(i));
			}
		}
		questions.put(variableName, new Checkbox(label));

		log.info("Added new question to map: " + variableName + " => " + questions.get(variableName).label);
	}

	private static String parseLabel(ParseTree tree) {
		for (int i = 0; i < tree.getChildCount(); i ++) {
			if (tree.getChild(i) instanceof GrammarParser.ObjectFieldValueContext) {
				log.info("Found question label: " + tree.getChild(i).getText());

				return tree.getChild(i).getText();
			}
		}
		return "";
	}
}
