package w2d.parser.rule;

import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.log4j.Logger;
import w2d.antlr.ExceptionErrorStrategy;
import w2d.antlr.gen.GrammarParser;
import w2d.parser.question.QuestionParser;
import w2d.rule.IfStatement;
import w2d.rule.Rule;
import w2d.rule.StatementGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleParser {

	private final Logger log = Logger.getLogger(RuleParser.class);

	public static Map<String, Rule> rules = new HashMap<String, Rule>();

	private String variableName;

	public void parse(ParseTree tree) {
		variableName = parseVariableName(tree);

		Map<StatementGroup, Boolean> statementGroups = parseStatementGroups(tree.getChild(4));

		rules.put(variableName, new Rule(statementGroups));
	}

	private String parseVariableName(ParseTree tree) {
		return tree.getChild(0).getText();
	}

	private Map<StatementGroup, Boolean> parseStatementGroups(ParseTree tree) {
		Map<StatementGroup, Boolean> statementGroups =  new HashMap<StatementGroup, Boolean>();

		for (int i = 0; i < tree.getChildCount(); i ++) {
			if (tree.getChild(i) instanceof GrammarParser.StatementFieldContext) {
				statementGroups.put(parseStatementGroup(tree.getChild(i).getChild(2)), parseBoolean(tree.getChild(i)));
			}
		}
		return statementGroups;
	}

	private Boolean parseBoolean(ParseTree tree) {
		return Boolean.valueOf(tree.getChild(0).getText());
	}

	private StatementGroup parseStatementGroup(ParseTree tree) {
		List<IfStatement> statements = new ArrayList<IfStatement>();

		for (int i = 0; i < tree.getChildCount(); i ++) {
			if (tree.getChild(i) instanceof GrammarParser.ExpressionFieldContext) {
				statements.add(parseIfStatement(tree.getChild(i)));
			}
		}
		return new StatementGroup(statements);
	}

	private IfStatement parseIfStatement(ParseTree tree) {
		String questionVariable = tree.getChild(0).getText();

		if (!QuestionParser.questions.containsKey(questionVariable)) {
			ExceptionErrorStrategy.errors.add("Missing rule '" + questionVariable + "' in '" + variableName + "' Rule");
			return new IfStatement();
		}
		Boolean mustEqual = tree.getChild(1).getText().equals("is");

		return new IfStatement(QuestionParser.questions.get(questionVariable), tree.getChild(2).getText(), mustEqual);
	}
}
