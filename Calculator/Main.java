package Calculator;

public class Main {
	
	public static void main(String[] args) {
		MainService ms = new MainService();
		do {
			try {
				int operation = ms.displayService();
				if(operation == 5) {
					System.out.println("Exiting...");
					return;
				}
				ms.operation(operation);
				System.out.println("--------------------------------");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}while(true);
	}
}
