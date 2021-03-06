package two_dimension_array;

import java.util.ArrayList;
import java.util.List;

/**
 * 顺时针打印矩阵
 * 
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 * @author xshrimp
 * 2017年6月4日
 */
public class PrintMatrix {
  private final static int RIGHT = 0;
  private final static int DOWN = 1;
  private final static int LEFT = 2;
  private final static int UP   = 3;
  
  public ArrayList<Integer> printMatrix1(int[][] matrix) {
    int lenX = matrix[0].length;
    int lenY = matrix.length;
    int num = lenX * lenY;
    boolean[][] flags = new boolean[lenY][lenX];

    ArrayList<Integer> res = new ArrayList<Integer>(num);
    int i = 0;
    int j = 0;
    int direction = RIGHT;
    while (res.size() < num) {
      switch (direction) {
      case RIGHT:
        if (!flags[i][j]) {
          res.add(matrix[i][j]);
          flags[i][j] = true;
          if (j + 1 < lenX && !flags[i][j + 1])
            j++;
          else if (i + 1 < lenY && !flags[i + 1][j]) { // 右侧不通，向下走
            direction = DOWN;
            i++;
          }
        }
        break;
      case DOWN:
        if (!flags[i][j]) {
          res.add(matrix[i][j]);
          flags[i][j] = true;
          if (i + 1 < lenY && !flags[i + 1][j])
            i++;
          else if (j - 1 >= 0 && !flags[i][j - 1]) { // 转向左走
            direction = LEFT;
            j--;
          }
        }
        break;
      case LEFT:
        if (!flags[i][j]) {
          res.add(matrix[i][j]);
          flags[i][j] = true;
          if (j - 1 >= 0 && !flags[i][j - 1])
            j--;
          else if (i - 1 >= 0 && !flags[i - 1][j]) {  // 转向上走
            direction = UP;
            i--;
          }
        }
        break;
      case UP:
        if (!flags[i][j]) {
          res.add(matrix[i][j]);
          flags[i][j] = true;
          if (i - 1 >= 0 && !flags[i - 1][j])
            i--;
          else if (j + 1 < lenX && !flags[i][j + 1]) { // 转向右走
            direction = RIGHT;
            j++;
          }
        }
        break;
      default:
        break;
      }
    }
    return res;
  }
  
  public ArrayList<Integer> printMatrix2(int[][] matrix) {
    if (matrix == null || matrix.length == 0)
      return new ArrayList<Integer>();
    int col = matrix[0].length;
    int row = matrix.length;
    
    int layer = (Math.min(col, row) - 1)/2 + 1;  // 层数
    
    ArrayList<Integer> res = new ArrayList<Integer>(row*col);
    int left = 0, right = col - 1, top = 0, bottom = row - 1;
    for (int i = 0; i < layer; i++) {
      for (int j = i; j <= right-i; j++)            
        res.add(matrix[i][j]);         // 从左向右
      for (int k = i+1; k <= bottom-i; k++)         
        res.add(matrix[k][right - i]); // 从上至下
      for (int m = right-i-1; m >= left+i && bottom-i!=i; m--)     
        res.add(matrix[bottom - i][m]);// 从右向左
      for (int n = bottom-i-1; n >= top+i+1 && right-i!=i; n--)   
        res.add(matrix[n][i]);         // 从下至上
    }
    return res;
  }
  
  public static void main(String[] args) {
    //int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
    int[][] matrix = {{1,2},{3,4},{5,6},{7,8},{9,10}};
    PrintMatrix obj = new PrintMatrix();
    List<Integer> res = obj.printMatrix2(matrix);
    System.out.println(res);
    List<Integer> res1 = obj.printMatrix1(matrix);
    System.out.println(res1);
  }
}
