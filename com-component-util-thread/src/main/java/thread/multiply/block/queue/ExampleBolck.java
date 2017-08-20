package thread.multiply.block.queue;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 生产者和消费者--阻塞队列实现
 * Created by wangjianjun on 2017/8/20.
 */
public class ExampleBolck {

    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);

    public static void main(String[] args) {
        ExampleBolck example = new ExampleBolck();
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
                try {
                    queue.take();
                    System.out.println("从队列取走一个数据...队列剩余:"+queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
                try {
                    queue.put(1);
                    System.out.println("向队列插入一个元素...队列剩余空间:"+(queueSize-queue.size()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
