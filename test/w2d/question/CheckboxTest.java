package test.w2d.question;

import org.junit.Before;
import org.junit.Test;
import w2d.antlr.ExceptionErrorStrategy;
import org.junit.Test;
import w2d.parser.W2D;
import w2d.parser.question.QuestionParser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CheckboxTest {

    @Before
    public void cleanErrors() {
        ExceptionErrorStrategy.cleanErrors();
        W2D.resetParsers();
    }

    @Test
	public void oneLineCheckbox() {
		new W2D("#c = new Checkbox {label:\"You cool?\"};").readTheScript();

		assertEquals(1, QuestionParser.questions.size());
		assertNotNull(QuestionParser.questions.get("#c"));
		assertEquals("You cool?", QuestionParser.questions.get("#c").label);
	}

    @Test
    public void multiLineCheckbox() {
        new W2D("#c = new Checkbox {\n\tlabel: \"You cool?\"\n};").readTheScript();

        assertEquals(1, QuestionParser.questions.size());
        assertNotNull(QuestionParser.questions.get("#c"));
        assertEquals("You cool?", QuestionParser.questions.get("#c").label);
    }

    @Test
    public void noWhitespaceCheckbox() {
        new W2D("#c=new CheckBox{label:\"You cool?\"};").readTheScript();

        assertEquals(1, QuestionParser.questions.size());
        assertNotNull(QuestionParser.questions.get("#c"));
        assertEquals("You cool?", QuestionParser.questions.get("#c").label);
    }

    @Test
    public void noSemicolonCheckbox() {
        new W2D("#c = new Checkbox {label: \"Hi!\"}").readTheScript();

        assertFalse(ExceptionErrorStrategy.errors.isEmpty());
    }

}
