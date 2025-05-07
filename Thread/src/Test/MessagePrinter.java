package Test;

public class MessagePrinter implements Runnable{
	
	int taskId;
	
	@Override
	public void run() {
		for(int i = 0 ; i < 5 ; i++) {
			System.out.println("Task "+i+Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());			}
		}
	}

}

