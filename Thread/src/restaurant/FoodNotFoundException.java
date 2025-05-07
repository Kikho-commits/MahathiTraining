package restaurant;

public class FoodNotFoundException extends Exception {
    public FoodNotFoundException(String message) {
        super(message);
    }
}
