package gui.listener;

import gui.Gui;
import gui.frame.MainFrame;
import gui.input.Button;
import gui.panel.InputPanel;
import gui.util.FileBrowser;
import gui.util.ReadFile;
import w2d.parser.W2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class ButtonListener implements MouseListener {

	private static W2D w2d;

	@Override
	public void mouseClicked(MouseEvent e) {
		Button button = (Button) e.getSource();

		if (button == InputPanel.chooseFileButton) {
			String directory = new FileBrowser().getSelectedDirectory();

			if (directory != null) {
				String script = ReadFile.getText(directory);

				w2d = new W2D(script);
				w2d.readTheScript();

				List<String> errors = w2d.getParsingErrors();

				if (!errors.isEmpty()) {
					Gui.showErrors(errors);
				} else {
					Gui.showQuestions(w2d.getQuestions());
				}
			}
		} else if (button == InputPanel.submitButton) {
			MainFrame.inputPanel.collectAnswers();

			Gui.showActivities(w2d.getActivitiesToShow());
		}
		// TODO new button if sentence
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
