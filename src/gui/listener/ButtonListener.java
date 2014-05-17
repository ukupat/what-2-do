package gui.listener;

import gui.panel.InputPanel;
import gui.util.FileBrowser;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton button = (JButton) e.getSource();

		if (button == InputPanel.chooseFileButton) {
			new FileBrowser(); // TODO
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
