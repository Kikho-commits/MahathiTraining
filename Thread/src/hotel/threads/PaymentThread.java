package hotel.threads;

import hotel.Order;

public class PaymentThread extends Thread{
	Order order;

	public PaymentThread(Order order) {
		this.order = order;
	}
	
	public void run() {
		System.out.println("1.Netbanking\n2.Cash");
		System.out.println("Enter the payment method : ");
	}
	
}
