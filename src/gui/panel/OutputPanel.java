package gui.panel;

import gui.frame.MainFrame;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {

	public OutputPanel() {
		setPanelSettings();
		renderView();
	}

	private void setPanelSettings() {
		setLayout(
			new MigLayout(
				"insets 0, width 100%, height 100%"
			)
		);
		setSize(MainFrame.WINDOW_WIDTH / 2, MainFrame.WINDOW_HEIGHT);
		setBackground(Color.BLACK);
	}

	private void renderView() {
	}
}
