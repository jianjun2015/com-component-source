package thread.multiply.volatile_;

/**
 *执行结果为 小于100000的一个数，但每次都不确定
 * 解释：加入在某一时刻两个线程都读取了inc=10，但是都做了修改，对于主存来说只是做了一次 +1，所以得到的结果会是小于100000；
 * 解释到这里，可能有朋友会有疑问，不对啊，前面不是保证一个变量在修改volatile变量时，会让缓存行无效吗？然后其他线程去读就会读到新的值，对，这个没错。这个就是上面的happens-before规则中的volatile变量规则，但是要注意，线程1对变量进行读取操作之后，被阻塞了的话，并没有对inc值进行修改。然后虽然volatile能保证线程2对变量inc的值读取是从内存中读取的，但是线程1没有进行修改，所以线程2根本就不会看到修改的值。
 * Created by wangjianjun on 2017/8/17.
 */
public class VolatileTest {

    public volatile int inc = 0;
    public void increase(){
        inc++;
    }

    //通过synchronized ：去掉volatile 在方法加上synchronized
    //通过lock 在方法里面的操作加上lock
    //通过 AtomicInteger ：
    // public  AtomicInteger inc = new AtomicInteger();
    // public  void increase() {
    //        inc.getAndIncrement();
    //    }
    //以上三种方式得到的结果一样

    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
        for (int i=0;i<100;i++){
            new Thread(){
                @Override
                public void run() {
                    for (int j=0;j<1000;j++){
                        test.increase();
                    }
                }
            }.start();
        }

        //保证前面的线程都执行完
        while (Thread.activeCount()>1){
            Thread.yield();
        }

        System.out.println(test.inc);
    }
}
