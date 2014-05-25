package w2d.question;

import org.junit.Before;
import org.junit.Test;
import w2d.antlr.ExceptionErrorStrategy;
import w2d.parser.W2D;
import w2d.parser.question.QuestionParser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class SelectTest {

	@Before
	public void cleanErrors() {
		ExceptionErrorStrategy.cleanErrors();
		W2D.resetParsers();
	}

	@Test
	public void simpleSelectDeclaration() {
		new W2D("#c = new Select {label:\"You cool?\", options: {\"No\", \"Maybe\"}};").readTheScript();

		checkParsedData();
	}

	@Test
	public void optionsBeforeLabel() {
		new W2D("#c = new Select {options: {\"No\", \"Maybe\"}, label:\"You cool?\"};").readTheScript();

		checkParsedData();
	}

	@Test
	public void withoutOptions() {
		new W2D("#c = new Select {label:\"You cool?\"};").readTheScript();

		assertFalse(ExceptionErrorStrategy.errors.isEmpty());
	}

	@Test
	public void withoutLabel() {
		new W2D("#c = new Select {options: {\"No\", \"Maybe\"}};").readTheScript();

		assertFalse(ExceptionErrorStrategy.errors.isEmpty());
	}

	private void checkParsedData() {
		assertEquals(1, QuestionParser.questions.size());
		assertNotNull(QuestionParser.questions.get("#c"));

		Select select = (Select) QuestionParser.questions.get("#c");

		assertEquals("You cool?", select.label);
		assertFalse(select.options.isEmpty());
		assertEquals("No", select.options.get(0));
		assertEquals("Maybe", select.options.get(1));
	}
}
