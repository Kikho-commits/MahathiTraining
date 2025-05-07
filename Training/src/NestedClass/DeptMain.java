package NestedClass;

import NestedClass.Department.Employee;

public class DeptMain {

	public static void main(String[] args) {
		Department ngp = new Department();
				
		ngp.createEmployee(ngp.new Employee(1,"A","DA"));
		ngp.createEmployee(ngp.new Employee(2,"B","DA"));
		ngp.createEmployee(ngp.new Employee(3,"C","CT"));
		ngp.createEmployee(ngp.new Employee(4,"D","CT"));
		ngp.createEmployee(ngp.new Employee(5,"E","CT"));
		
//		System.out.println(ngp.countEmployeeDept("CT"));
		
		Department mahathi = new Department();
		mahathi.createEmployee(mahathi.new Employee(1,"A","HR"));
		mahathi.createEmployee(mahathi.new Employee(2,"B","HR"));
		mahathi.createEmployee(mahathi.new Employee(3,"C","JD"));
		
		System.out.println(mahathi.countEmployeeDept("HR"));
		System.out.println(mahathi.totalCount());
	}

}
