package component.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MySemaphore extends Thread{

	Semaphore position;
	private int id;

	public MySemaphore(int i,Semaphore semaphore) {
		// TODO Auto-generated constructor stub
		this.id = i;
		this.position = semaphore;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			if(position.availablePermits()>0){
				System.out.println("顾客["+this.id+"]进入厕所，有空位");
			}else{
				System.out.println("顾客["+this.id+"]进入厕所，没空位，排队");
			}

			position.acquire();
			System.out.println("顾客["+this.id+"]获得坑位");
			Thread.sleep((int)(Math.random()*1000));
			System.out.println("顾客["+this.id+"]使用完毕");
			position.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ExecutorService list = Executors.newCachedThreadPool();
		int size = 1;
		Semaphore position = new Semaphore(size);
		for(int i=0;i<10;i++){
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			list.submit(new MySemaphore(i+1,position));
		}

		list.shutdown();
		position.acquireUninterruptibly(size);
		System.out.println("使用完毕，需要清扫了");
		position.release(2);
	}
}
