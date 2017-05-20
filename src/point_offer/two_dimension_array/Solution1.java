package point_offer.two_dimension_array;

/**
 * 二维数组(n*m)中的查找：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 解法一：使用二分查找           时间复杂度：O(nlogm)
 * @author xshrimp
 * 2017年5月19日
 */
public class Solution1 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0)
          return false;

        int xLen = array[0].length;
        int yLen = array.length;
        for (int i = 0; i < yLen; i++) {
            if (binarySearchX(target, i, array, 0, xLen - 1))
               return true;
            else
               continue;
        }
        return false;
  }

  private boolean binarySearchX(int target, int y, int[][] array, int start, int end) {
    if (start > end)
      return false;

    int mid = start + (end - start) / 2;  // 注意中点的求法
    if (target == array[y][mid])
      return true;
    else if (target < array[y][mid])
      return binarySearchX(target, y, array, start, mid - 1);
    else
      return binarySearchX(target, y, array, mid + 1, end);
  }

}