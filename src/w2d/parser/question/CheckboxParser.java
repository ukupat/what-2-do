package w2d.parser.question;

import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.log4j.Logger;
import w2d.antlr.gen.GrammarParser;
import w2d.question.Checkbox;

public class CheckboxParser extends QuestionParser {

	private final Logger log = Logger.getLogger(CheckboxParser.class);

	public void parse(ParseTree tree, String variableName) {
		String label = "";

		for (int i = 0; i < tree.getChildCount(); i ++) {
			if (tree.getChild(i) instanceof GrammarParser.LabelFieldContext) {
				label = parseLabel(tree.getChild(i));
			}
		}
		questions.put(variableName, new Checkbox(label));

		log.info("Added new checkbox to map: " + variableName + " => " + questions.get(variableName).label);
	}
}
