package company.meituan;

import java.util.Scanner;

/**
 * 求数组元素和是K的倍数的子串的最大长度
 * 
 * 序列中任意个连续的元素组成的子序列称为该序列的子串。
 * 现在给你一个序列P和一个整数K，询问元素和是K的倍数的子串的最大长度。
 * 比如序列【1,2,3,4,5】，给定的整数K为 5，其中满足条件的子串为{5}、{2,3}、{1,2,3,4}、{1,2,3,4,5}，
 * 那么答案就为 5，因为最长的子串为{1,2,3,4,5}；如果满足条件的子串不存在，就输出 0。
 * 
 * 输入：
 * 第一含一个整数N, 1 ≤ N ≤ 105 。
 * 第二行包含 N 个整数pi ，pi表示序列P第i个元素的值。0 ≤ pi ≤ 105 。
 * 第三行包含一个整数 K， 1 ≤ K≤ 105 。
 * @author xshrimp
 * 2017年9月1日
 */
public class Main1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer N = sc.nextInt();
    
    int[] num = new int[N];  // 输入数组
    for (int i = 0; i < N; i++) {
      num[i] = sc.nextInt();
    }
    
    int [] sum = new int[N + 1]; // 前缀和记录
    sum[0] = 0;
    for (int i = 1; i < N + 1; i++)
      sum[i] = num[i - 1] + sum[i - 1];
    
    int K = sc.nextInt();
    sc.close();
    
    System.out.println(getMaxLen(num, sum, K));
  }
  
  private static int getMaxLen(int[] num, int[] sum, int K) {
    int arrayLen = num.length;
    int[] max = new int[K];      // 余数为mod的 最大前缀和下标 为max[mod]
    for (int i = 0; i < K; i++)
      max[i] = Integer.MIN_VALUE;
    int[] min = new int[K];      // 余数为mod的 最小前缀和下标 为min[mod]
    for (int i = 0; i < K; i++)
      min[i] = Integer.MAX_VALUE;
    
    for (int i = 0; i < arrayLen + 1; i++) {
      int mod = sum[i] % K;
      max[mod] = Math.max(max[mod], i);
      min[mod] = Math.min(min[mod], i);
    }
    
    // 符合条件的最大子串长度为 max[mod]-min[mod] 的最大值
    int maxLen = 0;
    for (int mod = 0; mod < K; mod++) {
      if (max[mod] != Integer.MIN_VALUE && min[mod] != Integer.MAX_VALUE)
        maxLen = Math.max(maxLen, max[mod] - min[mod]);
    }
    return maxLen;
  }
}
