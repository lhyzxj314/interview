package company.huawei.bishi.p1;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      StringBuilder res = new StringBuilder();
      String str = sc.nextLine();
      if (str == null || str.length() == 0)
        System.out.println("");
      
      String[] bcdStrs = str.split(",");
      for (String bcd : bcdStrs) {
        String value = bcd.substring(2);
        for (int i = value.length() - 1; i >= 0; i--) {
          char c = value.charAt(i);
          if (c == 'F') {
            break;
          } else if ('0' <= c && c <= '9'){
            res.append(value.charAt(i));
          }
        }
      }
      System.out.println(res.toString());
    }
    sc.close();
  }
  
}
