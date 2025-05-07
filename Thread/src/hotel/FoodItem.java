package hotel;

public class FoodItem {
	private int id;
	private String name;
	private double price;

	public FoodItem(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	int getId() {
		return id;
	}

	String getName() {
		return name;
	}

	double getPrice() {
		return price;
	}
}
