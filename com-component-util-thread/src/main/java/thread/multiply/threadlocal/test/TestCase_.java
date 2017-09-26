package thread.multiply.threadlocal.test;

/**
 * 使用ThreadLocal的get方法之前一定要先set，要不然会报空指针异常。还有一种方式就是在初始化的时候调用initialValue（）方法赋值
 * Created by wangjianjun on 2017/9/26.
 */
public class TestCase_ {

    ThreadLocal<Long> longThreadLocal = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return Thread.currentThread().getId();
        }
    };
    ThreadLocal<String> stringThreadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };

    public Long getLong(){
        return longThreadLocal.get();
    }

    public String getString(){
        return stringThreadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {

        final TestCase_ testCase = new TestCase_();

        System.out.println(testCase.getLong());
        System.out.println(testCase.getString());

        Thread thread = new Thread(){
            @Override
            public void run() {
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
