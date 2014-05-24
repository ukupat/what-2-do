package w2d.parser.question;

import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.log4j.Logger;
import w2d.antlr.gen.GrammarParser;
import w2d.question.Select;

import java.util.ArrayList;
import java.util.List;

public class SelectParser extends QuestionParser {

	private final Logger log = Logger.getLogger(CheckboxParser.class);

	public void parse(ParseTree tree, String variableName) {
		String label = "";
		List<String> options = new ArrayList<String>();
		ParseTree selectFields = tree.getChild(2);

		for (int i = 0; i < selectFields.getChildCount(); i ++) {
			if (selectFields.getChild(i) instanceof GrammarParser.LabelFieldContext) {
				label = parseLabel(selectFields.getChild(i));
			} else if (selectFields.getChild(i) instanceof GrammarParser.OptionsFieldContext) {
				options = parseOptions(selectFields.getChild(i));
			}
		}
		questions.put(variableName, new Select(label, options));

		log.info("Added new select to map: " + variableName + " => " + questions.get(variableName).label);
	}

	private List<String> parseOptions(ParseTree tree) {
		List<String> options = new ArrayList<String>();

		for (int i = 0; i < tree.getChildCount(); i ++) {
			if (tree.getChild(i) instanceof GrammarParser.OptionFieldContext) {
				options.add(tree.getChild(i).getText().replace("\"", ""));
			}
		}
		return options;
	}
}
