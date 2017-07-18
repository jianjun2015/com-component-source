package component.queue;

/**
 * 队列-先进先出
 * Created by wangjianjun on 2017/7/17.
 */
public class MyQueue<E> {

    private Object[] data = null;
    private int maxSize;
    private int front;//对头
    private int rear;//队尾

    public MyQueue(){
        this(10);
    }

    public MyQueue(int initialSize){
        if (initialSize>=0){
            this.maxSize = initialSize;
            data = new Object[initialSize];
            front=rear = 0;
        }else {
            throw new RuntimeException("队列初始化不能为空");
        }
    }

    public boolean empty(){
        return rear==front?true:false;
    }

    public boolean add(E e){
        if (rear==maxSize){
            throw new RuntimeException("队列已满");
        }else {
            data[rear++]=e;
            return true;
        }
    }

    //出队列，但不删除
    public E peek(){
        if (empty()){
            throw new RuntimeException("队列空");
        }else {
            return (E)data[front];
        }
    }

    public E remove(){
        if (empty()){
            throw new RuntimeException("队列空");
        }else {
            E value = (E)data[front];
            data[front++] = null;
            return value;
        }
    }

    public int length(){

        return rear - front;
    }
}
