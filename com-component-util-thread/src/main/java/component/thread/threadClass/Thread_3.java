package component.thread.threadClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Thread_3 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		System.out.println("start....");

		Date date = new Date();
		int taskSize = 5;

		//创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);

		//创建多个有返回值的任务
		List<Future> list = new ArrayList<Future>();
		for(int i=0;i<taskSize;i++){
			Callable c = new MyCallable(i+" ");

			// 执行任务并获取Future对象
			Future f = pool.submit(c);

			// System.out.println(">>>" + f.get().toString());
			list.add(f);
		}

		pool.shutdown();

		for(Future f:list){
			// 从Future对象上获取任务的返回值，并输出到控制台
			System.out.println(">>>" + f.get().toString());
		}

		Date date2 = new Date();
		System.out.println("----程序结束运行----，程序运行时间【"
				+ (date2.getTime() - date.getTime()) + "毫秒】");

	}

}

class MyCallable implements Callable<Object>{

	private String taskNum;

	public MyCallable(String taskNum) {
		// TODO Auto-generated constructor stub
		this.taskNum = taskNum;
	}

	@Override
	public Object call() throws Exception {
		System.out.println(">>>" + taskNum + "任务启动");
		Date dateTmp1 = new Date();
		Thread.sleep(3000);
		Date dateTmp2 = new Date();
		long time = dateTmp2.getTime() - dateTmp1.getTime();
		System.out.println(">>>" + taskNum + "任务终止");
		return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
	}
}
