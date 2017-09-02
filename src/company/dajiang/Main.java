package company.dajiang;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Integer n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      List<Integer> cards = new LinkedList<Integer>();
      String num = new Integer(sc.nextInt()).toString();
      cards.add(sc.nextInt());
      cards.add(sc.nextInt());
      cards.add(sc.nextInt());
      new Main().getMax(num, cards);
    }
    sc.close();
  }
  
  private void getMax(String num, List<Integer> cards) {
    if (num == null || cards.size() != 3)
      throw new IllegalArgumentException();
    
    if (num.isEmpty()) {
      System.out.println(0);
      return;
    }
      
    cards.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        if(o1 > o2)        return -1;
        else if (o1 < o1)  return 1;
        return 0;
      }
    });
    
    for (int k = 0; k < 3; k++) {
      for (int i = 0; i < num.length(); i++) {
        char c = num.charAt(i);
        int value = c - '0';
        if (value < cards.get(0)) {
          num = num.replace(c, cards.get(0).toString().charAt(0));
          cards.remove(0);
        }
      }
    }
    
    System.out.println(num.toString());
    
  }
}
