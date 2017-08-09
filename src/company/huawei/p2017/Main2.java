package company.huawei.p2017;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 华为优招第二题
 * 任务调度，输入任务队列(数字代表优先级)
 * 当队首优先级最大时，处理该任务；否则，放到队尾
 * 输出任务处理的索引顺序
 * @author xshrimp
 * 2017年7月15日
 */
public class Main2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String inputStr = sc.nextLine();
    sc.close();
    
    Queue<Task> queue = new LinkedList<Task>();
    PriorityQueue<Task> maxHeap = new PriorityQueue<Task>();
    String[] numStrs = inputStr.split(", ");
    int len = numStrs.length;
    // 特殊情况
    if (len == 0)  return;
    
    // 构造任务队列和最大堆
    for (int i = 0; i < len; i++) {
      int priority = Integer.valueOf(numStrs[i]);
      Task t = new Task(i, priority);
      queue.offer(t);
      maxHeap.offer(t);
    }
    
    // 模拟任务调度过程
    List<Task> res = new LinkedList<Task>();
    while (!queue.isEmpty()) {
      if (queue.size() == 1) {
        res.add(queue.poll());
        break;
      }
      
      if (queue.peek().priority < maxHeap.peek().priority) {
        queue.offer(queue.poll());
      } else if (queue.peek().priority > maxHeap.peek().priority) {
        res.add(queue.poll());
      } else {
        res.add(queue.poll());
        maxHeap.remove();
      }
    }
    
    // 输出结果
    for (int i = 0; i < res.size(); i++) {
      if (i != res.size() - 1)
        System.out.print(res.get(i).index + ", ");
      else
        System.out.println(res.get(i).index);
    }
  }
  
  private static class Task implements Comparable<Task> {
    private int priority;
    private int index;
    
    public Task(int index, int priority) {
      this.index = index;
      this.priority = priority;
    }

    @Override
    public int compareTo(Task o) {
      if (this.priority < o.priority)
        return 1;
      else if (this.priority > o.priority)
        return -1;
      else return 0;
    }
  }
}
