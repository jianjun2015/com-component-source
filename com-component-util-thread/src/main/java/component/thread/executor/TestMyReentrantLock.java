package component.thread.executor;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangjianjun on 2017/5/12.
 */
public class TestMyReentrantLock {
	private ReentrantLock lock = new ReentrantLock();

	public void print(int str) {
		try {
			lock.lock();
			System.out.println(str + " 获得");
			Thread.sleep((int) (Math.random() * 1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println(str + " 释放");
			lock.unlock();
		}
	}
}