package NestedClass;

import java.util.Scanner;

class TimeConverter{
	int totalTime;
	class Time{
		int hrs;
		int mins;
		public Time(int hrs,int mins) {
			this.hrs = hrs;
			this.mins = mins;
		}
		
		public int converter() {
			return ((hrs*60)+mins)*60;
		}
	}
	
	public int converter(int hrs, int mins) {
		Time time = new Time(hrs,mins);
		return time.converter();	
	}
	
}
public class TimeConverterMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		do {
			try {
				System.out.println("Enter Hours and Minutes : ");
				int hrs = in.nextInt();
				int min = in.nextInt();
				if(hrs >23 || hrs <0 || min > 59 || min < 0) {
					throw new Exception ("Inavlid Hours or Minutes!");
				}else {
					TimeConverter time = new TimeConverter();
					System.out.println("Time in Seconds : "+time.converter(hrs, min)+"s");
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Do you want to continue ? \nYes\nNo");
			System.out.println("Enter the operation : ");
			String choice = in.next();
			if(choice.equalsIgnoreCase("yes")) {
				System.out.println("----------------------------------------------");
				continue;
			}
			else if(choice.equalsIgnoreCase("no")) {
				break;
			}
			else {
				System.out.println("Enter a valid operation");
			}
		}while(true);
		
	}

}
