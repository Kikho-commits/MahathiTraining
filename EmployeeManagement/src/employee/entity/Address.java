package employee.entity;

public class Address {
	private String no;
	private String street;
	private String city;
	private String state;
	private String country;
	
	public Address(String no, String street, String city, String state, String country) {
		super();
		this.no = no;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [no=" + no + ", street=" + street + ", city=" + city + ", state=" + state + ", country="
				+ country + "]";
	}
	
}
