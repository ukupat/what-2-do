package w2d.parser.activity;

import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.log4j.Logger;
import w2d.activity.Activity;
import w2d.antlr.ExceptionErrorStrategy;
import w2d.antlr.gen.GrammarParser;
import w2d.parser.rule.RuleParser;
import w2d.rule.Rule;

import java.util.HashMap;
import java.util.Map;

public class ActivityParser {

	private final Logger log = Logger.getLogger(ActivityParser.class);

	public static Map<String, Activity> activities = new HashMap<String, Activity>();

	private String variableName;

	public void parse(ParseTree tree) {
		variableName = parseVariableName(tree);

		ParseTree activity = tree.getChild(4);

		String title = getTitle(activity);
		Map<Rule, Boolean> rules = getRules(activity);
		Map<String, String> fields = getFields(activity);

		activities.put(variableName, new Activity(title, rules, fields));
	}

	private String parseVariableName(ParseTree tree) {
		return tree.getChild(0).getText();
	}

	private String getTitle(ParseTree tree) {
		String title = "";

		for (int i = 0; i < tree.getChildCount(); i ++) {
			if (tree.getChild(i) instanceof GrammarParser.ActivityTitleFieldContext) {
				title = parseTitle(tree.getChild(i));
			}
		}
		log.info("Activity has title '" + title + "'");

		return title;
	}

	private String parseTitle(ParseTree tree) {
		return tree.getChild(2).getText();
	}

	private Map<Rule, Boolean> getRules(ParseTree tree) {
		Map<Rule, Boolean> rules = new HashMap<Rule, Boolean>();

		for (int i = 0; i < tree.getChildCount(); i ++) {
			if (tree.getChild(i) instanceof GrammarParser.ActivityRulesFieldContext) {
				rules = parseRules(tree.getChild(i));

			}
		}
		return rules;
	}

	private Map<Rule, Boolean> parseRules(ParseTree tree) {
		Map<Rule, Boolean> rules = new HashMap<Rule, Boolean>();

		for (int i = 0; i < tree.getChildCount(); i ++) {
			if (tree.getChild(i) instanceof GrammarParser.ActivityRuleContext) {
				if (tree.getChild(i).getChildCount() != 0) {
					rules.put(getRule(tree.getChild(i)), getRuleBoolean(tree.getChild(i)));
				}
			}
		}
		return rules;
	}

	private Rule getRule(ParseTree tree) {
		String ruleVariable = tree.getChild(0).getText();

		if (!RuleParser.rules.containsKey(ruleVariable)) {
			ExceptionErrorStrategy.errors.add("Missing rule '" + ruleVariable + "' in '" + variableName + "' Activity");
			return new Rule();
		}
		return RuleParser.rules.get(ruleVariable);
	}

	private Boolean getRuleBoolean(ParseTree tree) {
		return Boolean.valueOf(tree.getChild(2).getText());
	}

	private Map<String, String> getFields(ParseTree tree) {
		Map<String, String> customFields = new HashMap<String, String>();

		for (int i = 0; i < tree.getChildCount(); i ++) {
			if (tree.getChild(i) instanceof GrammarParser.ActivityCustomFieldContext) {
				customFields.put(parseFieldKey(tree.getChild(i)), parseFieldValue(tree.getChild(i)));
			}
		}
		return customFields;
	}

	private String parseFieldKey(ParseTree tree) {
		return tree.getChild(0).getText();
	}

	private String parseFieldValue(ParseTree tree) {
		return tree.getChild(2).getText().replaceAll("\"", "");
	}
}
