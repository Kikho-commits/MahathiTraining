package employee.repository;

import java.util.ArrayList;
import java.util.HashMap;

import employee.entity.Employee;

public class Repository {
	private static HashMap<String, Employee> users = new HashMap<>();
	private static HashMap<String, ArrayList<Employee>> employee = new HashMap<>();
	public HashMap<String, Employee> getUsers() {
		return users;
	}
	public void setUsers(HashMap<String, Employee> users) {
		Repository.users = users;
	}
	public HashMap<String, ArrayList<Employee>> getEmployee() {
		return employee;
	}
	public void setEmployee(HashMap<String, ArrayList<Employee>> employee) {
		Repository.employee = employee;
	}
	
}
