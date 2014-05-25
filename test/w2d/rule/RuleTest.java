package w2d.rule;

import org.junit.Before;
import org.junit.Test;
import w2d.antlr.ExceptionErrorStrategy;
import w2d.parser.W2D;
import w2d.parser.rule.RuleParser;
import w2d.question.Question;

import java.util.Map;

import static org.junit.Assert.*;

public class RuleTest {

	@Before
	public void cleanErrors() {
		ExceptionErrorStrategy.cleanErrors();
		W2D.resetParsers();
	}

	@Test
	public void oneLineRuleWithOneTrueStatement() {
		new W2D(getCheckboxString() + "$cTrue = new Rule {true: #c is true};").readTheScript();

		assertEquals(1, RuleParser.rules.size());
		assertNotNull(RuleParser.rules.get("$cTrue"));

		for (Map.Entry<StatementGroup, Boolean> group : RuleParser.rules.get("$cTrue").statementGroups.entrySet()) {
			assertEquals("You cool?", group.getKey().statements.get(0).leftSide.label);
			assertTrue(group.getKey().statements.get(0).mustEqual);
			assertEquals("true", group.getKey().statements.get(0).rightSide);
		}
	}

	@Test
	public void isNotSentence() {
		new W2D(getCheckboxString() + "$cTrue = new Rule {true: #c is not true};").readTheScript();

		for (Map.Entry<StatementGroup, Boolean> group : RuleParser.rules.get("$cTrue").statementGroups.entrySet()) {
			assertFalse(group.getKey().statements.get(0).mustEqual);
		}
	}

	@Test
	public void andSentence() {
		new W2D(getCheckboxString() + "$cTrue = new Rule {true: #c is true and #c is false};").readTheScript();

		for (Map.Entry<StatementGroup, Boolean> group : RuleParser.rules.get("$cTrue").statementGroups.entrySet()) {
			assertEquals(2, group.getKey().statements.size());
		}
	}

	@Test
	public void multipleStatements() {
		new W2D(getCheckboxString() + "$cTrue = new Rule {true: #c is true, false: #c is false};").readTheScript();

		assertEquals(2, RuleParser.rules.get("$cTrue").statementGroups.size());
	}

	@Test
	public void ruleWithMissingQuestion() {
		new W2D("$cTrue = new Rule {true: #c is true};").readTheScript();

		assertFalse(ExceptionErrorStrategy.errors.isEmpty());
	}

	@Test
	public void ruleWithoutContent() {
		new W2D(getCheckboxString() + "$cTrue = new Rule {};").readTheScript();

		assertFalse(ExceptionErrorStrategy.errors.isEmpty());
	}

	@Test
	public void ruleSatisfiedValueWithoutAnswer() {
		new W2D(getCheckboxString() + "$cTrue = new Rule {true: #c is true};").readTheScript();

		assertNull(RuleParser.rules.get("$cTrue").satisfied);
	}

	@Test
	public void ruleSatisfiedValueWithAnswer() {
		new W2D(getCheckboxString() + "$cTrue = new Rule {true: #c is true};").readTheScript();

		Question question = getQuestionFromRule();

		question.answer = "true";
		RuleParser.rules.get("$cTrue").setSatisfied();

		assertTrue(RuleParser.rules.get("$cTrue").satisfied);

		question.answer = "false";
		RuleParser.rules.get("$cTrue").setSatisfied();

		assertNull(RuleParser.rules.get("$cTrue").satisfied);
	}

	@Test
	public void multiLineRuleSatisfiedValueWithAnswer() {
		new W2D(getCheckboxString() + "$cTrue = new Rule {true: #c is true, false: #c is not true};").readTheScript();

		Question question = getQuestionFromRule();

		question.answer = "true";
		RuleParser.rules.get("$cTrue").setSatisfied();

		assertTrue(RuleParser.rules.get("$cTrue").satisfied);

		question.answer = "false";
		RuleParser.rules.get("$cTrue").setSatisfied();

		assertFalse(RuleParser.rules.get("$cTrue").satisfied);
	}

	private String getCheckboxString() {
		return "#c = new Checkbox {label:\"You cool?\"};";
	}

	private Question getQuestionFromRule() {
		Question question = null;

		for (Map.Entry<StatementGroup, Boolean> group : RuleParser.rules.get("$cTrue").statementGroups.entrySet()) {
			question = group.getKey().statements.get(0).leftSide;
		}
		return question;
	}
}
