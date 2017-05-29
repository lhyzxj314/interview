package num_theory;

import java.util.*;

/**
 * 魔力环(快速矩阵幂解法)
 * 
 * @author xshrimp 2017年4月4日
 */
public class FastPow {

  static class Matrix {
    final int N;
    final int M;
    int[][] elems;

    Matrix(int n, int m) {
      N = n;
      M = m;
      elems = new int[N][M];
    }

    public static Matrix multiply(Matrix A, Matrix B) {
      if (A.M != B.N)
        throw new RuntimeException("矩阵规格不符合要求");
      int N = A.N;
      int M = B.M;
      Matrix res = new Matrix(N, M);
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          for (int m = 0; m < A.M; m++) {
            res.elems[i][j] += A.elems[i][m] * B.elems[m][j];
          }
        }
      }
      return res;
    }
    
    public Matrix mod(int B) {
      if (B == 0)
        throw new RuntimeException("除数为0");
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            elems[i][j] = elems[i][j] % 100;
        }
      }
      return this;
    }

    public String toString() {
      StringBuilder res = new StringBuilder();
      res.append("Matrix:\n");
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          res.append(elems[i][j] + " ");
        }
        res.append("\n");
      }
      return res.toString();
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String firstLine = scan.nextLine();
    String secondLine = scan.nextLine();
    scan.close();
    int n = Integer.parseInt(firstLine.split(" ")[0]);
    int k = Integer.parseInt(firstLine.split(" ")[1]);

    Matrix res = new Matrix(n, 1);
    String[] elemsStr = secondLine.split(" ");
    for (int i = 0; i < n; i++) {
      res.elems[i][0] = Integer.parseInt(elemsStr[i]);
    }
    // 构造转移矩阵
    Matrix matrix = new Matrix(n, n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          matrix.elems[i][i] = 1;
          if (i != 0)
            matrix.elems[i - 1][i] = 1;
        } 
        else 
        if (i == n - 1 && j == 0)  {
          matrix.elems[i][j] = 1;
        }
      }
    }
    
    //System.out.println(res);
    //System.out.println(matrix);
    
    // 快速矩阵幂算法
    while (k != 0) {
      if ((k & 1) == 1) {
        res = Matrix.multiply(matrix, res).mod(100);
      }
      matrix = Matrix.multiply(matrix, matrix).mod(100);
      k = k >> 1;
    }
   
    for (int i = 0; i < n - 1; i++) {
     System.out.print(res.elems[i][0] + " "); 
    }
    System.out.print(res.elems[n - 1][0]);
  }
}