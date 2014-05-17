package gui.input;

import gui.listener.ButtonListener;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

	public Button(String text) {
		super(text);
		setSettings();
	}

	private void setSettings() {
		addMouseListener(new ButtonListener());
		setFont(new Font("Helvetica", Font.PLAIN, 12));
		setForeground(Color.DARK_GRAY);
		setFocusPainted(false);
	}
}
