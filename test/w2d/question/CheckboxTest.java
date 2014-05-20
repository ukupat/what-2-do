package w2d.question;

import org.junit.Test;
import w2d.parser.W2D;
import w2d.parser.question.QuestionParser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CheckboxTest {

	@Test
	public void oneLineCheckbox() {
		new W2D("#c = new Checkbox {label:\"You cool?\"}").readTheScript();

		assertEquals(1, QuestionParser.questions.size());
		assertNotNull(QuestionParser.questions.get("#c"));
		assertEquals("You cool?", QuestionParser.questions.get("#c").label);
	}
}
