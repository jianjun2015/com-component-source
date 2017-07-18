package component.stack;

/**
 * Created by wangjianjun on 2017/7/17.
 */
public class MyStack<E> {

    private Object[] data = null;
    private int maxSize = 0;//栈容量
    private int top = -1;//栈顶指针

    public MyStack() {
        this(10);
    }

    public MyStack(int initialSize){
        if (initialSize >= 10){
            this.maxSize = initialSize;
            data = new Object[initialSize];
            top = -1;
        }else {
            throw new RuntimeException("初始化大小不能小于0:"+initialSize);
        }
    }

    public boolean empty(){
        return top==-1?true:false;
    }

    public boolean full(){
        return top+1 == maxSize ? true:false;
    }

    //压栈
    public boolean push(E e){
        if (top == maxSize-1){
            throw new RuntimeException("栈满");
        }else {
            data[++top] = e;
            return true;
        }
    }

    //查看元素不删除
    public E peek(){
        if (top == -1){
            throw new RuntimeException("栈空");
        }else {
            return (E) data[top];
        }
    }

    //出栈
    public E pop(){
        if (top == -1){
            throw new RuntimeException("栈空");
        }else {
            return (E) data[top--];
        }
    }

    public int Size(){
        return maxSize;
    }

    public int getDataSize(){
        return top+1;
    }

    //返回对象在栈的位置
    public int search(E e){
        int i=top;
        while (top != -1){
            if (peek() != e){
                top--;
            }else {
                break;
            }
        }

        int result = top+1;
        top = i;
        return result;
    }
}
