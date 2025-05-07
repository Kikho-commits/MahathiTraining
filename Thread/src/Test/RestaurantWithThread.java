package Test;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

class Kitchen{
	private final Semaphore cuttingBoard;
	
	public Kitchen(int cuttingBoard) {
		this.cuttingBoard = new Semaphore(cuttingBoard);
	}
	
	public void useKitchen(String dish){
		String chef = Thread.currentThread().getName();
		
		System.out.println(chef + " is waiting for cutting board ");
		
		try {
			cuttingBoard.acquire();
			System.out.println(chef + " is preparing "+dish);
			Thread.sleep(10000);
			System.out.println(chef + " is completed preapring "+dish);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			cuttingBoard.release();
			System.out.println(chef + " released cutting board");
		}
	}
}

class Chef extends Thread{
	private final String dish;
	private final Kitchen kitchen;
	
	public Chef(String name,String dish,Kitchen kitchen) {
		super(name);
		this.dish = dish;
		this.kitchen = kitchen;	
	}
	
	public void run() {
		kitchen.useKitchen(dish);
	}
}


public class RestaurantWithThread {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen(2);

        Chef chef1 = new Chef("Chef A","Pasta",kitchen);
        Chef chef2 = new Chef("Chef B","Pizza",kitchen);
        Chef chef3 = new Chef("Chef C","Dosa",kitchen);
        
        chef1.start();
        chef2.start();
        chef3.start();
        
        System.out.println("Main: Is Chef A alive? " + chef1.isAlive());
        
        try {
            chef1.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting for Chef A.");
        }
        
        System.out.println("Main: Chef A has finished. Is alive? " + chef1.isAlive());
        System.out.println("Main: Other chefs may still be cooking.");
    }
}
