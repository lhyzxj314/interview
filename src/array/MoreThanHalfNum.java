package array;

import java.util.*;

/**
 * 数组中出现次数超过一半的数字
 * 
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author xshrimp
 * 2017年5月29日
 */
public class MoreThanHalfNum {
  
  // 使用符号表HashMap记录各数字出现次数
  public int MoreThanHalfNum_Solution1(int[] array) {
    if (array == null || array.length == 0)
      return 0;

    int len = array.length;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < len; i++) {
      int count = map.get(array[i]) == null ? 0 : map.get(array[i]);
      count++;
      if (count > len / 2)
        return array[i];
      else
        map.put(array[i], count);
    }
    return 0;
  }
  
  // 原理：异数相消，最终剩下的数字即是结果
  public int MoreThanHalfNum_Solution2(int[] array) {
    if (array == null || array.length == 0)
      return 0;
    
    int len = array.length;
    
    int res = array[0];
    int times = 1;
    for (int i = 0; i < len; i++) {
      if (times == 0) {
        res = array[i];
        times = 1;
      } else  {
        if (res != array[i])
          times--;
        else
          times++;
      }
    }
    
    int count = 0;
    for (int elem : array)
      if (elem == res)
        count++;
    
    return count > len / 2 ? res : 0;
  }

  public static void main(String[] args) {
    int[] array = new int[] { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
    MoreThanHalfNum obj = new MoreThanHalfNum();
    int res = obj.MoreThanHalfNum_Solution1(array);
    System.out.println(res);
  }
}
