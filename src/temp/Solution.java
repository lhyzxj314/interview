package temp;

import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
  
  public int GetUglyNumber_Solution(int index) {
    if (index <= 0) return 0;
    if (index == 1) return 1;
    
    LinkedList<Integer> uglyNums = new LinkedList<Integer>();
    uglyNums.add(1);
    
    while (index > uglyNums.size()) {
      
      int numA = 0;
      int numB = 0;
      int numC = 0;
      int lastNum = uglyNums.getLast();
      
      Iterator<Integer> it = uglyNums.iterator();
      while (it.hasNext()) {
        int nextNum = it.next();
        if (nextNum * 5 > lastNum) {
          numC = nextNum * 5;
          break;
        }
      }
      
      it = uglyNums.iterator();
      while (it.hasNext()) {
        int nextNum = it.next();
        if (nextNum * 3 > lastNum) {
          numB = nextNum * 3;
          break;
        }
      }
      
      it = uglyNums.iterator();
      while (it.hasNext()) {
        int nextNum = it.next();
        if (nextNum * 2 > lastNum) {
          numA = nextNum * 2;
          break;
        }
      }
      
      int uglyNum = Math.min(Math.min(numA, numB), numC);
      uglyNums.add(uglyNum);
    }
    
    return uglyNums.getLast();
  }
  
  public int GetUglyNumber_Solution1(int index) {
    if (index <= 5)
      return index;

    int uglyNum = 5;
    int nextNum = uglyNum;
    int count = 5;
    while (index > count) {

      nextNum++;
      if (isUgly(nextNum)) {
        uglyNum = nextNum;
        count++;
      }
    }
    return uglyNum;
  }
  
  private boolean isUgly(int num) {
    if (num < 1) return false;
    while (num % 2 == 0) num/=2;
    while (num % 3 == 0) num/=3;
    while (num % 5 == 0) num/=5;
    
    if (num == 1) return true;
    else          return false;
  }
  
  public static void main(String[] args) {
    int res = new Solution().GetUglyNumber_Solution(1600);
    System.out.println(res);
  }
}
