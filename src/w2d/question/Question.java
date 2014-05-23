package w2d.question;

public abstract class Question {

	public String label;

	public String answer;

	public Question(String label) {
		this.label = label.replaceAll("\"", "");
	}
}
