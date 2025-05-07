package Exam;

public class Question {
	String question;
	String options[]=new String[4];
	char correct;
	public Question(String question, String options[],char crct) {
		this.question=question;
		this.options=options;
		this.correct=crct;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public char getCorrect() {
		return correct;
	}
	public void setCorrect(char correct) {
		this.correct = correct;
	}
}
