package string;

import java.util.LinkedList;

/**
 * 左移字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * @author xshrimp
 * 2017年7月5日
 */
public class LeftRotateString {
  public String leftRotateString(String str,int n) {
    if (str == null || "".equals(str))
      return str;
    
    int len = str.length();
    // 新建链表数据结构
    LinkedList<Character> chList = new LinkedList<Character>();
    for (int i = 0; i < len; i++)
      chList.addLast(str.charAt(i));
    // 循环左移
    n %= len;
    for (int i = 0; i < n; i++) {
      char ch = chList.removeFirst();
      chList.addLast(ch);
    }
    
    // 重建字符串
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++)
      sb.append(chList.get(i));
    return sb.toString();
  }
}
