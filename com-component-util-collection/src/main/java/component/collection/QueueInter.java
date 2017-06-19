package component.collection;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueInter {
	
	public static void main(String[] args) {
		
		QueueInter queueInter = new QueueInter();
		queueInter.fun_queue();
		
	}

	//队列的使用，继承ArrayLIst接口
	public void fun_queue(){
		
		Queue<String> queue = new ArrayBlockingQueue(1);
		BlockingQueue<String> bqueue = new ArrayBlockingQueue(4);
		bqueue.add("AA");
		bqueue.add("AA");
		bqueue.add("AA");
		bqueue.add("AA");
//		queue.add("AA");
		
		System.out.println(bqueue.peek());
		
	}

}
 