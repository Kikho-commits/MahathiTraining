package NestedClass;

import java.util.ArrayList;

public class Department {
	public class Employee{
		int id;
		String name;
		String dept;
		
		Employee(int id,String name, String dept){
			this.id = id;
			this.name = name;
			this.dept = dept;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getDept() {
			return dept;
		}
		
	}
	ArrayList <Employee> employees = new ArrayList<>();
	
	public void createEmployee(Employee emp) {
		employees.add(emp);
	}
	
	public int countEmployeeDept(String dep) {
		int count = 0;
		for(Employee e : employees) {
			if(e.getDept().equals(dep)) {
				count++;
			}
		}
		return count;
	}
	
	public int totalCount() {
		return employees.size();
	}
}
