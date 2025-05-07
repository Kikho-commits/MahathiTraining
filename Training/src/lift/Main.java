package lift;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		MainService mc = new MainService();
		mc.createLifts();
		do {
			try {
				mc.displayOptions();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(true);
		
	}

}
