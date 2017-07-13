package company.huawei;

import java.util.Scanner;

/**
 * 华为2017优招第三题:
 * 给定矩阵，每个单元格有若干平安果，问在只能向下或向右移动的情况下，从左上角到右下角能够最多能收集平安果的数量
 * @author xshrimp
 * 2017年7月13日
 */
public class Main3 {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String firstLine = sc.nextLine();
    int N = Integer.parseInt(firstLine.split(" ")[0]);
    int M = Integer.parseInt(firstLine.split(" ")[1]);
    // 读取矩阵grid
    int[][] grid = new int[N][M];
    for (int i = 0; i < N; i++) {
      String[] strs = sc.nextLine().split(" ");
      for (int j = 0; j < M; j++) {
        grid[i][j] = Integer.parseInt(strs[j]);
      }
    }
    sc.close();
    
    // 异常输入
    if (N == 0 || M == 0)
      return;
    // 只有1个元素的特殊情况
    if (N == 1 && M == 1) {
      System.out.println(grid[0][0]);
      return;
    }
    
    // 动态规划表格
    int[][] solu = new int[N][M];
    solu[0][0] = grid[0][0];
    // 计算第一行最优解
    for (int j = 1; j < M; j++)
      solu[0][j] = solu[0][j-1] + grid[0][j];
    // 计算第一列最优解
    for (int i = 1; i < N; i++)
      solu[i][0] = solu[i-1][0] + grid[i][0];
    // 计算其他单元格的最优解
    for (int i = 1; i < N; i++) {
      for (int j = 1; j < M; j++) {
        solu[i][j] = Math.max(solu[i-1][j] + grid[i][j], solu[i][j-1] + grid[i][j]);
      }
    }
    
    // 输出最优解
    System.out.println(solu[N-1][M-1]);
  }
}
