package component.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyReentrantLock extends Thread{
	
	private TestMyReentrantLock testMyReentrantLock;
	private int id;
	
	public MyReentrantLock(int i,TestMyReentrantLock testMyReentrantLock) {
		// TODO Auto-generated constructor stub
		this.id = i;
		this.testMyReentrantLock = testMyReentrantLock;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		testMyReentrantLock.print(id);
	}
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		TestMyReentrantLock testMyReentrantLock = new TestMyReentrantLock();
		for(int i=0;i<10;i++){
			service.submit(new MyReentrantLock(i, testMyReentrantLock));
		}
		
		service.shutdown();
	}
	
	

}

