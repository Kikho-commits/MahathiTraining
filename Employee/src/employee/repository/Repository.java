package employee.repository;

import java.util.ArrayList;
import java.util.HashMap;

import employee.entity.Employee;
import employee.entity.User;

public class Repository {
	private int userId = 2;
	private static HashMap<String,User> users = new HashMap<>();
//	private HashMap<Integer,Employee> employee = new HashMap<>();
	private static ArrayList<Employee> employee = new ArrayList<>();
	public int getId() {
		return userId++;
	}
	
//	public void addEmployee(Employee employee) {
//		this.employee.put(employee.getUserId(), employee);
//	}
	
	public void addEmployee(Employee employee) {
		Repository.employee.add(employee);
	}
	public void addUser(User user) {
		Repository.users.put(user.getUserName(), user);
	}
	public Employee getEmployee(int userId) {
		for(Employee e : employee) {
			if(e.getUserId() == userId) {
				return e;
			}
		}
		return null;
	}

	public static HashMap<String, User> getUsers() {
		return users;
	}

	public static void setUsers(HashMap<String, User> users) {
		Repository.users = users;
	}

	public int getUserId() {
		return userId;
	}

	public static ArrayList<Employee> getEmployee() {
		return employee;
	}
	
}
