package collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

class Employee{
	int id;
	String name;
	String dept;
	
	public Employee(int id,String name,String dept) {
		this.id = id;
		this.name = name;
		this.dept = dept;
	}
	
	public String getName() {
		return name;
	}
}

class EmployeeManagement{
	int id = 1;
	HashMap<String,ArrayList<Employee>> departments = new HashMap<>();
	
	public void addEmployee(String name,String dept) {
		if(departments.containsKey(dept)) {
			ArrayList <Employee> emp = departments.get(dept);
			emp.add(new Employee(id++,name,dept));
			departments.put(dept, emp);
		}else {
			ArrayList <Employee> emp = new ArrayList<>();
			emp.add(new Employee(id++,name,dept));
			departments.put(dept, emp);
		}
	}
	
	public void displayEmployee(String dept) throws Exception {
		ArrayList<Employee> emp = departments.get(dept);
		if(departments.containsKey(dept)) {
			System.out.println("DEPARTMENT : "+dept);
			for(Employee e : emp) {
				System.out.println("\n"
						+ "Employee ID\t: "+e.id);
				System.out.println("Employee name\t: "+e.name);
			}
		}else {
			throw new Exception("Invalid Department name!");
		}
		
	}
	
	public void diplaySort(String dept) {
		ArrayList<Employee> emp = departments.get(dept);
		emp.sort(Comparator.comparing(Employee::getName));
		for(Employee e : emp) {
			System.out.println("\n"
					+ "Employee ID\t: "+e.id);
			System.out.println("Employee name\t: "+e.name);
		}
	}
	
	public  Object departmentList(){
		if(departments.isEmpty()) {
			return "No Department Found!";
		}
		else {
			return departments.keySet();
		}
	}
	
}
public class EmployeeMain {
	static Scanner in = new Scanner(System.in);
	public static boolean isContinue() {
		System.out.println("Do you want to Continue (Y/N) : ");
		String c = in.next();
		do {
			if(c.equalsIgnoreCase("Y")) {
				return true;
			}else if(c.equalsIgnoreCase("N")) {
				return false;
			}else {
				System.out.println("Enter a valid Input");
			}
		}while(true);
		
	}

	public static void main(String[] args) {
		
		EmployeeManagement em = new EmployeeManagement();
//		em.addEmployee("E", "DA");
//		em.addEmployee("D", "DA");
//		em.addEmployee("A","DA");
//		em.addEmployee("Akash", "CG");
//		try {
//			em.diplaySort("DA");
//			em.displayEmployee("DA");
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//		}
		do {
			System.out.println("\n1.Create Employee\n2.Display Departments\n3.Display Employee by Department");
			System.out.println("Enter your choice : ");
			int choice = in.nextInt();
			in.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter Employee Name : ");
				String name = in.nextLine();
				System.out.println("Enter the Deparament : ");
				String dept = in.next();
				em.addEmployee(name,dept);
				isContinue();
				break;
			case 2:
				System.out.println("Depatments : "+em.departmentList());
				isContinue();
				break;
			case 3:
				System.out.println("Enter the Department : ");
				String dep = in.next();
				try {
					em.diplaySort(dep);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				isContinue();
				break;
			case 4:
				System.out.println("Exiting!");
				return;
			default:
				System.out.println("Enter a valid input!");
			}
		}while(true);

	}

}
