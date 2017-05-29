package array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 调整数组位置使奇数位于偶数前面
 * 
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * @author xshrimp 2017年5月29日
 */
public class OddAndEven {
  public void reOrderArray1(int[] array) {
    if (array == null)
      throw new IllegalArgumentException("非法输入");

    int len = array.length;
    LinkedList<Integer> odd = new LinkedList<Integer>();
    LinkedList<Integer> even = new LinkedList<Integer>();

    int i = 0;
    while (i < len) {
      if (array[i] % 2 != 0)
        odd.addLast(array[i]);
      else
        even.addLast(array[i]);
      i++;
    }

    i = 0;
    for (Integer num : odd)
      array[i++] = num;
    for (Integer num : even)
      array[i++] = num;

  }

  public void reOrderArray2(int[] array) {
    if (array == null)
      throw new IllegalArgumentException("非法输入");

    int len = array.length;
    int[] cache = new int[len];

    int index = 0;
    for (int i = 0; i < len; i++)
      if (array[i] % 2 != 0)
        cache[index++] = array[i];

    for (int i = 0; i < len; i++)
      if (array[i] % 2 == 0)
        cache[index++] = array[i];

    for (int i = 0; i < len; i++)
      array[i] = cache[i];
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
    OddAndEven obj = new OddAndEven();
    obj.reOrderArray1(arr);
    System.out.println(Arrays.toString(arr));

    arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
    obj.reOrderArray2(arr);
    System.out.println(Arrays.toString(arr));
  }
}
