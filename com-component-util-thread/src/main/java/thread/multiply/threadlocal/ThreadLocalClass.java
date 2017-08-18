package thread.multiply.threadlocal;

/**
 *  1）实际的通过ThreadLocal创建的副本是存储在每个线程自己的threadLocals中的；
 *　2）为何threadLocals的类型ThreadLocalMap的键值为ThreadLocal对象，因为每个线程中可有多个threadLocal变量，就像上面代码中的longLocal和stringLocal；
 *　3）在进行get之前，必须先set，否则会报空指针异常；
 * Created by wangjianjun on 2017/8/18.
 */
public class ThreadLocalClass {

    ThreadLocal<Long> longLocal = new ThreadLocal<>();
    //可以重写ThreadLocal的initialValue方法，避免出现没有set的时候执行get报空指针
//    ThreadLocal<Long> longLocal_ = new ThreadLocal<Long>(){
//        @Override
//        protected Long initialValue() {
//            return Thread.currentThread().getId();
//        }
//    };

    ThreadLocal<String> stringLocal = new ThreadLocal<>();

    public void set(){
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public Long getLong(){
        return longLocal.get();
    }

    public String getString(){
        return stringLocal.get();
    }

    public static void main(String[] args) {

        ThreadLocalClass test = new ThreadLocalClass();
        test.set();//如果没有set，执行get操作会报空指针

        System.out.println(test.getLong());
        System.out.println(test.getString());

        Thread thread = new Thread(){
            @Override
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            }
        };

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }

}
