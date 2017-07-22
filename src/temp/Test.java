package temp;

import java.util.Scanner;
import java.util.Stack;

public class Test {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (fun(s))
        System.out.println("true");
      else
        System.out.println("false");
    }
    sc.close();
  }

  public static boolean fun(String s) {
    if (s.length() == 0)
      return true;
    int a = 0;
    Stack<Character> sta = new Stack<Character>();
    char[] c = s.toCharArray();
    for (char c1 : c) {
      if (c1 == '(' || c1 == '{' || c1 == '[') {
        sta.push(c1);
        a = 1;
      } else if ((c1 == ')' && sta.peek() == '(') || (c1 == ']' && sta.peek() == '[')
          || (c1 == '}' && sta.peek() == '{')) {
        sta.pop();
        a = 1;
      }

    }
    if (a == 0)
      return true;
    if (sta.empty())
      return true;
    else
      return false;
  }

}