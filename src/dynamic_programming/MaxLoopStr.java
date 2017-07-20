package dynamic_programming;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 求最大公共字串(并未解决题目问题)
 * @author xshrimp
 * 2017年4月3日
 */
public class MaxLoopStr {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String input = sc.nextLine();
      
      String res = longestLoopStr(input);
      
     // System.out.println(res);
      System.out.println(input.length() - res.length());
      
    }
  }

  private static String longestLoopStr(String input) {
    char[] chars = input.toCharArray();
    char[] revChars = new char[chars.length];
    for (int i = 0; i < chars.length; i++) {
      revChars[chars.length - 1 - i] = chars[i];
    }
    
    LinkedList<Integer> indexs1 = new LinkedList<Integer>();
    LinkedList<Integer> indexs2 = new LinkedList<Integer>();
    for (int i = 0; i < chars.length; i++) {
      if (!indexs1.isEmpty() || !indexs2.isEmpty()) {
        boolean flag = false;
        for (int j = indexs1.getLast() + 1; j <= i - 1; j++) {
          if (revChars[i] == chars[j]) {
            indexs1.add(j);
            indexs2.add(i);
            flag = true;
            break;
          }
        }
        
        if (!flag) {
          for (int j = indexs2.getLast() + 1; j <= i - 1; j++) {
            if (chars[i] == revChars[j]) {
              indexs1.add(i);
              indexs2.add(j);
              flag = true;
              break;
            }
          }
        }
        
        if (!flag) {
          if (chars[i] == revChars[i]) {
            indexs1.add(i);
            indexs2.add(i);
          }
        }
        
      } else {
        for (int j = 0; j <= i; j++) {
          if (revChars[i] == chars[j]) {
            indexs1.add(j);
            indexs2.add(i);
            break;
          }
          
          if (chars[i] == revChars[j]) {
            indexs1.add(i);
            indexs2.add(j);
            break;
          }
          
        }
      }
      
    }
    
    StringBuilder res = new StringBuilder(indexs1.size());
    for (Integer i : indexs1) {
      res.append(chars[i]);
    }
    //System.out.println(res);
    StringBuilder res1 = new StringBuilder(indexs2.size());
    for (Integer i: indexs2) {
      res1.append(revChars[i]);
    }
    //System.out.println(res1);
    return res.toString();
  }

 
}
