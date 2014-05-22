package gui;

import gui.frame.MainFrame;
import w2d.activity.Activity;
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

	public static void showActivities(List<Activity> activities) {
		MainFrame.outputPanel.showActivities(activities);
	}
}
