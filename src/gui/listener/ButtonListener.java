package gui.listener;

import gui.input.Button;
import gui.panel.InputPanel;
import gui.util.FileBrowser;
import gui.util.ReadFile;
import org.apache.log4j.Logger;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonListener implements MouseListener {

	private final Logger log = Logger.getLogger(FileBrowser.class);

	@Override
	public void mouseClicked(MouseEvent e) {
		Button button = (Button) e.getSource();

		if (button == InputPanel.chooseFileButton) {
			log.info("User clicked on choose file button");

			String script = ReadFile.getText(new FileBrowser().getSelectedDirectory()); // TODO
		} else if (button == InputPanel.submitButton) {
			log.info("User clicked on submit button");

			// TODO
		}
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
