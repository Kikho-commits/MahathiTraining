package employee.service;

import employee.entity.Employee;
import employee.repository.Repository;

public class LoadDetails {
	Repository repository = new Repository();
	EmployeeServiceImpl emp= new EmployeeServiceImpl();
	public LoadDetails() {
		emp.addEmployee("Admin","Male",null,24000,"Admin","Admin123","1",null);
		emp.addEmployee("DEF","Male",null,4000,"DEF","DEF123","5","ABC");
		emp.addEmployee("Kishore","Male",null,5000,"Kishore","Kishore123","2",null);
		emp.addEmployee("ABC","Female",null,5678,"ABC","ABC123","4","Sup");
		emp.addEmployee("Sup", "Female", null, 23450, "Sup", "Sup123", "3", "Kishore");
		
//		emp.displayAllEmployees();
	}
}
