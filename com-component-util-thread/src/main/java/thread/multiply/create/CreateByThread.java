package thread.multiply.create;

/**
 * 继承 Thread创建
 * Created by wangjianjun on 2017/8/17.
 */
public class CreateByThread extends Thread{

    public static int num = 0;
    private String name;

    public CreateByThread() {
        num++;
    }

    public CreateByThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("主线程创建的第："+this.name+" 个线程，ID："+Thread.currentThread().getId());
    }
}
