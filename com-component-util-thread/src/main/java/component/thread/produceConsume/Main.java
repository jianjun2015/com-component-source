package component.thread.produceConsume;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProduceConsume pc = new ProduceConsume();
		System.out.println(pc.getProduct());
		pc.pruduce();
		pc.pruduce();
		pc.pruduce();
		pc.pruduce();
		pc.pruduce();
		pc.pruduce();
		pc.pruduce();
		pc.consume();
		pc.consume();
		pc.consume();
		pc.consume();
		pc.consume();
		pc.consume();
		pc.consume();
		
		ExecutorService e = Executors.newFixedThreadPool(3);
		Future future = e.submit(new MyCallable());
		System.out.println(future.isDone());
		try {
			System.out.println(future.get());
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
