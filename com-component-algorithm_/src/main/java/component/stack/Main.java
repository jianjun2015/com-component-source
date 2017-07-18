package component.stack;

/**
 * Created by wangjianjun on 2017/7/17.
 */
public class Main {

    public static void main(String[] args) {

//        testStack();
        func_LinkList();

    }

    private static void testStack(){

        MyStack<Integer> stack = new MyStack();
        System.out.println(stack.empty());

        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);
        stack.push(500);
        stack.push(600);
        stack.push(700);
        stack.push(800);
        stack.push(900);
        stack.push(1000);

        System.out.println(stack.empty());
        System.out.println(stack.getDataSize());

        Integer value = stack.peek();
        System.out.println(stack.getDataSize());
        System.out.println(value);

        System.out.println(stack.search(100));

        Integer value_ = stack.pop();
        System.out.println(stack.getDataSize());
        System.out.println(value_);

        stack.push(10000);
        System.out.println(stack.full());

    }

    public static void func_LinkList(){
        LinkStack<Integer> linkStack = new LinkStack<>();
        System.out.println(linkStack.empty());

        linkStack.push(1);
        linkStack.push(2);
        linkStack.push(3);
        linkStack.push(4);
        linkStack.push(5);
        linkStack.push(6);
        linkStack.push(7);

        linkStack.pop();
        Integer value = linkStack.pop();
        System.out.println(value);
    }

}
