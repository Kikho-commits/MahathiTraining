package hotel.threads;

import hotel.Order;

public class BillingThread extends Thread {
	Order order;

	public BillingThread(Order order) {
		this.order = order;
	}

	public void run() {
		try {
			System.out.println("Bill Proccessing...");
			Thread.sleep(2000);
			order.bill();
			System.out.println("Bill generated!!!");
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
