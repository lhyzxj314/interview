package stack;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 
 * @author xshrimp 2017年6月3日
 */
public class MinStack {
  private int min = Integer.MAX_VALUE;
  private Stack<Integer> stack;
  private Stack<Integer> minStack;  //辅助栈

  public MinStack() {
    stack = new Stack<Integer>();
    minStack = new Stack<Integer>();
  }

  public void push(int node) {
    if (node < min)
      min = node;
    minStack.push(min);
    stack.push(node);
  }

  public void pop() {
    if (!stack.isEmpty()) {
      stack.pop();
      minStack.pop();
      min = minStack.peek();
    }
  }

  public int top() {
    if (!stack.isEmpty())
      return stack.lastElement();
    return -1;
  }

  public int min() {
    if (!stack.isEmpty())
      return min;
    return -1;
  }
}
