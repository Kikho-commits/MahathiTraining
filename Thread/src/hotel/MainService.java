package hotel;

import java.util.ArrayList;
import java.util.Scanner;

import hotel.threads.BillingThread;
import hotel.threads.Cooking;

public class MainService extends Thread{
	ArrayList<FoodItem> foodItem = new ArrayList<>();
	Scanner in = new Scanner(System.in);
	Order order = new Order();
	boolean isOrdered = false;
		
	public MainService() {
		foodItem.add(new FoodItem(1,"Poori",90));
		foodItem.add(new FoodItem(2,"Masala Dosa",110));
		foodItem.add(new FoodItem(3,"Ghee Dosa",125));
		foodItem.add(new FoodItem(4,"Coffee",25));
	}
	
	public void view() throws Exception {
		boolean shown = false;
		System.out.println("1.Display Menu\n2.Order Food");
		if(isOrdered) {
			System.out.println("3.Show Bill\n4Pay Bill");
		}
		System.out.println("Enter the choice : ");
		int choice = in.nextInt();
		if(isOrdered ) {
			if(choice <0 || choice >4)
			invalidInput();
		}else if(choice <0 || choice >2) {
			invalidInput();
		}
		switch(choice) {
		case 1:
			displayFoodItems();
			shown = true;
			System.out.println("Order food ? (Y/N) : ");
			String c =in.next();
			if(c.equalsIgnoreCase("y")) {
				orderFood();
			}
			else if(c.equalsIgnoreCase("n")) {
				view();
			}
			else {
				invalidInput();
			}
			break;
		case 2:
			if(!shown) {
				displayFoodItems();
			}
			orderFood();
			break;
		case 3:
			BillingThread billingThread = new BillingThread(order);
			billingThread.start();
			break;
		case 4:
			payment();
			break;
		default:
			invalidInput();
		}
		
	}
	public void displayFoodItems() {
		System.out.println("\n"
				+ "Food\t\tPrice");
		for(int i = 0;i<foodItem.size();i++) {
			System.out.println((i+1) + ". "+foodItem.get(i).getName()+"\t"+foodItem.get(i).getPrice());
		}
	}
	
	public void orderFood() throws Exception {
		System.out.println("Enter Food Item no. : ");
		int food = in.nextInt();
		if(food < 0 || food >4) {
			throw new Exception("Enter  valid choice!");
		}
		System.out.println("Enter quantity : ");
		int qty =in.nextInt();
		Cooking cooker = new Cooking(order,foodItem.get(food-1).getName(), qty, foodItem.get(food-1).getPrice());
		cooker.start();
//		order.orderFood(foodItem.get(food-1).getName(), qty, foodItem.get(food-1).getPrice());
		isOrdered = true;
		System.out.println("Add Items (Y/N) : ");
		String c = in.next();
		if(c.equalsIgnoreCase("y")) {
			orderFood();
			Thread.sleep(1000);
			System.out.println("Preaparing");
		}else {
			view();
		}
		
	}
	
	public void invalidInput() throws Exception {
		throw new Exception("Enter a valid input!");
	}
	
	public void payment() {
		System.out.println("Payment Done");
	}

}
