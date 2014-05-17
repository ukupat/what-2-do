package gui.input;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {

	public Label(String text) {
		String formattedText = String.format("<html><div style=\"width:%dpx;\">%s</div><html>", 180, text);
		setFont(new Font("Helvetica", Font.PLAIN, 14));
		setForeground(Color.GRAY);
		setText(formattedText);
	}
}
