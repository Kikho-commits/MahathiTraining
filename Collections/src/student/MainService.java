package sudent;

import java.util.Scanner;

public class MainService {
	static CourseManagement cm = new CourseManagement();
	static Scanner in= new Scanner(System.in);
	 public MainService(){
		cm.addStudent("Kishore Kumar", "DA", 85);
		cm.addStudent("Suriya", "DA", 75);
		cm.addStudent("John", "DA", 50);
		cm.addStudent("Akash", "CG", 95);
		cm.addStudent("Sanju","CG",55);
		cm.addStudent("Kishore","IT",79);
		cm.addStudent("Tharun", "CT", 76);
		cm.addStudent("Lokesh", "CT", 56);
	}
	
	public int displayOption() {
		int choice = 0;
		System.out.println("\n1.Create Student\n2.Dislay Student By Course\n3.Display Student by Grade"
				+ "\n4.Display all students\n5.Display Top grade Students\n6.Display Students failed"
				+ "\n7.Search Student\n8.Exit");
		System.out.println("Enter the operation : ");
		choice = in.nextInt();
		in.nextLine();
		return choice;
	}
	
	public void addStudent() {
		System.out.println("Enter Student Name\t: ");
		String name = in.nextLine();
		System.out.println("Enter Student Course\t: ");
		String course = in.next();
		System.out.println("Enter Student Mark\t: ");
		int mark = in.nextInt();
		cm.addStudent(name, course, mark);
	}
	
	public void displayStudentByCourse() throws Exception {
		System.out.println("Enter the course : ");
		String course = in.next();
		cm.displayStudentByDept(course);
	}
	
	public void displayStudentByGrade() throws Exception {
		System.out.println("Enter the course : ");
		String course = in.next();
		System.out.println("Displaying by Grade ");
		cm.displayStudentByGrade(course);
	}
	
	public void displayAllStudents() throws Exception {
		System.out.println("Displaying All Students : ");
		cm.displayByCourses();
	}
	
	public void displayTopGrade() throws Exception {
		System.out.println("Displaying Top Grade Students : ");
		cm.displayHighGrade();
	}
	
	public void displayFailed() throws Exception {
		System.out.println("Displaying Failed Students : ");
		cm.displayFailedStudent();
	}
	
	public void searchStudent() throws Exception {
		System.out.println("Enter the Student namee : ");
		String name = in.next();
		cm.searchByName(name);
	}
	
	public boolean isContinue() throws Exception {
		System.out.println("Do you want to continue (Y/N): ");
		String s = in.next();
		do {
			if(s.equalsIgnoreCase("Y")) {
				return true;
			}else if(s.equalsIgnoreCase("N")) {
				return false;
			}else {
				throw new Exception("Invalid Input");
			}
		}while(true);
	}
	
}
