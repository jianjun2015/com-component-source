package thread.multiply.threadlocal.test;

/**
 *
 * Created by wangjianjun on 2017/9/26.
 */
public class TestCase {

    ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();
    ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    public void set(){
        longThreadLocal.set(Thread.currentThread().getId());
        stringThreadLocal.set(Thread.currentThread().getName());
    }

    public Long getLong(){
        return longThreadLocal.get();
    }

    public String getString(){
        return stringThreadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {

        final TestCase testCase = new TestCase();
        testCase.set();

        System.out.println(testCase.getLong());
        System.out.println(testCase.getString());

        Thread thread = new Thread(){
            @Override
            public void run() {
                testCase.set();
                System.out.println(testCase.getLong());
                System.out.println(testCase.getString());
            }
        };
        thread.start();
        thread.join();

        System.out.println(testCase.getLong());
        System.out.println(testCase.getString());
    }
}
