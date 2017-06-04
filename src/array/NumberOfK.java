package array;

/**
 * 统计一个数字在排序数组中出现的次数。
 * @author xshrimp
 * 2017年6月4日
 */
public class NumberOfK {
  public int GetNumberOfK(int [] array , int k) {
    if (array == null || array.length == 0)
      return 0;
    
    int index = binarySearch(array, k, 0, array.length - 1);
    
    int count = 0;
    if (index != -1) {
      for (int i = index; i < array.length && array[i] == k; i++)
        count++;
      for (int i = index-1; i >= 0 && array[i] == k; i--)
        count++;
    }
    return count;
  }

  /**
   * 二分查找
   * @return -1 未找到
   * @return index 找到则返回元素对应下标
   */
  private int binarySearch(int[] array, int k, int low, int high) {
    if (low > high)
      return -1;
    
    int mid = low + (high - low) / 2;
    if (array[mid] < k)
      return binarySearch(array, k, mid+1, high);
    else if (array[mid] > k)
      return binarySearch(array, k, low, mid-1);
    else
      return mid;
  }
  
  public static void main(String[] args) {
    NumberOfK obj = new NumberOfK();
    int[] array = {1,3,3,3,3,4,5};
    int res = obj.GetNumberOfK(array, 3);
    System.out.println(res);
  }
}
