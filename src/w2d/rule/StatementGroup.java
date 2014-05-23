package w2d.rule;

import java.util.ArrayList;
import java.util.List;

public class StatementGroup {

	private List<IfStatement> statements = new ArrayList<IfStatement>();

	public StatementGroup(List<IfStatement> statements) {
		this.statements = statements;
	}

	public Boolean getValue() {
		for (IfStatement statement : statements) {
			if (!statement.getValue()) {
				return false;
			}
		}
		return true;
	}
}
