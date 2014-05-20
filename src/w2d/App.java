package w2d;

import w2d.parser.W2D;

public class App {

	public static void main(String[] args) {
		//new Gui();

		new W2D(
			"#question = new Checkbox {label: \"Hello world\"}"
		).readTheScript();
	}
}
