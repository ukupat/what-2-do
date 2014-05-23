package w2d.rule;

import java.util.HashMap;
import java.util.Map;

public class Rule {

	public Map<StatementGroup, Boolean> statementGroups = new HashMap<StatementGroup, Boolean>();

	public Boolean satisfied = null;

	public Rule() {
	}

	public Rule(Map<StatementGroup, Boolean> statementGroups) {
		this.statementGroups = statementGroups;
	}

	public void setSatisfied() {
		for (Map.Entry<StatementGroup, Boolean> group : statementGroups.entrySet()) {
			if (group.getKey().getValue()) {
				satisfied = group.getValue();
				return;
			}
		}
		satisfied = null;
	}
}
