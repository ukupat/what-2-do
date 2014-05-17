package w2d.question;

import java.util.List;

public class Select extends Question {

	public List<String> options;

	public Select(String label, List<String> options) {
		super(label);
		this.options = options;
	}
}
