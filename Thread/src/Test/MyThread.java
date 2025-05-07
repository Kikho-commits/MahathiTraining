package Test;

public class MyThread extends Thread{
	String message;
	
	MyThread(String msg){
		message = msg;
	}

	public void run() {
		for(int i = 0;i<5;i++) {
			System.out.println(Thread.currentThread().getName()+
					": "+message);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception");
			}
		}
	}
	public static void main(String[] args) {
		
		
		
		MyThread t1 = new MyThread("Hello");
		MyThread t2 = new MyThread("Welcome");
		MyThread t3 = new MyThread("Good Morning");
		
		t1.setName("HelloThread");
		t2.setName("WelcomeThread");
		t3.setName("GoodMorningThread");

		try {
			t1.start();
			t1.join(500);
			
			t2.start();
			t2.join(500);
			
			t3.start();
			t3.join(500);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}

//class HelloThread extends Thread{
//	String message;
//	
//	public HelloThread(String message) {
//		this.message = message;
//	}
//	
//	public getMessage()
//}