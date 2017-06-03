package array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 把数组排成最小的数
 * 
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author xshrimp
 * 2017年5月30日
 */
public class MinNumber {
  
  public String PrintMinNumber(int[] numbers) {
    if (numbers == null || numbers.length == 0)
      return "";
    
    PriorityQueue<String> pq = new PriorityQueue<String>(numbers.length, new Comparator<String>() {
     
      /*
       * 比较标准： 若(str1 + str2) < (str2 + str1),则str1较小
       * 应将str1优先做拼接
       */
      @Override
      public int compare(String str1, String str2) {
        String s1 = str1 + str2;
        String s2 = str2 + str1;
          
        int res = s1.compareTo(s2); 
        
        return res;
      }
    });
    
    for (int n : numbers)
      pq.add(Integer.toString(n));
      
    StringBuilder res = new StringBuilder();
    while (pq.peek() != null)
      res.append(pq.remove());
    
    return res.toString();
  }
  
  public static void main(String[] args) {
    MinNumber min = new MinNumber();
    int[] nums = new int[] { 3, 32, 321 };
    //int[] nums = new int[] { 3,2,1 };
    String res = min.PrintMinNumber(nums);
    System.out.println(res);
  }
}
