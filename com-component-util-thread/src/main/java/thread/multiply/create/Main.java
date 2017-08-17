package thread.multiply.create;

/**
 * Created by wangjianjun on 2017/8/17.
 */
public class Main {

    public static void main(String[] args) {
//        funcByThread();
        funcByRunnable();
    }

    public static void funcByThread(){

        CreateByThread thread_1 = new CreateByThread("thread1");thread_1.start();
        CreateByThread thread_2 = new CreateByThread("thread2");thread_2.start();
        CreateByThread thread_3 = new CreateByThread("thread3");thread_3.start();
        CreateByThread thread_4 = new CreateByThread("thread4");thread_4.start();

    }

    public static void funcByRunnable(){
        CreateByRunnable thread_1 = new CreateByRunnable();
        Thread thread = new Thread(thread_1);
        thread.start();

        Thread thread_ = new Thread(thread_1);
        thread_.start();
    }
}
