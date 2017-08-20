package thread.multiply.block.queue;

import java.util.PriorityQueue;

/**
 * 生产者和消费者--线程同步实现
 * Created by wangjianjun on 2017/8/20.
 */
public class Example {

    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        Example example = new Example();
        Produce produce = example.new Produce();
        Consume consume = example.new Consume();

        produce.start();
        consume.start();

    }

    class Consume extends Thread{
        @Override
        public void run() {
            consume();
        }

        private void consume(){
            while (true){
                synchronized (queue){
                    while (queue.size() == 0){
                        try {
                            System.out.println("队列空...等待数据");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }

                    queue.poll();
                    queue.notify();
                    System.out.println("从队列取走一个数据...队列剩余:"+queue.size());
                }
            }
        }
    }

    class Produce extends Thread{
        @Override
        public void run() {
            produce();
        }

        private void produce(){
            while (true){
                synchronized (queue){
                    while (queue.size() == queueSize){
                        System.out.println("队列满....等待");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }

                    queue.add(1);
                    queue.notify();
                    System.out.println("向队列插入一个元素...队列剩余空间:"+(queueSize-queue.size()));
                }
            }
        }
    }
}
