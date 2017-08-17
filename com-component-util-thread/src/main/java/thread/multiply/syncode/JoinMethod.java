package thread.multiply.syncode;

/**
 * join 让其他线程进入就绪状态，当前线程阻塞，释放锁，交出cpu权限
 * Created by wangjianjun on 2017/8/17.
 */
public class JoinMethod {

    public static void main(String[] args) {

        System.out.println("进入线程："+Thread.currentThread().getName());

        MyThread myThread = new MyThread();
        myThread.start();

        try {
            System.out.println("线程："+Thread.currentThread().getName()+"等待");
            myThread.join();//当前执行的主线程转入就绪状态，执行myThread线程，执行完毕转入主线程
            //myThread.join(2000);//当前执行的主线程转入就绪状态，执行myThread线程，执行时间为2000ms，然后转入主线程，如果myThread没完成，则主线程完成继续myThread。
            System.out.println("线程："+Thread.currentThread().getName()+"继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {

        System.out.println("进入线程："+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程："+Thread.currentThread().getName()+"执行完毕");
    }
}
