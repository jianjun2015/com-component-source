package thread.multiply.syncode;

/**
 * Created by wangjianjun on 2017/8/17.
 */
public class InterruptMethod {

    public static void main(String[] args) {
        MyThread_ myThread_ = new MyThread_();
        myThread_.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myThread_.interrupt();
    }
}

class MyThread_ extends Thread{
    @Override
    public void run() {
        try{
            System.out.println("进入睡眠....");
            Thread.sleep(10000);
            System.out.println("睡眠完毕....");
        } catch (InterruptedException e) {
            System.out.println("中断异常....");
        }
        System.out.println("执行完毕.....");
    }
}
