package P005;

import java.util.Stack;

/**
 * Created by tonyke on 14/10/2018
 * 用两个栈实现队列
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) stack2.push(stack1.pop());
        }

        return stack2.pop();
    }
}
