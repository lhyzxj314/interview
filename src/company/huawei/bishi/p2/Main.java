package company.huawei.bishi.p2;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String input = sc.nextLine();
    sc.close();
    if (input == null || input.length() == 0) {
      System.out.println("!error");
      return;
    }
    if (input.length() == 1) {
      char c = input.charAt(0);
      if (!validate(c)) {
        System.out.println("!error");
        return;
      } else {
        System.out.println(c);
        return;
      }
    }

    if ('3' <= input.charAt(input.length() - 1) && input.charAt(input.length() - 1) <= '9') {
      System.out.println("!error");
      return;
    }

    int count = 0;
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < input.length() - 1; i++) {
      char pre = input.charAt(i);
      char last = input.charAt(i + 1);
      if (!validate(pre) || !validate(last)) {
        System.out.println("!error");
        return;
      }

      if ('3' <= pre && pre <= '9') {
        if ('3' <= last && last <= '9') {
          System.out.println("!error");
          return;
        } else {
          count = 0;
          for (int j = 0; j < pre - '0'; j++) {
            res.append(last);
          }
          i++;
        }
      } else if ('a' <= pre && pre <= 'z') {
        if (pre == last)
          count++;
        else
          count = 0;

        if (count >= 2) {
          System.out.println("!error");
          return;
        }
        res.append(pre);
      }
    }

    char pre = input.charAt(input.length() - 2);
    char last = input.charAt(input.length() - 1);
    if (!validate(last)) {
      System.out.println("!error");
      return;
    }

    if ('3' <= pre && pre <= '9') {
      System.out.println(res.toString());
    } else {
      res.append(last);
      System.out.println(res.toString());
    }
  }

  private static boolean validate(char c) {
    if ('3' <= c && c <= '9')
      return true;
    else if ('a' <= c && c <= 'z')
      return true;
    else
      return false;
  }
}
