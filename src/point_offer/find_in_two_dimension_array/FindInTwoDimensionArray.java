package point_offer.find_in_two_dimension_array;

/**
 * 二维数组(n*m)中的查找：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例：下面的二维数组就是每行、每列都是递增排序，如果在这个数组中查找数字7，则放回true；如果查找数字5，由于数组不含该数字，则返回false。
 *
 * 1 3 8 9
 * 2 4 6 12
 * 4 7 10 13
 * 6 8 11 15
 * @author xshrimp 2022/5/16
 */
public class FindInTwoDimensionArray {
  /**
   * 解法1：从左下角开始查找
   * 时间复杂度：O(n+m)
   * 空间复杂度：O(1)
   * @param target
   * @param array
   * @return
   */
  public boolean solution1(int target, int[][] array) {
      if (array == null || array.length == 0 || array[0].length == 0)
          return false;

      int n = array.length;
      int m = array[0].length;
      int i = n - 1;
      int j = 0;
      while (i >= 0 && j <= m - 1) {
            if (array[i][j] == target) {
                return true;
            } else if (target < array[i][j]) {
                i--;
            } else {
                j++;
            }
      }
      return false;
  }

  /**
   * 解法2：使用二分查找
   * 时间复杂度：O(nlogm)
   * 空间复杂度：O(1)
   * @param target
   * @param array
   * @return
   */
  public boolean solution2(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0)
            return false;

        for (int i = 0; i < array.length; i++) {
            boolean result = binarySearch(target, array[i], 0, array[i].length - 1);
            if (result == false)
                continue;
            else {
                return true;
            }
        }

        return false;
  }

  public boolean binarySearch(int target, int[] array, int start, int end) {
        if (array == null || array.length == 0)
            return false;

        if (start > end)
            return false;

        int mid = ((end - start) / 2) + start;
        if (array[mid] == target)  {
            return true;
        } else if (array[mid] > target) {
            return binarySearch(target, array, start, mid - 1);
        } else if (array[mid] < target) {
            return binarySearch(target, array, mid + 1, end);
        }
        return false;
  }

    /**
     * 解法3：从右上角开始查找(与方法2类似)
     * 时间复杂度：O(n+m)
     * 空间复杂度：O(1)
     * @param target
     * @param array
     * @return
     */
    public boolean solution3(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0)
            return false;

        int n = array.length;
        int m = array[0].length;
        int i = 0;
        int j = m - 1;
        while (i <= n - 1 && j >= 0) {
            if (array[i][j] == target) {
                return true;
            } else if (target < array[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
  
  public static void main(String[] args) {
        FindInTwoDimensionArray obj = new FindInTwoDimensionArray();
        boolean res = obj.solution2(5, new int[][] {{1,2,3},{4,5,6}});
        System.out.println(res);
  }
}