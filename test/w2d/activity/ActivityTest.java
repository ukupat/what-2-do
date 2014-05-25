package w2d.activity;

import org.junit.Before;
import org.junit.Test;
import w2d.antlr.ExceptionErrorStrategy;
import w2d.parser.W2D;
import w2d.parser.activity.ActivityParser;
import w2d.question.Question;
import w2d.rule.Rule;
import w2d.rule.StatementGroup;

import java.util.Map;

import static org.junit.Assert.*;

public class ActivityTest {

	@Before
	public void cleanErrors() {
		ExceptionErrorStrategy.cleanErrors();
		W2D.resetParsers();
	}

	@Test
	public void activityWithRulesAndCustomFields() {
		new W2D(
			getQuestionString() + getRuleString()
			+ "@a = new Activity {title: \"CS\", rules: {$cTrue: true}, hello: \"world\"};"
		).readTheScript();

		assertEquals(1, ActivityParser.activities.size());
		assertNotNull(ActivityParser.activities.get("@a"));

		Activity activity = ActivityParser.activities.get("@a");

		checkTitle(activity);
		checkCustomFields(activity);
		checkRules(activity);
	}

	@Test
	public void activityShowValue() {
		new W2D(
			getQuestionString() + getRuleString() + "@a = new Activity {title: \"CS\", rules: {$cTrue: true}};"
		).readTheScript();

		Activity activity = ActivityParser.activities.get("@a");

		answerTheQuestion(activity, "true");
		activity.setShowStatus();

		assertTrue(activity.show);

		answerTheQuestion(activity, "false");
		activity.setShowStatus();

		assertFalse(activity.show);
	}

	@Test
	public void activityWithoutTitle() {
		new W2D(getQuestionString() + getRuleString() + "@a = new Activity {};").readTheScript();

		assertFalse(ExceptionErrorStrategy.errors.isEmpty());
	}

	private void checkTitle(Activity activity) {
		assertEquals("CS", activity.title);
	}

	private void checkCustomFields(Activity activity) {
		assertEquals(1, activity.fields.size());

		for (Map.Entry<String, String> field : activity.fields.entrySet()) {
			assertEquals("hello", field.getKey());
			assertEquals("world", field.getValue());
		}
	}

	private void checkRules(Activity activity) {
		assertEquals(1, activity.rules.size());

		for (Map.Entry<Rule, Boolean> field : activity.rules.entrySet()) {
			assertTrue(field.getValue());
		}
	}

	private String getQuestionString() {
		return "#c = new Checkbox {label:\"You cool?\"};";
	}

	private String getRuleString() {
		return "$cTrue = new Rule {true: #c is true};";
	}

	private void answerTheQuestion(Activity activity, String answer) {
		Rule rule = null;

		for (Map.Entry<Rule, Boolean> field : activity.rules.entrySet()) {
			rule = field.getKey();
		}
		Question question = null;

		for (Map.Entry<StatementGroup, Boolean> group : rule.statementGroups.entrySet()) {
			question = group.getKey().statements.get(0).leftSide;
		}
		question.answer = answer;

		rule.setSatisfied();
	}
}
