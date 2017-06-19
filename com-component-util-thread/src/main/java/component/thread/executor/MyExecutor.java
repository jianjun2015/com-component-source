package component.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutor extends Thread{

	private int index;
	public MyExecutor(int i) {
		// TODO Auto-generated constructor stub
		this.index = i;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("["+this.index+"] start....");
			Thread.sleep((int)(Math.random()*10000));
			System.out.println("["+this.index+"] end.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(int i=0;i<10;i++){
//			service.execute(new MyExecutor(i));
			service.submit(new MyExecutor(i));
		}
		
		System.out.println("submit finish");
		service.shutdown();
	}
}
