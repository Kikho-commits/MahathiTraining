package sudent;

public class Student {
	int id;
	String name;
	String course;
	int grade;
	
	public Student(int id,String name,String course, int grade) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	
	public int getGrade() {
		return grade;
	}
}
