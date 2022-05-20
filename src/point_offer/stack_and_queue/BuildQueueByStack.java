package point_offer.stack_and_queue;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class BuildQueueByStack {

    /**
     * 自己的解法，不是最优解
     */
    public class Queue1 {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(node);
        }

        public int pop() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    /**
     * 标准答案
     */
    public class Queue2 {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    int a = stack1.pop();
                    stack2.push(a);
                }
            }

            return stack2.pop();
        }
    }
}
