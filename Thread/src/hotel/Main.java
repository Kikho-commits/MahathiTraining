package hotel;

public class Main {

	public static void main(String[] args) {
		MainService mc = new MainService();
		
		try {
			do {
				mc.view();
			}while(true);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
