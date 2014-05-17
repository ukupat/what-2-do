package gui.listener;

import gui.input.Button;
import gui.panel.InputPanel;
import gui.util.FileBrowser;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		Button button = (Button) e.getSource();

		if (button == InputPanel.chooseFileButton) {
			new FileBrowser(); // TODO
		} else if (button == InputPanel.submitButton) {
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
