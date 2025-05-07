package Exam;

import java.util.ArrayList;

public class ExamService {
	ArrayList <Question> questions = new ArrayList<>();
	int correct = 0;
	int invalid = 0;
	int skip = 0;
	public ExamService() {
		questions.add(new Question("What is the capital of India",new String[]{"Mumbai","Tamilnadu","Delhi","Goa"},'C'));
		questions.add(new Question("Who developed Java",new String[]{"Dennis Ritchie","James Gosling","Bjarne Stroustrup","Guido van Rossum"},'B'));
		questions.add(new Question("What is the capital of India",new String[]{"Mumbai","Tamilnadu","Delhi","Goa"},'C'));
		questions.add(new Question("Who developed Java",new String[]{"Dennis Ritchie","James Gosling","Bjarne Stroustrup","Guido van Rossum"},'B'));
		questions.add(new Question("What is the capital of India",new String[]{"Mumbai","Tamilnadu","Delhi","Goa"},'C'));
	}
	public void loadQuestions() {
		for(int i=0;i<5;i++) {
			Question question = questions.get(i);
			System.out.println(question.getQuestion());
			for(int i = 0;i<4;i++) {
				
			}
		}
	}
	
}
