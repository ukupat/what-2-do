package w2d.activity;

import w2d.rule.Rule;

import java.util.HashMap;
import java.util.Map;

public class Activity {

	public String title;

	public Map<Rule, Boolean> rules = new HashMap<Rule, Boolean>();

	public Map<String, String> fields = new HashMap<String, String>();

	public Boolean show;

	public Activity(String title, Map<Rule, Boolean> rules, Map<String, String> fields) {
		this.title = title.replaceAll("\"", "");
		this.rules = rules;
		this.fields = fields;
	}

	public void setShowStatus() {
		for (Map.Entry<Rule, Boolean> el : rules.entrySet()) {
			if (el.getKey().satisfied != el.getValue()) {
				show = false;
				return;
			}
		}
		show = true;
	}
}
