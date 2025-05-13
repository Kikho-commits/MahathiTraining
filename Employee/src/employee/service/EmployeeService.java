package employee.service;

import java.util.ArrayList;

import employee.entity.Address;
import employee.entity.Employee;

public interface EmployeeService {
	public void addEmployee(int role, int lead, String name, String gender, double workingHrs, Address address,String userName,String password);
	public void viewAllEmployee();
	public ArrayList<Employee> viewByRole(int role);
}
