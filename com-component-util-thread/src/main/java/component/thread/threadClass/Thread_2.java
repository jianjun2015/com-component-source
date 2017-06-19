package component.thread.threadClass;

public class Thread_2 implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable run()");
		
	}
	
	public static void main(String[] args) {
		Thread_2 th1 = new Thread_2();
		Thread_2 th2 = new Thread_2();
		
		Thread thread1 = new Thread(th1);
		Thread thread2 = new Thread(th2);
		
		th1.run();
		th2.run();
		
		thread1.start();
		thread2.start();
	}

}
