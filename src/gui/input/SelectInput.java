package gui.input;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SelectInput extends JComboBox {

	public SelectInput(List<String> options) {
		super(options.toArray());
		setFont(new Font("Helvetica", Font.PLAIN, 12));
	}
}
