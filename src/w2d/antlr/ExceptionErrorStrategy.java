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
		handleError(recognizer, e.getExpectedTokens());
	}

	@Override
	public void reportError(Parser recognizer, RecognitionException e) {
		handleError(recognizer, e.getExpectedTokens());
	}

	@Override
	public void reportFailedPredicate(Parser recognizer, FailedPredicateException e) {
		handleError(recognizer, e.getExpectedTokens());
	}

	@Override
	public void reportInputMismatch(Parser recognizer, InputMismatchException e) {
		handleError(recognizer, e.getExpectedTokens());
	}

	@Override
	public void reportMissingToken(Parser recognizer) {
		handleWarning(recognizer);
	}

	@Override
	public void reportUnwantedToken(Parser recognizer) {
		handleWarning(recognizer);
	}

	private void handleError(Parser recognizer, IntervalSet expecting) {
		Token t = recognizer.getCurrentToken();

		String msg = getErrorLocationMsg(t);
		msg += "Mismatched input " + getTokenErrorDisplay(t);
		msg += " expecting one of " + expecting.toString(recognizer.getTokenNames());

		errors.add(msg);
	}

	private void handleWarning(Parser recognizer) {
		beginErrorCondition(recognizer);

		Token t = recognizer.getCurrentToken();
		IntervalSet expecting = getExpectedTokens(recognizer);

		String msg = getErrorLocationMsg(t);
		msg += "Missing " + expecting.toString(recognizer.getTokenNames()) + " at " + getTokenErrorDisplay(t);

		errors.add(msg);
	}

	private String getErrorLocationMsg(Token t) {
		return "[Line " + t.getLine() + ", char " + t.getCharPositionInLine() + "] ";
	}
}
