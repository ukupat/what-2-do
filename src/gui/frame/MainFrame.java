package gui.frame;

import gui.panel.InputPanel;
import gui.panel.OutputPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {

	public static final Integer WINDOW_WIDTH = 600;
	public static final Integer WINDOW_HEIGHT = 550;

	public static InputPanel inputPanel = new InputPanel();
	public static OutputPanel outputPanel = new OutputPanel();

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
		JScrollPane outputPS = new JScrollPane(outputPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		outputPS.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		outputPS.setBorder(new EmptyBorder(0, 0, 0, 0));

		JScrollPane inputSP = new JScrollPane(inputPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		inputSP.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		inputSP.setBorder(new EmptyBorder(0, 0, 0, 0));

		add(outputPS);
		add(inputSP);
	}
}
