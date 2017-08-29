package netease.p2018;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 等差数列
 * 如果一个数列S满足对于所有的合法的i,都有S[i + 1] = S[i] + d, 这里的d也可以是负数和零,我们就称数列S为等差数列。
 * 小易现在有一个长度为n的数列x,小易想把x变为一个等差数列。小易允许在数列上做交换任意两个位置的数值的操作,并且交换操作允许交换多次。但是有些数列通过交换还是不能变成等差数列,小易需要判别一个数列是否能通过交换操作变成等差数列 
 * @author xshrimp
 * 2017年8月29日
 */
public class Main2 {
  public static void main(String[] args) {
    // 处理输入
    Scanner sc = new Scanner(System.in);
    int len = sc.nextInt();
    
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(len);
    for (int i = 0; i < len; i++)
      queue.add(sc.nextInt());
    sc.close();
    
    // 异常输入
    if (len <= 2) {
      System.out.println("Impossible");
      sc.close();
      return;
    }
    
    // 等差数列判断
    int d = Integer.MAX_VALUE;
    int pre = queue.poll();
    while (!queue.isEmpty()) {
        if (d == Integer.MAX_VALUE) {
          d = queue.peek() - pre;
        } else if (d != queue.peek() - pre) {
          System.out.println("Impossible");
          return;
        }
        pre = queue.poll();
    }
    System.out.println("Possible");
  }
}
