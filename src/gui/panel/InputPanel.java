package gui.panel;

import gui.frame.MainFrame;
import gui.input.Button;
import gui.input.CheckboxInput;
import gui.input.Label;
import gui.input.SelectInput;
import net.miginfocom.swing.MigLayout;
import w2d.question.Question;
import w2d.question.Select;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InputPanel extends JPanel {

	public static Button chooseFileButton;
	public static Button submitButton;

	// TODO place where we hold questions
	private List<Question> questions = new ArrayList<Question>();

	public InputPanel() {
		setPanelSettings();
		renderChooseFileView();
	}

	private void setPanelSettings() {
		setLayout(
			new MigLayout(
				"insets 0, width 100%, height 100%"
			)
		);
		setSize(MainFrame.WINDOW_WIDTH / 2 - 15, MainFrame.WINDOW_HEIGHT - 22);
	}

	private void renderChooseFileView() {
		renderWelcomeMessage();
		renderChooseFileButton();
	}

	private void renderWelcomeMessage() {
		JLabel welcome = new JLabel("Select your .w2d script");
		welcome.setFont(new Font("Helvetica", Font.PLAIN, 20));
		welcome.setForeground(Color.GRAY);

		add(welcome, "pos 15% 35%");
	}

	private void renderChooseFileButton() {
		chooseFileButton = new Button("Choose file");
		add(chooseFileButton, "pos 32% 45%");
	}

	private void renderQuestions() {
		renderQuestionsTitle();

		// TODO

		renderSubmitButton();
	}

	private void renderQuestionsTitle() {
		JLabel title = new JLabel("Questions");
		title.setFont(new Font("Helvetica", Font.PLAIN, 20));
		title.setForeground(Color.GRAY);

		add(title, "gap 20 0 20, wrap");
	}

	private void renderSelect(Select select) {
		Label title = new Label(select.label);
		add(title, "gap 20 20 20, wrap");

		SelectInput selectInput = new SelectInput(select.options);
		add(selectInput, "gap 15 0 3, wrap");
	}

	private void renderCheckbox(Question checkbox) {
		Label title = new Label(checkbox.label);
		add(title, "gap 20 20 20, wrap");

		CheckboxInput checkboxInput = new CheckboxInput();
		add(checkboxInput, "gap 15 0 3, wrap");
	}

	private void renderSubmitButton() {
		submitButton = new Button("Submit");
		add(submitButton, "gap 13 15 15 15");
	}
}
