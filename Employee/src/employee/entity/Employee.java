package employee.entity;

public class Employee {
	private int userId;
	private int role;
	private int lead;
	private String name;
	private String gender;
	private double workingHrs;
	private Address address;
	private String userName;
	public Employee(int userId, int role, int lead, String name, String gender, double workingHrs, Address address,String userName) {
		super();
		this.userId = userId;
		this.role = role;
		this.lead = lead;
		this.name = name;
		this.gender = gender;
		this.workingHrs = workingHrs;
		this.address = address;
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public int getUserId() {
		return userId;
	}
	public int getRole() {
		return role;
	}
	public int getLead() {
		return lead;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public double getWorkingHrs() {
		return workingHrs;
	}
	public Address getAddress() {
		return address;
	}
	
}
