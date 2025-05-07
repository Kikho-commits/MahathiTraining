package restaurant;

import java.util.HashMap;

public class Order {
    HashMap<String, Food> foodItem = new HashMap<>();
    private int totalQty = 0;
    private double totalPrice = 0;

    static class Food {
        String name;
        int qty;
        double price;

        public Food(String name, int qty, double price) {
            this.name = name;
            this.qty = qty;
            this.price = price;
        }
    }

    public void orderFood(String name, int qty, double price) {
        if (foodItem.containsKey(name)) {
            foodItem.get(name).qty += qty;
        } else {
            foodItem.put(name, new Food(name, qty, price));
        }
    }

    public void bill() throws Exception {
        if (foodItem.isEmpty()) {
            throw new Exception("You haven't ordered any food.");
        } else {
            calculateBill();
            System.out.println("Total Food Items\t: " + totalQty);
            System.out.println("Total Bill Amount\t: " + totalPrice);
        }
    }

    public void calculateBill() {
        for (String f : foodItem.keySet()) {
            Food food = foodItem.get(f);
            System.out.println(food.name + "\t" + food.qty + "\t" + (food.qty) * food.price);
            totalQty += food.qty;
            totalPrice += (food.qty) * food.price;
        }
    }

    double getTotalPrice() {
        return totalPrice;
    }
}
