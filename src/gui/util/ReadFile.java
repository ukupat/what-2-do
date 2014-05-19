package gui.util;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {

	public static String getText(String file) {
		try {
			return new String(Files.readAllBytes(Paths.get(file)));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(
				new JFrame(),
				"Something went wrong with reading the script",
				"What to Do?",
				JOptionPane.ERROR_MESSAGE
			);
		}
		return null;
	}
}
