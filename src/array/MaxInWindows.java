package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * @author xshrimp
 * 2017年8月8日
 */
public class MaxInWindows {
  public ArrayList<Integer> maxInWindows(int[] num, int size) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    if (num == null || num.length == 0 || size <= 0 || size > num.length)
      return res;

    for (int i = 0; i <= num.length - size; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = i; j < i + size; j++) {
        if (num[j] > max)
          max = num[j];
      }
      res.add(max);
    }
    return res;
  }

 /* private static class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
      return o2 - o1;
    }
  }*/

  public static void main(String[] args) {
    MaxInWindows obj = new MaxInWindows();
    int[] num = new int[] { 2, 3, 4, 2, 6, 2, 5, 1 };
    // int[] num = new int[] {2,3,4};
    List<Integer> res = obj.maxInWindows(num, 3);
    for (Integer n : res)
      System.out.print(n + " ");
  }
}
