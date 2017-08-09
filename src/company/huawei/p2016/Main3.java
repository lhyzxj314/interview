package company.huawei.p2016;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 进制转换
 * 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 * @author xshrimp
 * 2017年8月9日
 */
public class Main3 {
  private static Map<Character, Integer> table;
  
  public static void main(String[] args) {
    initTable();
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      String hexStr = sc.nextLine();
      handle(hexStr);
    }
    sc.close();
  }
  
  private static void handle(String hexStr) {
    String valueStr = hexStr.substring(2);
    int dexValue = 0;
    int weight = 1;
    for (int i = valueStr.length() - 1; i >= 0; i--) {
      char c = valueStr.charAt(i);
      dexValue += table.get(c) * weight;
      weight *= 16;
    }
    System.out.println(dexValue);
  }
  
  private static void initTable() {
    table = new HashMap<Character, Integer>();
    table.put('0', 0);
    table.put('1', 1);
    table.put('2', 2);
    table.put('3', 3);
    table.put('4', 4);
    table.put('5', 5);
    table.put('6', 6);
    table.put('7', 7);
    table.put('8', 8);
    table.put('9', 9);
    table.put('A', 10);
    table.put('B', 11);
    table.put('C', 12);
    table.put('D', 13);
    table.put('E', 14);
    table.put('F', 15);
  }
}
