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
		setSize(MainFrame.WINDOW_WIDTH / 2, MainFrame.WINDOW_HEIGHT - 22);
		setBackground(Color.BLACK);
	}

	private void renderView() {
		renderTitle();
		renderInstructions();
	}

	private void renderTitle() {
		JLabel title = new JLabel("Activities to Do");
		title.setFont(new Font("Helvetica", Font.PLAIN, 20));
		title.setForeground(Color.WHITE);

		add(title, "gap 20 0 20, wrap");
	}

	private void renderInstructions() {
		JLabel title = new JLabel("<html>1. Select script<br><br>2. Answer questions<br><br>3. Submit</html>");
		title.setFont(new Font("Helvetica", Font.PLAIN, 14));
		title.setForeground(Color.WHITE);

		add(title, "gap 20 0 20, wrap");
	}
}
