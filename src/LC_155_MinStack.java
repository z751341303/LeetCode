import com.sun.javaws.IconUtil;

import java.util.Stack;

/*
155.最小栈
https://leetcode-cn.com/problems/min-stack/
 */

public class LC_155_MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public LC_155_MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        dataStack.push(val);
    }

    public void pop() {
        if (!minStack.isEmpty() && minStack.peek().equals(dataStack.peek())) {
            minStack.pop();
        }
        dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        LC_155_MinStack obj = new LC_155_MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}




