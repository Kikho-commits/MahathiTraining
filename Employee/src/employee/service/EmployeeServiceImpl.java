package employee.service;

import java.util.ArrayList;

import employee.entity.Address;
import employee.entity.Employee;
import employee.entity.User;
import employee.repository.Repository;

public class EmployeeServiceImpl implements EmployeeService {
	static ArrayList<String> role = new ArrayList<>();
	Repository repository = new Repository();
	public void loadDetails() {
		addRoles();
		addAdmin();
		addEmployee(2,1,"Manager1","M",26,null,"manager","manager123");
		addEmployee(3,2,"Supervisor","F",66,null,"supervisor","supervisor123");
		addEmployee(4,3,"Technician","M",99,null,"technician","technician123");
		addEmployee(5,4,"Intern","M",12,null,"intern","intern123");
	}
	
	public ArrayList<String> getRole() {
		return role;
	}

	public void addAdmin() {
		repository.addUser(new User(1,"Admin","Admin123"));
		
	}
	public void addRoles() {
		role.add("Admin");
		role.add("Manager");
		role.add("Supervisor");
		role.add("Technician");
		role.add("Intern");
	}
	
	@Override
	public void addEmployee(int role, int lead, String name, String gender, double workingHrs, Address address,
			String userName,String password) {
		Employee employee = new Employee(repository.getId(),role,lead,name,gender,workingHrs,address,userName);
		repository.addEmployee(employee);
		repository.addUser(new User(employee.getUserId(),userName,password));
		System.out.println("Employee Addedd Successfully!!");
	}
	@Override
	public void viewAllEmployee() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<Employee> viewByRole(int role) {
		ArrayList<Employee> employee =Repository.getEmployee();
		ArrayList<Employee> byRole = new ArrayList<>();
		for(Employee e : employee) {
			if(e.getRole()==role) {
				byRole.add(e);
			}
		}
		return byRole;
	}
	
	
}
