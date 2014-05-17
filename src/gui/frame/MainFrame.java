package gui.frame;

import gui.panel.InputPanel;
import gui.panel.OutputPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	public static final Integer WINDOW_WIDTH = 600;
	public static final Integer WINDOW_HEIGHT = 550;

	public void render() {
		setFrameSettings();
		renderPanels();

		setVisible(true);
	}

	private void setFrameSettings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("What to Do?");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new MigLayout("insets 0"));
	}

	private void renderPanels() {
		JScrollPane inputSP = new JScrollPane(new InputPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		inputSP.setBorder(new EmptyBorder(0, 0, 0, 0));

		add(inputSP);

		JScrollPane outputPS = new JScrollPane(new OutputPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		outputPS.setBorder(new EmptyBorder(0, 0, 0, 0));

		add(outputPS);
	}
}
