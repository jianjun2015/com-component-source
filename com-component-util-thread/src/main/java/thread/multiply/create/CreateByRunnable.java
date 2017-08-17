package thread.multiply.create;

/**
 * 通过实现runnable接口，定义一个子任务，然后交给thread去执行，即作为thread的参数，最后调用thread的start方法
 * 来创建一个新线程来执行该子任务
 * Created by wangjianjun on 2017/8/17.
 */
public class CreateByRunnable implements Runnable {

    public CreateByRunnable() {
    }

    @Override
    public void run() {
        System.out.println("子线程ID："+Thread.currentThread().getId());
    }
}
