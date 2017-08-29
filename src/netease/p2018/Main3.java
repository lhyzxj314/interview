package netease.p2018;

import java.util.Scanner;

/**
 * 交错01串
 * 如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。例如: "1","10101","0101010"都是交错01串。
 * 小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。小易需要你帮帮忙求出最长的这样的子串的长度是多少。 
 * @author xshrimp
 * 2017年8月29日
 */
public class Main3 {
  public static void main(String[] args) {
    // 处理输入
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    sc.close();

    if (str == null || str.length() <= 1) {
      System.out.println("0");
      return;
    }

    // 计算01串长度
    int maxNum = 0;
    int tempNum = 0;
    for (int i = 1; i < str.length(); i++) {
      char pre = str.charAt(i - 1);
      if (pre != str.charAt(i)) {
        tempNum++;
      } else {
        maxNum = maxNum < tempNum ? tempNum : maxNum;
        tempNum = 0;
      }

      if (i == str.length() - 1 && maxNum == 0) {
        maxNum = tempNum;
      }
    }

    System.out.println(maxNum + 1);
  }
}
