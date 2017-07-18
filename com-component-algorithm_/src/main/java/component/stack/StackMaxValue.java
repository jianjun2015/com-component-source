package component.stack;

import java.util.Stack;

/**
 * Created by wangjianjun on 2017/7/17.
 */
public class StackMaxValue {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> stackMax = new Stack<Integer>();
        pushStack(stack,stackMax,10);
        pushStack(stack,stackMax,7);
        pushStack(stack,stackMax,6);
        pushStack(stack,stackMax,4);
        pushStack(stack,stackMax,8);
        pushStack(stack,stackMax,3);
        pushStack(stack,stackMax,11);
        pushStack(stack,stackMax,2);
        System.out.println("当前stack:"+stack);
        System.out.println("stack下标对应的栈:"+stackMax);
        popStack(stack,stackMax);
        System.out.println("第1次移除操作后stack:"+stack);
        System.out.println("第1次移除操作后stack下标对应的栈:"+stackMax);
        popStack(stack,stackMax);
        System.out.println("第2次移除操作后stack:"+stack);
        System.out.println("第2次移除操作后stack下标对应的栈:"+stackMax);
        popStack(stack,stackMax);
        System.out.println("第3次移除操作后stack:"+stack);
        System.out.println("第3次移除操作后stack下标对应的栈:"+stackMax);
        popStack(stack,stackMax);
        System.out.println("第4次移除操作后stack:"+stack);
        System.out.println("第4次移除操作后stack下标对应的栈:"+stackMax);
        popStack(stack,stackMax);
        System.out.println("第5次移除操作后stack:"+stack);
        System.out.println("第5次移除操作后stack下标对应的栈:"+stackMax);
        System.out.println("stack中最大值:"+getMax(stack,stackMax));
    }
    /**
     * /**
     * 先进栈：
     * 1:创建2个栈，一个栈放元素（stack），另外一个栈放元素下标(stakcBackUp)
     * 2:向stack中放入元素时，先与stakcBackUp顶部元素（代表stack下标）所对应的stack元素比较
     *
     *
     * @param stack
     * @param stackMax
     * @param i
     */
    public static void pushStack(Stack<Integer> stack,Stack<Integer> stackMax,int i){
        if(stack.isEmpty()){//第一次放进去的值默认最小
            stack.push(i);
            stackMax.push(0);
        }else if(stack.get(stackMax.peek())<i){
            stack.push(i);
            stackMax.push(stack.size()-1);
        }else{
            stack.push(i);
        }
    }
    /**
     * 出栈操作
     * 先明确：栈的原则（是一种先进后出的集合）
     * 当从stack中出栈时，先与stackMax栈顶元素对应的值进行比较，若相同则说明此时
     * stack出战的为最小值，同时将stackMax栈顶元素移除
     * 反之仅移除stack，stackMax不动
     */
    public static void popStack(Stack<Integer> stack,Stack<Integer> stackMax){
        if(stack.peek()==stack.get(stackMax.peek())){
            stackMax.pop();
            stack.pop();
        }else{
            stack.pop();
        }
    }
    /**
     * 3:总结stackMax最上面的下标对应的stack中的元素最小
     * @param stack
     * @param stackMax
     * @return
     */
    public static int getMax(Stack<Integer> stack,Stack<Integer> stackMax){
        return stack.get(stackMax.peek());
    }
}
