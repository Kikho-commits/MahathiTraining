package employee.entity;

public class Employee {
	private String name;
	private String gender;
	private Address address;
	private double totalWorkingHours;
	private String userId;
	private String password;
	private String role;
	private String lead;

	public Employee(String name, String gender, Address address, double totalWorkingHours, String userId, String password,
			String role, String lead) {
		super();
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.totalWorkingHours = totalWorkingHours;
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.lead = lead;
	}

	public String getLead() {
		return lead;
	}

	public void setLead(String lead) {
		this.lead = lead;
	}

	public void setTotalWorkingHours(double totalWorkingHours) {
		this.totalWorkingHours = totalWorkingHours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public double getTotalWorkingHours() {
		return totalWorkingHours;
	}

	public void setTotalWorkingHours(int totalWorkingHours) {
		this.totalWorkingHours = totalWorkingHours;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
