package collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

class Student{
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

class CourseManagement{
	int id = 1;
	HashMap<String,ArrayList<Student>> courses = new HashMap<>();
	
	public void addStudent(String name,String course, int grade) {
		if(courses.containsKey(course)) {
			ArrayList<Student> student = courses.get(course);
			student.add(new Student(id++,name,course,grade));
			courses.put(course, student);
		}else {
			ArrayList<Student> student = new ArrayList<>();
			student.add(new Student(id++,name,course,grade));
			courses.put(course, student);
		}
		System.out.println("Student Created Successfully!");
	}
	
	public void displayStudentByDept(String dept) throws Exception {
		if(courses.containsKey(dept)) {
			ArrayList <Student> student = courses.get(dept);
			student.sort(Comparator.comparing(Student::getName));
			for(Student e : student) {
				displayStudent(e);
			}
		}else {
			throw new Exception ("Department not exist!");
		}
		
	}
	
	public void displayStudentByGrade(String dept) {
		if(courses.containsKey(dept)) {
			System.out.println("Displaying Student by Grade : ");
			ArrayList <Student> student = courses.get(dept);
			student.sort(Comparator.comparing(Student::getGrade).reversed());
			for(Student e : student) {
				displayStudent(e);
			}
		}
		
	}
	
	public void displayByCourses() throws Exception {
		if(courses.isEmpty()) {
			throw new Exception("No Department exist!");
		}else {
			System.out.println("\nDisplaying Students by Groups");
			for(String s : courses.keySet()) {
				System.out.println("\n"
						+ "Department : "+s);
				displayStudentByDept(s);
			}
		}
		
	}
	
	public void displayHighGrade() throws Exception {
		if(courses.isEmpty()) {
			throw new Exception("No Department exist!");
		}else {
			System.out.println("Top Students : ");
			for(String s : courses.keySet()) {
				ArrayList<Student> student = courses.get(s);
				student.sort(Comparator.comparing(Student::getGrade).reversed());
				Student e = student.get(0);
				displayStudent(e);
			}
		}
	}
	
	public void displayFailedStudent() throws Exception {
		if(courses.isEmpty()) {
			throw new Exception("No Department exist!");
		}else {
			System.out.println("Failed Students : ");
			for(String s : courses.keySet()) {
				System.out.println("Department : ");
				ArrayList<Student> student = courses.get(s);
				student.sort(Comparator.comparing(Student::getGrade));
				for(Student e : student) {
					if(e.getGrade()<60) {
						displayStudent(e);
					}
					else {
						break;
					}
				}
			}
		}
	}
	
	public void searchByName(String name) throws Exception {
		ArrayList<Student> student = new ArrayList<>();
		if(courses.isEmpty()) {
			throw new Exception("No Department exist!");
		}else {
			for(String c : courses.keySet()) {
				ArrayList <Student> std = courses.get(c);
				for(Student s : std) {
					if(s.getName().contains(name)) {
						student.add(s);
					}
				}
			}
		}
		if(student == null) {
			throw new Exception("No Student Found with the name : "+name);
		}
		for(Student s : student) {
			displayStudent(s);
		}
	}
	
	public void displayStudent(Student s) {
		System.out.println("\nStudent ID\t: "+s.id);
		System.out.println("Student Name\t: "+s.name);
		System.out.println("Student Course\t: "+s.course);
		System.out.println("Student Mark\t: "+s.grade);
	}

}

public class StudentMain {
	public static void main(String[] args) {
		CourseManagement cm = new CourseManagement();
		
		cm.addStudent("Kishore Kumar", "DA", 85);
		cm.addStudent("Suriya", "DA", 75);
		cm.addStudent("John", "DA", 50);
		cm.addStudent("Akash", "CG", 95);
		cm.addStudent("Sanju","CG",55);
		cm.addStudent("Kishore","IT",79);
		try {
//			cm.displayStudentByDept("DA");
//			cm.displayStudentByGrade("DA");
//			cm.displayByCourses();
//			cm.displayHighGrade();
//			cm.displayFailedStudent();
			cm.searchByName("Kishore");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
