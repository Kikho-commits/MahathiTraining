package employee.service;

import java.util.ArrayList;

import employee.entity.Address;
import employee.entity.Employee;
import employee.repository.Repository;

public class EmployeeServiceImpl implements EmployeeService {
	static Employee employee;
	Repository repository = new Repository();

	@Override
	public boolean authService(String name, String password) {
		if (repository.getUsers().containsKey(name)) {
			if (repository.getUsers().get(name).getPassword().equals(password)) {
				if (!name.equals("Admin")) {
					employee = repository.getUsers().get(name);
				}
				return true;
			}
		}
		return false;
	}

	public static Employee getEmployee() {
		return employee;
	}

	public void addEmployee(String name, String gender, Address address, double totalWorkingHours, String userId,
			String password, String role, String lead) {

		Employee emp = new Employee(name, gender, address, totalWorkingHours, userId, password, role, lead);
		repository.getUsers().put(userId, emp);
		
		if (!(repository.getEmployee().containsKey(role))) {
			repository.getUsers().put(userId, emp);
			repository.getEmployee().put(role, new ArrayList<Employee>());
		}
		repository.getEmployee().get(role).add(emp);
	}
}
