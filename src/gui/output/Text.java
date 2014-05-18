package gui.output;

import javax.swing.*;
import java.awt.*;

public class Text extends JLabel {

	public Text(String text, Integer fontSize) {
		setSettings(fontSize);
		setText(String.format("<html><div style=\"max-width:%dpx;\">%s</div><html>", 180, text));
	}

	public Text(String text, Integer fontSize, Color fontColor) {
		this(text, fontSize);
		setForeground(fontColor);
	}

	public Text(String text, Integer fontSize, Integer width) {
		setSettings(fontSize);
		setText(String.format("<html><div style=\"width:%dpx;\">%s</div><html>", width, text));
	}

	private void setSettings(Integer fontSize) {
		setFont(new Font("Helvetica", Font.PLAIN, fontSize));
		setForeground(Color.WHITE);
	}
}
