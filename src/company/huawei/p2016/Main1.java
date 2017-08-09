package company.huawei.p2016;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 汽水瓶
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？ 
 * @author xshrimp
 * 2017年8月9日
 */
public class Main1 {
  public static void solution(Integer n) {
    int res = 0;
    int emptyNum = n;
    int fullNum = 0;
    while (emptyNum > 2) {
      fullNum = emptyNum/3;
      res += fullNum;
      emptyNum = emptyNum%3 + fullNum;
    }
    if (emptyNum == 2) res += 1;
    System.out.println(res);
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 获取输入
    List<Integer> inputs = new LinkedList<Integer>();
    while (sc.hasNextLine()) {
      String str = sc.nextLine();
      Integer n = Integer.parseInt(str);
      if (n != 0)
        inputs.add(n);
      else
        break;
    }
    sc.close();
    // 处理问题
    for (Integer n : inputs)
      solution(n);
  }
}
