package restaurant;

public class Main {
    public static void main(String[] args) {
        MainService mc = new MainService();

        try {
            do {
                mc.view();  // Simulate customer interaction
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            mc.shutdownService();  // Ensure service is properly shut down
        }
    }
}
