package gui;

import gui.frame.MainFrame;
import org.antlr.v4.runtime.RecognitionException;
import w2d.question.Question;

import java.util.List;

public class Gui {

	public Gui() {
		new MainFrame().render();
	}

	public static void showQuestions(List<Question> questions) {
		MainFrame.inputPanel.showQuestions(questions);
	}

	public static void showErrors(List<String> errors) {
		MainFrame.outputPanel.showErrors(errors);
	}
}
