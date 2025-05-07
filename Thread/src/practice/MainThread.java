package practice;

class Counter{
	private int count = 0;
	
	public synchronized void increment() {
		count++;
	}
	
	public int getCount() {
		return count;
	}
	
}

public class MainThread {

	public static void main(String[] args) {
		Counter c = new Counter();
		
		Thread t1 = new Thread(()->{
			for(int i =0;i<1000;i++) {
				c.increment();
			}
		});
		
		Thread t2 = new Thread(()->{
			for(int i =0;i<1000;i++) {
				c.increment();
			}
		});
		
		
		t1.start();
		t2.start();
		
		
		
		try {
			
			t1.join();
			t2.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("VALUE of Counter : " + c.getCount());
	}
	
	

}
