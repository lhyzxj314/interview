package stack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 栈的压入、弹出序列
 * 
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * @author xshrimp
 * 2017年5月30日
 */
public class PopOrder {
  public boolean IsPopOrder(int [] pushA,int [] popA) {
    if (pushA == null || popA == null || pushA.length != popA.length)
      return false;
    
    Set<Integer> set = new HashSet<Integer>();
    for (int n : pushA)
      set.add(n);
   
    for (int n : popA)
      if (!set.contains(n))
        return false;
    
    LinkedList<Integer> stack = new LinkedList<Integer>();
    int j = 0;
    int i = 0;
    while (j < popA.length) {
      if (!stack.contains(popA[j])) {
        stack.addLast(pushA[i]);
        i++;
      } else {
        if (stack.getLast() == popA[j]) {
          stack.removeLast();
          j++;
        } else
          return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    PopOrder obj = new PopOrder();
//    int[] pushA = new int[] {1,2,3,4,5};
//    int[] popA  = new int[] {4,5,3,1,2};
    int[] pushA = new int[] {1};
    int[] popA  = new int[] {2};
    boolean res = obj.IsPopOrder(pushA, popA);
    System.out.println(res);
  }
}
