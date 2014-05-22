package gui.panel;

import gui.frame.MainFrame;
import gui.output.Text;
import net.miginfocom.swing.MigLayout;
import org.apache.log4j.Logger;
import w2d.activity.Activity;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class OutputPanel extends JPanel {

	private static final Logger log = Logger.getLogger(OutputPanel.class);

	public OutputPanel() {
		setPanelSettings();
		renderView();
	}

	public void resetView() {
		removeAll();
		renderView();
		refreshPanel();
	}

	private void setPanelSettings() {
		setLayout(
			new MigLayout(
				"insets 0, width 100%, height 100%"
			)
		);
		setSize(MainFrame.WINDOW_WIDTH / 2, MainFrame.WINDOW_HEIGHT - 22);
		setBackground(new Color(29, 30, 25));
	}

	private void renderView() {
		renderTitle();
		renderInstructions();
	}

	private void renderTitle() {
		Text title = new Text("Activities to Do", 20, Color.WHITE);
		add(title, "gap 20 0 20, wrap, span 4");
	}

	private void renderInstructions() {
		JLabel intro = new JLabel("<html>1. Select script<br><br>2. Answer questions<br><br>3. Submit</html>");
		intro.setFont(new Font("Helvetica", Font.PLAIN, 14));
		intro.setForeground(Color.WHITE);

		add(intro, "gap 20 0 20, wrap");
	}

	public void showErrors(List<String> errors) {
		removeAll();
		renderErrorTitle();

		for (String error : errors) {
			renderError(error);
		}
		refreshPanel();
	}

	private void renderErrorTitle() {
		Text title = new Text("Problems in the Script", 20, Color.WHITE);
		add(title, "gap 20 0 20, wrap, span 4");
	}

	private void renderError(String error) {
		Text errorText = new Text(error, 14, Color.RED);
		add(errorText, "gap 20 0 20, wrap");
	}

	public void showActivities(List<Activity> activities) {
		log.info("Showing " + activities.size() + " activities");

		removeAll();
		renderTitle();

		for (int i = 1; i <= activities.size(); i ++) {
			renderActivity(i, activities.get(i - 1));
		}
		refreshPanel();
	}

	private void renderActivity(Integer count, Activity activity) {
		Text activityCount = new Text(count + ". ", 15);
		add(activityCount, "gap 20 0 20, aligny top");

		Text activityTitle = new Text(activity.title, 15);
		add(activityTitle, "gap 10 0 20 5, wrap, span 3");

		renderActivityFields(activity);
	}

	private void renderActivityFields(Activity activity) {
		for (Map.Entry<String, String> entry : activity.fields.entrySet()) {
			renderActivityField(entry.getKey(), entry.getValue());
		}
	}

	private void renderActivityField(String key, String value) {
		Text fieldName = new Text(key, 14, new Color(156, 226, 0));
		add(fieldName, "gap 10 0 5, skip 1, aligny top");

		Text semi = new Text(":", 14, new Color(238, 2, 97));
		add(semi, "gap -10 0 5, aligny top");

		Text field = new Text(value, 14, 130);
		add(field, "gap 10 0 5 5, wrap, aligny top");
	}

	private void refreshPanel() {
		repaint();
		revalidate();
	}
}
