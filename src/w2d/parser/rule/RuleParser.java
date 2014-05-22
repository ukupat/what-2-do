package w2d.parser.rule;

import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.log4j.Logger;
import w2d.rule.Rule;

import java.util.HashMap;
import java.util.Map;

public class RuleParser {

	private final Logger log = Logger.getLogger(RuleParser.class);

	public static Map<String, Rule> rules = new HashMap<String, Rule>();

	public void parse(ParseTree tree) {
		String variableName = parseVariableName(tree);

		// TODO

		rules.put(variableName, new Rule());
	}

	private String parseVariableName(ParseTree tree) {
		return tree.getChild(0).getText();
	}
}
