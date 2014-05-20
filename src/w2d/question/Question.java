package w2d.question;

public abstract class Question {

	public String label;

	public Question(String label) {
		this.label = label.replaceAll("\"", "");
	}
}
