package employee.main;

import java.util.Scanner;

import employee.entity.Address;
import employee.entity.Employee;
import employee.repository.Repository;
import employee.service.AuthServiceImpl;
import employee.service.EmployeeServiceImpl;
import employee.views.Views;

public class Main {
	static Scanner in = new Scanner(System.in);
	static EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
	static Views view = new Views(employeeService);
	
	public static void addEmployee() {
		view.displayRoles();
		System.out.println("Choose role : ");
		int role = in.nextInt();
		int lead;
		if(role ==1) {
			lead = 1;
		}else {
			System.out.println(employeeService.getRole().get(role-1)+"s");
			view.displayByLead(role);
			System.out.println("Choose "+employeeService.getRole().get(role-1));
			int choice = in.nextInt();
			lead = employeeService.viewByRole(role).get(choice-1).getUserId();
		}
		getUserDetails(role,lead);
		
	}
	
	public static void getUserDetails(int role,int lead) {
		System.out.println("Enter Name\t: ");
		String name = in.next();
		System.out.println("Enter Gender (M/F)\t: ");
		String gender=in.next();
		System.out.println("Enter working Hours\t: ");
		double hrs = in.nextDouble();
		in.nextLine();
		System.out.println("Enter address:\n"
				+ "No : ");
		String no =in.nextLine();
		System.out.println("Street\t: ");
		String street=in.nextLine();
		System.out.println("City\t: ");
		String city=in.next();
		System.out.println("State\t: ");
		String state = in.next();
		System.out.println("Enter Username\t: ");
		String userName = in.next();
		while(Repository.getUsers().containsKey(userName)) {
			System.out.println("Username Already Exist!"
					+ "\nTry Another");
			userName = in.next();
		}
		System.out.println("Enter Password\t: ");
		String password = in.next();
		employeeService.addEmployee(role+1, lead, name, gender, hrs, new Address(no,street,city,state), userName, password);
	}
	
	public static void main(String[] args) {
		Employee currentEmployee;
		AuthServiceImpl authService = new AuthServiceImpl();
		Repository repository = new Repository();
		employeeService.loadDetails();
		boolean isLoggedIn = false;
		while(!isLoggedIn) {
			System.out.println("Username : ");
			String username = in.next();
			System.out.println("Password : ");
			String password = in.next();
			int userId = authService.loginAuthenticate(username, password);
			System.out.println(userId);
			currentEmployee = repository.getEmployee(userId);			
			boolean loading = false;
			if(currentEmployee==null && userId !=1) {
				System.out.println("Invalid Credentials");
			}else {
				isLoggedIn=!isLoggedIn;
				loading = true;
			}
			int role = userId == 1?1:currentEmployee.getRole();
			
			while(loading) {
				switch(role) {
				case 1:
					System.out.println("Welcome Admin!");
					view.displayAdminControl();
					int choice = in.nextInt();
					switch(choice) {
					case 1:
						addEmployee();
						break;
					case 2:
						
					case 3:
		
					case 4:
					
					}
					break;
				}
			}
			
					
		}

	}

}
