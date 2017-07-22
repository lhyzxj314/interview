package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 数组中重复的数
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @author xshrimp
 * 2017年7月5日
 */
public class Duplication {
  
  /**
   * 想法很好，但是可能出现溢出问题
   * @param numbers
   * @param length
   * @param duplication
   * @return
   */
  public boolean duplicate(int numbers[],int length,int [] duplication) {
    if (numbers == null || numbers.length == 0)
      return false;
    
    for (int i = 0; i < length; i++) {
      int index = numbers[i] > length - 1 ? numbers[i] - length : numbers[i];
      if (numbers[index] > length) {
        duplication[0] = numbers[index] - length;
        return true;
      } else {
        numbers[index] += length;
      }
    }
    return false;
  }
  
  public boolean duplicate2(int numbers[],int length,int [] duplication) {
    if (numbers == null || numbers.length == 0)
      return false;
    
    Arrays.sort(numbers);
    for (int i = 0; i < length - 1; i++) {
      if (numbers[i] == numbers[i + 1]) {
        duplication[0] = numbers[i];
        return true;
      }
    }
    return false;
  }
  
  public boolean duplicate1(int numbers[],int length,int [] duplication) {
    Set<Integer> table = new HashSet<Integer>();
    for (int i = 0; i < length; i++) {
      if (table.contains(numbers[i])) {
        duplication[0] = numbers[i];
        return true;
      }
      table.add(numbers[i]);
    }
    return false;
  }
  
  public static void main(String[] args) {
    int[] numbers = new int[] { 3,1,2,4,4 };
    Duplication obj = new Duplication();
    boolean flag = obj.duplicate(numbers, numbers.length, new int[1]);
    System.out.println(flag);
  }
  
  
}
