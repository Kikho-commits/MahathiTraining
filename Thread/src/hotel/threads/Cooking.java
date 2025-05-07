package hotel.threads;

import hotel.Order;

public class Cooking extends Thread {
	Order order;

	String name;
	int qty;
	double price;

	public Cooking(Order order, String name, int qty, double price) {
		this.order = order;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}

	public void run() {
		order.orderFood(name, qty, price);
		try {
			System.out.println("Preparing " + name + "...");
			Thread.sleep(qty * 500);
			System.out.println(name + " cooked...");
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

}
