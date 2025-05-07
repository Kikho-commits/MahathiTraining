package NestedClass;

import java.util.HashMap;
import java.util.Scanner;

class School{
	String schoolName;
	int count = 0;
	public School(String schoolName) {
		this.schoolName = schoolName;
		System.out.println(schoolName);
	}
	int id = 1;
	class Student{
		int id;
		String name;
		
		public Student(int id, String name) {
			this.id = id;
			this.name = name;
			count++;
		}
	}
//	ArrayList <Student> students = new ArrayList<>();
	HashMap<Integer,Student> students = new HashMap<>();
	public void createStudent(String name) {
		students.put(id,new Student(id,name));
		displayStudentDetails(id);
		id++;
	}
	public int countStudents() {
		return count;
	}
	public void displayAllStudents() {
		for(int i : students.keySet()) {
			displayStudentDetails(i);
		}
	}
	public void displayStudentDetails(int id) {
		Student s = students.get(id);
		System.out.println("Student ID : "+s.id);
		System.out.println("Student name : "+s.name);
	}
}
public class StudentMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter School Name : ");
		String schoolName = in.nextLine();
		School school = new School(schoolName);
		while(true) {
			System.out.println("1.Create Student\n2.Count of Students"
					+ "\n3.Student Details by ID \n4.All Student Details\n5.Exit");
			System.out.println("Enter the operation : ");
			int choice = in.nextInt();
			in.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter Student Name : ");
				String name = in.nextLine();
				school.createStudent(name);
				System.out.println("Student created successfully!");
				
				break;
			case 2:
				System.out.println("Total Number of Students : "+school.countStudents());
				break;
			case 3:
				System.out.println("Enter Student id : ");
				int id = in.nextInt();
				school.displayStudentDetails(id);
				break;
			case 4:
				school.displayAllStudents();
				break;
			case 5:
				System.out.println("Exiting...!");
				return;
			default:
				System.out.println("Enter a valid input!");
			}
		}
	}

}
