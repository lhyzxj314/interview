package path_problem;

import java.util.Stack;

public class MazePath {
  private static final int PASSED   = -1;    // 已经过标识
  private static final int WALL      = 0;    // 墙
  //private static final int PATH      = 1;    // 可移动的路径
  private static final int CHEESE    = 9;    // 奶酪
  
  private static final int STEP_FORWARD = 1;  // 向前一步
  private static final int STEP_BACK    = -1; // 向后一步
  
  private int[][] grid;      // 迷宫
  private final int x_len;   // 迷宫行数
  private final int y_len;   // 迷宫列数
  private int x;             // 当前位置横坐标
  private int y;             // 当前位置纵坐标
  
  public MazePath(int[][] grid) {
    this.grid = grid;
    x_len = grid.length;
    y_len = grid[0].length;
  }
  
  public boolean isPath() {
    if (grid == null || grid[x][y] == WALL) // 处理异常输入
      return false;
    
    Stack<Point> stack = new Stack<Point>(); // 栈，用于记录已经过的位置
    stack.push(new Point(x, y));
    
    // 开始寻找奶酪
    while (!stack.isEmpty()) {
      // 判断当前位置是否有奶酪，有则返回true，无则将当前位置标记为已经过
      if (grid[x][y] == CHEESE) return true;
      else                      grid[x][y] = PASSED;
      
      // 可以向左走一步
      if (y > 0 
          && grid[x][y - 1] != PASSED 
          && grid[x][y - 1] != WALL) {
         turn_left();
         stack.push(new Point(x, y));
         continue;
      }
      // 可向右走一步
      if (y < y_len-1 
          && grid[x][y + 1] != PASSED
          && grid[x][y + 1] != WALL) {
        turn_right();
        stack.push(new Point(x, y));
        continue;
      }
      // 可向上走一步
      if (x > 0 
          && grid[x - 1][y] != PASSED
          && grid[x - 1][y] != WALL) {
        turn_up();
        stack.push(new Point(x, y));
        continue;
      }
      // 可向下走一步
      if (x < x_len-1 
          && grid[x + 1][y] != PASSED
          && grid[x + 1][y] != WALL) {
        turn_down();
        stack.push(new Point(x, y));
        continue;
      }
      
      // 无可前进方向，返回上一位置
      Point pos = stack.pop();
      x = pos.i;
      y = pos.j;
    }
    return false; // 所有路径已探索完，未找到奶酪
  }
  
  private void turn_left() {
    if (y <= 0) {
      throw new IllegalArgumentException("Go left when y =" + y);
    }
    y = y + STEP_BACK;
  }
  
  private void turn_right() {
    if (y >= y_len - 1) {
      throw new IllegalArgumentException("Go right when y =" + y);
    }
    y = y + STEP_FORWARD;
  }
  
  private void turn_up() {
    if (x <= 0) {
      throw new IllegalArgumentException("Go up when x =" + x);
    }
    x = x + STEP_BACK;
  }
  
  private void turn_down() {
    if (x >= x_len - 1) {
      throw new IllegalArgumentException("Go down when x =" + x);
    }
    x = x + STEP_FORWARD;
  }
  
  // 内部类：已经过的位置
  class Point {
    private int i;
    private int j;
    
    public Point(int i, int j) {
      this.i = i;
      this.j = j;
    }
    
    public String toString() {
      return "(" + i +", " + j +")";
    }
  }
    
  public static void main(String[] args) {
    int[][] grid = new int[][]
        {{1, 1, 1, 1, 1, 0, 0, 1}, 
         {1, 0, 0, 0, 1, 1, 1, 1}, 
         {1, 0, 0, 0, 0, 0, 0, 1},
         {0, 0, 1, 0, 0, 0, 0, 9},
         {1, 1, 1, 0, 1, 1, 0, 0},
         {1, 0, 1, 0, 0, 1, 0, 1},
         {1, 0, 0, 0, 0, 1, 0, 1},
         {1, 1, 1, 1, 1, 1, 1, 1}};

    MazePath obj = new MazePath(grid);
    System.out.println(obj.isPath());
  }
    
   
}
