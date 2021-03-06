package gui.panel;

import gui.frame.MainFrame;
import gui.input.Button;
import gui.input.CheckboxInput;
import gui.input.Label;
import gui.input.SelectInput;
import net.miginfocom.swing.MigLayout;
import org.apache.log4j.Logger;
import w2d.question.Question;
import w2d.question.Select;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputPanel extends JPanel {

	private static final Logger log = Logger.getLogger(InputPanel.class);

	public static Button chooseFileButton;
	public static Button submitButton;
    public static Button backButton;

	public static Map<Question, JComponent> questions = new HashMap<Question, JComponent>();

	public InputPanel() {
		setPanelSettings();
		renderChooseFileView();
	}

	public void resetView() {
		removeAll();
		renderChooseFileView();
		refreshPanel();
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

	public void showQuestions(List<Question> questions) {
		log.info("Showing " + questions.size() + " question(s)");

		removeAll();

		renderQuestionsTitle();

		for (Question question : questions) {
			if (question instanceof Select) {
				renderSelect((Select) question);
			} else {
				renderCheckbox(question);
			}
		}
		renderSubmitButton();
        renderBackButton();

		MainFrame.outputPanel.resetView();

		refreshPanel();
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

		questions.put(select, selectInput);
	}

	private void renderCheckbox(Question checkbox) {
		Label title = new Label(checkbox.label);
		add(title, "gap 20 20 20, wrap");

		CheckboxInput checkboxInput = new CheckboxInput();
		add(checkboxInput, "gap 15 0 3, wrap");

		questions.put(checkbox, checkboxInput);
	}

	private void renderSubmitButton() {
		submitButton = new Button("Submit");
		add(submitButton, "gap 15 0 15 15, split");
	}

    private void renderBackButton(){
        backButton = new Button("Back");
        add(backButton, "gap 5 15 15 15");
    }

	public void collectAnswers() {
		log.info("Collecting answers");

		for (Map.Entry<Question, JComponent> el : questions.entrySet()) {
			if (el.getValue() instanceof JCheckBox) {
				el.getKey().answer = Boolean.toString(((JCheckBox) el.getValue()).isSelected());

				log.info("Question '" + el.getKey().label + "' answer is '" + el.getKey().answer);
			} else if (el.getValue() instanceof JComboBox) {
				el.getKey().answer = ((JComboBox) el.getValue()).getSelectedItem().toString();

				log.info("Question '" + el.getKey().label + "' answer is '" + el.getKey().answer + "'");
			}
		}
	}

	private void refreshPanel() {
		repaint();
		revalidate();
	}
}
