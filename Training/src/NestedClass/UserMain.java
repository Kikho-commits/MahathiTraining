package NestedClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class User{
	String name;
	User(String name){
		this.name = name;
	}
	static class Address{
		String building;
		String city;
		int pincode;
		
		public Address(String building,String city, int pincode) {
			this.building = building;
			this.city = city;
			this.pincode = pincode;
		}
	}
	ArrayList <Address> address = new ArrayList<>();
	
	void createAddress(String building, String city, int pincode) throws Exception {
		if(checkPincode(pincode)) {
			address.add(new Address(building, city, pincode));
		}else {
			throw new Exception("Invalid Pincode");
		}
	}
	
	boolean checkPincode(int pincode) {
		if(String.valueOf(Math.abs(pincode)).length() == 6) {
			return true;
		}
		return false;
	}
	
	void displayAddress() {
		for(Address a : address) {
			System.out.println("Building : "+a.building);
			System.out.println("City : "+a.city);
			System.out.println("Pincode : "+a.pincode);
		}
	}
}

public class UserMain {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		HashMap <String,User> users = new HashMap<>();
		while(true) {
			System.out.println("1.Create User\n2.Add address\n3.Display Address by User"
					+ "\n4.Exit");
			System.out.println("Enter your choice : "
					+ "");
			int choice = in.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Username : ");
				String username = in.next();
				try {
					if(users.containsKey(username)) {
						throw new Exception ("User Already Exist!");
					}else {
						users.put(username, new User(username));
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("User created Successfully!");
				break;
			case 2:
				System.out.println("Enter the Username : ");
				username = in.next();
				try {
					if(users.containsKey(username)) {
						User usr = users.get(username);
						System.out.println("Enter Building name : ");
						String building = in.next();
						System.out.println("Enter City : ");
						String city = in.next();
						System.out.println("Enter pincode: ");
						int pincode = in.nextInt();
						usr.createAddress(building, city, pincode);
					}
					else {
						throw new Exception("User Not Found!");
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 3:
				System.out.println("Enter the username : ");
				username = in.next();
				try {
					if(users.containsKey(username)) {
						User usr = users.get(username);
						usr.displayAddress();
					}else {
						throw new Exception("User Not Found!");
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Exit!");
				return;
			default:
				System.out.println("Invalid Option!");
			}
			
		}
		
	}
}
