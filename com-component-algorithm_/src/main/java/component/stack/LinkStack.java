package component.stack;

/**
 * Created by wangjianjun on 2017/7/17.
 */
public class LinkStack<E extends Comparable<E>> {

    //链栈节点
    private class Node<E>{
        E e;
        Node<E> next;

        public Node() {
        }

        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }
    }

    private Node<E> top;
    private int size;

    public LinkStack(){
        top = null;
    }

    public int length(){
        return size;
    }

    public boolean empty(){
        return size == 0;
    }

    public boolean push(E e){
        top = new Node<>(e,top);
        size++;
        return true;
    }

    public E pop(){
        if (empty()){
            throw new RuntimeException("栈空");
        }

        Node<E> value = top;
        top = top.next;
        value.next = null;
        size--;

        return value.e;
    }
}
