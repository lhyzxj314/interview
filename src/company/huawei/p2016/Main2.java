package company.huawei.p2016;

import java.util.Scanner;
import java.util.*;

/**
 * 明明的随机数
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作。
 * @author xshrimp
 * 2017年8月9日
 */
public class Main2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {
      TreeSet<Integer> tSet = new TreeSet<Integer>();
      int num = sc.nextInt();
      if (num > 0) {
        for (int i = 0; i < num; i++) {
          tSet.add(sc.nextInt());
        }
      }
      // 排序
      for (Integer i : tSet) {
        System.out.println(i);
      }

    }
    sc.close();
  }

}
