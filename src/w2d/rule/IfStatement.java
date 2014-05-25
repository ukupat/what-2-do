package w2d.rule;

import w2d.question.Question;

public class IfStatement {

	public Question leftSide;

	public String rightSide;

	public Boolean mustEqual;

	public IfStatement() {
	}

	public IfStatement(Question leftSide, String rightSide, Boolean mustEqual) {
		this.leftSide = leftSide;
		this.rightSide = rightSide.replace("\"", "");
		this.mustEqual = mustEqual;
	}

	public Boolean getValue() {
		if (mustEqual) {
			return leftSide.answer.equals(rightSide);
		}
		return !leftSide.answer.equals(rightSide);
	}
}
