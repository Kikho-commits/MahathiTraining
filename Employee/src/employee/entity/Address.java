package employee.entity;

public class Address {
	private String no;
	private String street;
	private String city;
	private String state;
	public Address(String no, String street, String city, String state) {
		super();
		this.no = no;
		this.street = street;
		this.city = city;
		this.state = state;
	}
	public String getNo() {
		return no;
	}
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
}
