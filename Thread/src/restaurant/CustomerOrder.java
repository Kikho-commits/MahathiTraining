package restaurant;

public class CustomerOrder implements Runnable {
	Order order = new Order();
    private String itemName;
    private int qty;
    private double price;

    public CustomerOrder(String itemName, int qty, double price) {
        this.itemName = itemName;
        this.qty = qty;
        this.price = price;
    }

    @Override
    public void run() {
        try {
            // Simulate order preparation
            System.out.println("Customer is ordering " + qty + " " + itemName + "(s) for ₹" + price * qty);
            Thread.sleep(5000);  // Simulate cooking time
            System.out.println("Order for " + qty + " " + itemName + "(s) is ready!");
            order.orderFood(itemName, qty, price);
        } catch (InterruptedException e) {
            System.out.println("Order for " + itemName + " interrupted.");
        }
    }
}
