package sudent;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		MainService ms = new MainService();
		
		do {
			int choice = ms.displayOption();
			try {
				switch(choice) {
				case 1:
					ms.addStudent();
					ms.isContinue();
					break;
				case 2:
					ms.displayStudentByCourse();
					ms.isContinue();
					break;
				case 3:
					ms.displayStudentByGrade();
					ms.isContinue();
					break;
				case 4:
					ms.displayAllStudents();
					ms.isContinue();
					break;
				case 5:
					ms.displayTopGrade();
					ms.isContinue();
					break;
				case 6:
					ms.displayFailed();
					ms.isContinue();
					break;
				case 7:
					ms.searchStudent();
					ms.isContinue();
					break;
				case 8:
					System.out.println("Exiting...!");
					return;
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(true);
	}
}
