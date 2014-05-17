package gui.panel;

import gui.frame.MainFrame;
import gui.listener.ButtonListener;
import net.miginfocom.swing.MigLayout;
import w2d.question.Question;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InputPanel extends JPanel {

	public static JButton chooseFileButton;

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
		setSize(MainFrame.WINDOW_WIDTH / 2, MainFrame.WINDOW_HEIGHT);
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
		chooseFileButton = new JButton("Choose file");
		chooseFileButton.addMouseListener(new ButtonListener());

		add(chooseFileButton, "pos 30% 45%");
	}
}
