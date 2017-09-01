package company.meituan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 分组发试卷互评，求访问顺序，使1.不能出现评自己试卷的情况；2.不能使没有试卷分发。
 * @author xshrimp
 * 2017年9月1日
 */
public class Main2 {
  public static void main(String[] args) {
    // 获取输入
    Scanner sc = new Scanner(System.in);
    int str = sc.nextInt();
    List<Integer> sortedList = new ArrayList<Integer>();
    for (int i = 0; i < str; i++) {
      sortedList.add(sc.nextInt());
    }
    sc.close();
    
    // 排序
    Collections.sort(sortedList);
    
    int lastIndex = sortedList.size() - 1;
    int lastElem = sortedList.get(lastIndex);
    // 求和
    int sum = 0;
    for (Integer i : sortedList)
      sum += i;
    if (sum -  lastElem < lastElem) {
      System.out.println("No");
    } else {
      System.out.println("Yes");
    }
  }
}
