package component.thread.threadClass;

public class Thread_1 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("MyThread.run()");
	}
	
	public static void main(String[] args) {
		Thread_1 th1 = new Thread_1();
		Thread_1 th2 = new Thread_1();
		
		th1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th2.start();
		
		System.out.println(th1.getName());
		System.out.println(th2.getName());
	}
}
