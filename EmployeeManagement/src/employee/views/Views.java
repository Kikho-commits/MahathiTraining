package employee.views;

import java.util.Scanner;

import employee.repository.Repository;
import employee.service.EmployeeServiceImpl;
import employee.service.LoadDetails;

public class Views {
	Scanner in = new Scanner(System.in);
	Repository repository = new Repository();
	EmployeeServiceImpl employeeService= new EmployeeServiceImpl();
	LoadDetails loadDetails = new LoadDetails();
	boolean login;
	
	public void startApp() {
		
		do {
			login=userLogin();
			if(login) {
				System.out.println("User Logged in Successfully.");
				display();
				break;
			}else {
				System.out.println("Invalid User name or Password.");
			}
		}while(true);
		
		
	}
	
	public boolean userLogin() {
		System.out.println("UserName : ");
		String username = in.next();
		System.out.println("Password : ");
		String password = in.next();
		if(employeeService.authService(username, password))
			return true;
		return false;	
	}
	
	public void display() {
		String currentUser = employeeService.getEmployee().getRole();
		System.out.println(currentUser);
		
	}
	public void adminDisplay() {
		
	}
}
