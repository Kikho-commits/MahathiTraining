package Calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class MainService {
	Scanner in = new Scanner(System.in);
	ArrayList<Double> input = new ArrayList<>();
	OperationImpl op = new OperationImpl(); 
	public int displayService() throws Exception {
		int choice = 0;
		System.out.println("1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n5.Exit");
		System.out.println("Enter the operation : ");
		choice = in.nextInt();
		if(!(choice > 0 && choice <= 5)) {
			throw new Exception("Enter valid Operation");
		}
		return choice;
	}
	
	public void numberOfInputs(boolean t)throws Exception {
		if(!t) {
		if(toGoback(2)) {
			displayService();
		}
		}
		System.out.println("Enter the number of inputs : ");
		int n = in.nextInt();
		if(n<2) {
			throw new Exception ("Minimum input should be 2");
		}else {
			gettingInput(n);
		}
		
		
	}
	
	public void gettingInput(int n) throws Exception {
		input.clear();
		System.out.println("Enter the inputs : ");
		for(int i=0;i<n;i++) {
			input.add(in.nextDouble());
		}
		if(toGoback(1)) {
			numberOfInputs(true);
		}
	}
	
	public void operation(int i) throws Exception {
		numberOfInputs(false);
		double res = input.get(0);
		
		input.remove(0);
		for(double d : input) {
			switch(i) {
			case 1:
				res = op.add(res, d);
				break;
			case 2:
				res = op.subtract(res, d);
				break;
			case 3:
				res = op.multiply(res, d);
				break;
			case 4:
				if(d == 0) {
					throw new Exception("Divisor cannot be 0");
				}else {
					res = op.divide((int)res, (int)d);
				}
				break;
			}
			
		}
		System.out.println("Result : "+res);
	}
	
	public boolean toGoback(int i)throws Exception {
		if(i == 2) {
			System.out.println("Do you want Change Operation (Y/N) : ");
		}
		else {
			System.out.println("Do you want to Change Inputs (Y/N) : ");
		}
		String c = in.next();
		do {
			if(c.equalsIgnoreCase("y")) {
				return true;
			}else if (c.equalsIgnoreCase("n")) {
				return false;
			}else {
				throw new Exception("Enter a valid input");
			}
		}while(true);
	}
}
