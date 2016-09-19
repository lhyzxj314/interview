package path_problem;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class MazePath2 {
  private static final int WALL      = 0;    // 墙
  private static final int PATH      = 1;    // 可移动的路径
  private static final int CHEESE    = 9;    // 奶酪
  
  private int[][] grid;      // 迷宫
  private final int x_len;   // 迷宫行数
  private final int y_len;   // 迷宫列数
  private int x;             // 奶酪位置横坐标
  private int y;             // 奶酪位置纵坐标
  
  public MazePath2(int[][] grid) {
    this.grid = grid;
    x_len = grid.length;
    y_len = grid[0].length;
    x = Integer.MIN_VALUE;
    y = Integer.MAX_VALUE;
  }
  
  public boolean isPath() {
    if (grid == null || grid[0][0] == WALL) // 处理异常输入
      return false;
    
    // 并查集数据结构
    WeightedQuickUnionUF uf = new WeightedQuickUnionUF(x_len * y_len);
    // 初始化各位置连通性
    for (int i = 0; i < x_len; i++) {
      for (int j = 0; j < y_len; j++) {
        
        if (grid[i][j] != WALL) {
          
          // 找到奶酪所在位置
          if (grid[i][j] == CHEESE) {
            x = i;
            y = j;
          }
          
          if (i > 0 && grid[i - 1][j] == PATH) {
            uf.union(transferIndex(i, j), transferIndex(i-1, j));
          }
          if (i < x_len-1 && grid[i + 1][j] == PATH) {
            uf.union(transferIndex(i, j), transferIndex(i+1, j));
          }
          if (j > 0 && grid[i][j - 1] == PATH) {
            uf.union(transferIndex(i, j), transferIndex(i, j-1));
          }
          if (j < y_len-1 && grid[i][j + 1] == PATH) {
            uf.union(transferIndex(i, j), transferIndex(i, j+1));
          }
        }
        
      }
    }
    
    if ((x | y) < 0)  return false; // 迷宫内无奶酪
    
    // 返回起点和奶酪位置的连通性
    return uf.connected(transferIndex(0, 0), transferIndex(x, y));
  }
  
  private int transferIndex(int i, int j) {
    return i * y_len + j;
  }
    
  public static void main(String[] args) {
   // int[][] grid = new int[][]{{1, 0, 1}, {1, 0, 0}, {1, 1, 9}};
    int[][] grid = new int[][]
        {{1, 0, 9, 1, 1, 0, 0, 1}, 
         {0, 0, 0, 0, 1, 1, 1, 1}, 
         {1, 0, 0, 0, 0, 0, 0, 1},
         {1, 0, 1, 0, 0, 0, 0, 0},
         {1, 1, 0, 0, 1, 0, 1, 1},
         {1, 0, 1, 0, 0, 1, 0, 1},
         {1, 0, 0, 0, 0, 1, 0, 1},
         {1, 1, 1, 1, 1, 1, 1, 1}};

    MazePath2 obj = new MazePath2(grid);
    System.out.println(obj.isPath());
  }
    
   
}
