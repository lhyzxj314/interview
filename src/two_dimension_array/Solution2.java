package two_dimension_array;

/**
 * 二维数组(n*m)中的查找：
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 解法二：从左下角开始查找，小于则右移，大于则左移           时间复杂度：O(n+m)
 * @author xshrimp
 * 2017年5月19日
 */
public class Solution2 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0)
          return false;

        int xLen = array[0].length;
        int yLen = array.length;
        int i = yLen - 1, j = 0;
        while (0 <= i && j <= xLen - 1) {
          if (array[i][j] == target)
            return true;
          else if (array[i][j] < target)
            j++;
          else
            i--;
        }
        return false;
  }
}