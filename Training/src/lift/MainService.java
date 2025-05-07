package lift;

import java.util.HashMap;
import java.util.Scanner;

public class MainService {
	Scanner in = new Scanner(System.in);
	HashMap <Integer,Lift> lifts = new HashMap<>();
	LiftOperationImpl lo = new LiftOperationImpl();
	
	public void createLifts(){
		
		System.out.println("Enter the number of lifts : ");
		int n = in.nextInt();
		System.out.println("Enter the TOP Floor : ");
		int max = in.nextInt();
		System.out.println("Enter the BOTTOM Floor : ");
		int min = in.nextInt();
		
		lifts.put(1, new Lift(max,min,n,1));
		for(int i=2;i<=n;i++) {
			lifts.put(i,new Lift(i));
		}
	}
	
	public void displayOptions() throws Exception {
		System.out.println("-------------------------------\n");
		System.out.println("\n1.Use Lift\n2.Lift Status\n3.Exit");
		System.out.println("Enter the operation : ");
		int choice = in.nextInt();
		switch(choice) {
		case 1:
			moveTo();
			break;
		case 2:
			displayLiftPanel();
			break;
		case 3:
			exit(true);
			break;
		default:
			System.out.println("Enter a valid input!");
		}
		
	}
	
	public void displayLiftPanel() throws Exception {
		System.out.println("-------------------------------");
		do {
			System.out.println("\n1.Lift Panel\n2.Lift By ID\n3.All Lift Details\n4.Exit");
			System.out.println("Enter the operation : ");
			int choice = in.nextInt();
			switch(choice) {
			case 1:
				liftByFloor();
				break;
			case 2:
				System.out.println("Enter the lift ID : ");
				int i = in.nextInt();
				if(lifts.containsKey(i)) {
					liftStatus(lifts.get(i));
				}else {
					throw new Exception("Invalid Lift ID");
				}
				break;
			case 3:
				System.out.println("All Lift Details : ");
				allLiftStatus();
				break;
			case 4:
				exit(false);
				break;
			default:
				System.out.println("Enter a valid Option!");
			}
			
		}while(true);
	}
	
	public void moveTo() throws Exception {
		Lift lift = lifts.get(1);
		System.out.println("Enter the Current Floor : ");
		int f = in.nextInt();
		if(f > lift.getMaxFloor() || f < lift.getMinFLoor()) {
			System.out.println("Invalid Destination");
			displayOptions();
		}
		System.out.println("Enter the lift number : ");
		int n = in.nextInt();
		if(!lifts.containsKey(n)) {
			throw new Exception("Invalid Lift!");
		}
		System.out.println("Enter the destination : ");
		int d = in.nextInt();
		if(d > lift.getMaxFloor() || d < lift.getMinFLoor()) {
			System.out.println("Invalid Destination");
			displayOptions();
		}
		if(lifts.containsKey(n)) {
			lift = lifts.get(n);
			if(lift.getCurrentFloor() != f) {
				lo.moveTo(lift, f);
			}
			lo.moveTo(lift, d);
		}
		System.out.println("Destination Reached!");
	}
	
	public void liftStatus(Lift lift) {
		System.out.println("Lift ID\t: "+lift.getId());
		System.out.println("Current Floor\t: "+lift.getCurrentFloor());
		System.out.println("Previous Floor\t: "+ lift.getPreviousFloor());
		System.out.println();
	}
	
	public void liftByFloor() {
		Lift lift;
		for(int i : lifts.keySet()) {
			lift = lifts.get(i);
			System.out.println("Lift ID\t: "+lift.getId());
			System.out.println("Floor\t: "+lift.getCurrentFloor());
			System.out.println();
		}
	}
	
	public void allLiftStatus() {
		for(int i : lifts.keySet()) {
			liftStatus(lifts.get(i));
		}
	}
	
	public void exit(boolean b) throws Exception {
		if(b) {
			System.out.println("Exiting");
			return;
		}else {
			displayOptions();
		}
	}
}
