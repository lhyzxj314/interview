package company.huawei;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * 华为2017优招机试第一题:
 * 给定一个字符串，判断是否括号是否成对出现，且嵌套正确
 * 
 * @author xshrimp
 * 2017年7月13日
 */
public class Main1 {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    sc.close();
    
    System.out.println(judge(input));
  }
  
  private static boolean judge(String input) {
    if (input.length() == 0) return true;
    if (input.length() == 1) return false;
    
    Map<Character, Character> st = new HashMap<Character, Character>();
    st.put('}', '{');
    st.put(')', '(');
    st.put(']', '[');
    
    LinkedList<Character> stack = new LinkedList<Character>();
    for (int i = 0; i < input.length(); i++) {
      char key = input.charAt(i);
      
      if (st.containsKey(key)) {
        Character value = st.get(key);
        if (value != stack.peekLast())
          return false;
        else
          stack.pollLast();
      } else if (key == '{' || key == '[' || key == '(') {
        stack.addLast(key);
      }
    }
    return stack.isEmpty();
  }
}
