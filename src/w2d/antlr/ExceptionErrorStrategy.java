package w2d.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.IntervalSet;

import java.util.ArrayList;
import java.util.List;

public class ExceptionErrorStrategy extends DefaultErrorStrategy {

	public static List<String> errors = new ArrayList<String>();

	public static void cleanErrors() {
		errors = new ArrayList<String>();
	}

	@Override
	public void recover(Parser recognizer, RecognitionException e) {
		handleError(recognizer, e.getOffendingToken(), e.getExpectedTokens());
	}

	@Override
	public void reportInputMismatch(Parser recognizer, InputMismatchException e) {
		handleError(recognizer, e.getOffendingToken(), e.getExpectedTokens());
	}

	@Override
	public void reportMissingToken(Parser recognizer) {
		beginErrorCondition(recognizer);

		Token t = recognizer.getCurrentToken();
		IntervalSet expecting = getExpectedTokens(recognizer);
		String msg = "Missing " + expecting.toString(recognizer.getTokenNames()) + " at " + getTokenErrorDisplay(t);

		errors.add(msg);
	}

	private void handleError(Parser recognizer, Token token, IntervalSet expecting) {
		Token t = recognizer.getCurrentToken();

		String msg = getErrorLocationMsg(t);
		msg += "Mismatched input " + getTokenErrorDisplay(t);
		msg += " expecting one of " + expecting.toString(recognizer.getTokenNames());

		errors.add(msg);
	}

	private String getErrorLocationMsg(Token t) {
		return "[Line " + t.getLine() + ", char " + t.getCharPositionInLine() + "] ";
	}
}
