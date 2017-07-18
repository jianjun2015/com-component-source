package component.queue;

/**
 * Created by wangjianjun on 2017/7/17.
 */
public class Main {

    public static void main(String[] args) {
        fun_Queue();
    }

    public static void fun_Queue(){
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.empty());
        System.out.println(myQueue.length());

        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);

        System.out.println(myQueue.length());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.remove());

        System.out.println(myQueue.length());
    }
}
