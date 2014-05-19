package gui.util;

import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileBrowser extends JFrame {

	private final Logger log = Logger.getLogger(FileBrowser.class);

	private File selectedDir;

	public FileBrowser() {
		createFileChooser();
	}

	private void createFileChooser() {
		FileDialog fileDialog = new FileDialog(this);

		fileDialog.setMode(JFileChooser.FILES_ONLY);
		fileDialog.setVisible(true);

		String fileName = fileDialog.getFile();

		if (fileName != null) {
			selectedDir = new File(fileDialog.getDirectory() + "/" + fileName);
			log.info("User chose file " + selectedDir.getAbsolutePath());
		}
	}

	public String getSelectedDirectory() {
		return selectedDir.getAbsolutePath();
	}
}
