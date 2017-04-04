package tencent_internal;

import java.util.Scanner;

/**
 * 求输入字符串的最大回文自序列长度（动态规划金解法）
 * 
 * @author xshrimp
 * 2017年4月3日
 */
public class MaxLoopStrDp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String input = sc.nextLine();
      
      int res = longestLoopStr(input);
      
      System.out.println(input.length() - res);
    }
    sc.close();
  }

  static int longestLoopStr(String str) {
    int length = str.length();
    // 转化成字符串
    char[] chars = str.toCharArray();
    StringBuilder strb = new StringBuilder(str);
    char[] revChars = strb.reverse().toString().toCharArray();
    
    // table[i][j]表示子串chars[0->i]与revChars[0->j]之间最大公共子序列长度
    int[][] table = new int[length][length]; 
    if (chars[0] == revChars[0]) table[0][0] = 1; 
    // 初始化dp表格
    for (int i = 1; i < length; i++) {
      if (chars[0] == revChars[i])
        table[0][i] = 1;
      else
        table[0][i] = table[0][i - 1];
    }
    for (int i = 1; i < length; i++) {
      if (revChars[0] == chars[i])
        table[i][0] = 1;
      else
        table[i][0] = table[i - 1][0];
    }
    
    // 计算dp表格
    for (int i = 1; i < length; i++) {
      for (int j = 1; j < length; j++) {
        if (chars[i] == revChars[j])
          table[i][j] = table[i - 1][j - 1] + 1;
        else
          table[i][j] = max(table[i - 1][j], table[i][j - 1]);
      }
    }
    
   return table[length - 1][length - 1];
  }
  
  private static int max(int... arr) {
    int res = Integer.MIN_VALUE;
    for (int a : arr) {
      if (a > res) res = a;
    }
    return res;
  }
  
}
