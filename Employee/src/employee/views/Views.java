package employee.views;

import java.util.ArrayList;

import employee.entity.Employee;
import employee.service.EmployeeServiceImpl;

public class Views {
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
	
	ArrayList<Employee> employee = new ArrayList<>();
	public Views(EmployeeServiceImpl employeeService) {
		this.employeeService = employeeService;
	}
	public void displayAdminControl() {
		System.out.println("1.Add Employee"
				+ "\n2.View All Employees"
				+ "\n3.View Employee By Lead"
				+ "\n4.Log out"
				+ "\nEnter the operation : ");
	}
	
	public void addEmployee() {
		System.out.println("");
	}
	
	public void displayRoles() {
		for(int i =1;i<employeeService.getRole().size();i++) {
			System.out.println((i)+". "+employeeService.getRole().get(i));
		}
	
	}
	
//	public void displayLead(int role) {
//		switch(role) {
//		case 1:
//			System.out.println("Managers");
//			break;
//		case 2:
//			System.out.println("Supervisors");
//			break;
//		case 3:
//			System.out.println("Technician");
//			break;
//		default:
//			System.out.println("default;");
//			
//		}
//	}
	
	public void displayByLead(int role) {
		employee = employeeService.viewByRole(role);
		for(int i =0;i<employee.size();i++) {
			System.out.println((i+1)+". "+employee.get(i).getName());
		}
	}
	
	public void displayNonAdmin(int lead) {
		switch(lead) {
		case 1:
			System.out.println("1.View SuperVisors"
					+ "\n2.View Technisians"
					+ "\n3.View Inters"
					+ "\n4. Log out"
					+ "\nEnter the Operation : ");
			break;
		case 2:
			System.out.println("1.View Technisians"
					+ "\n2.View Interns"
					+ "\n3.Log out"
					+ "Enter the Operation : ");
			break;
		default:
			System.out.println("Enter a valid Input ");
		}
	}
	
	
}
