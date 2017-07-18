package component.stack;

import java.util.Stack;

/**
 * 得到栈的最小值
 * Created by wangjianjun on 2017/7/17.
 */
public class StackMinValue {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> stackMin = new Stack<Integer>();
        Stack<Integer> stackMax = new Stack<Integer>();
        pushStack(stack,stackMin,10);
        pushStack(stack,stackMin,7);
        pushStack(stack,stackMin,6);
        pushStack(stack,stackMin,4);
        pushStack(stack,stackMin,8);
        pushStack(stack,stackMin,3);
        pushStack(stack,stackMin,1);
        pushStack(stack,stackMin,2);
        System.out.println("当前stack:"+stack);
        System.out.println("stack下标对应的栈:"+stackMin);
        popStack(stack,stackMin);
        System.out.println("第1次移除操作后stack:"+stack);
        System.out.println("第1次移除操作后stack下标对应的栈:"+stackMin);
        popStack(stack,stackMin);
        System.out.println("第2次移除操作后stack:"+stack);
        System.out.println("第2次移除操作后stack下标对应的栈:"+stackMin);
        popStack(stack,stackMin);
        System.out.println("第3次移除操作后stack:"+stack);
        System.out.println("第3次移除操作后stack下标对应的栈:"+stackMin);
        popStack(stack,stackMin);
        System.out.println("第4次移除操作后stack:"+stack);
        System.out.println("第4次移除操作后stack下标对应的栈:"+stackMin);
        popStack(stack,stackMin);
        System.out.println("第5次移除操作后stack:"+stack);
        System.out.println("第5次移除操作后stack下标对应的栈:"+stackMin);
        System.out.println("stack中最小值:"+getMin(stack,stackMin));
    }
    /**
     * /**
     * 先进栈：
     * 1:创建2个栈，一个栈放元素（stack），另外一个栈放元素下标(stakcBackUp)
     * 2:向stack中放入元素时，先与stakcBackUp顶部元素（代表stack下标）所对应的stack元素比较
     *
     *
     * @param stack
     * @param stackMin
     * @param i
     */
    public static void pushStack(Stack<Integer> stack,Stack<Integer> stackMin,int i){
        if(stack.isEmpty()){//第一次放进去的值默认最小
            stack.push(i);
            stackMin.push(0);
        }else if(stack.get(stackMin.peek())<i){
            stack.push(i);
        }else{
            stack.push(i);
            stackMin.push(stack.size()-1);
        }
    }
    /**
     * 出栈操作
     * 先明确：栈的原则（是一种先进后出的集合）
     * 当从stack中出栈时，先与stackMin栈顶元素对应的值进行比较，若相同则说明此时
     * stack出战的为最小值，同时将stackMin栈顶元素移除
     * 反之仅移除stack，stackMin不动
     */
    public static void popStack(Stack<Integer> stack,Stack<Integer> stackMin){
        if(stack.peek()==stack.get(stackMin.peek())){
            stackMin.pop();
            stack.pop();
        }else{
            stack.pop();
        }
    }
    /**
     * 3:总结stackMin最上面的下标对应的stack中的元素最小
     * @param stack
     * @param stackMin
     * @return
     */
    public static int getMin(Stack<Integer> stack,Stack<Integer> stackMin){
        return stack.get(stackMin.peek());
    }
}
