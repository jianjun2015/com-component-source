package thread.multiply.communication;

import java.util.PriorityQueue;

/**
 * Created by wangjianjun on 2017/8/20.
 */
public class ConsumeProduce {

    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        ConsumeProduce consumeProduce = new ConsumeProduce();
        Consume consume = consumeProduce.new Consume();
        Producer producer = consumeProduce.new Producer();

        consume.start();
        producer.start();

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
                            System.out.println("队列空，等待数据");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }

                    queue.poll();          //每次移走队首元素
                    queue.notify();
                    System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");
                }
            }
        }
    }

    class Producer extends Thread{

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while(true){
                synchronized (queue) {
                    while(queue.size() == queueSize){
                        try {
                            System.out.println("队列满，等待有空余空间");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.offer(1);        //每次插入一个元素
                    queue.notify();
                    System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));
                }
            }
        }
    }
}
