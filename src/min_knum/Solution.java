package min_knum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
  public static void main(String[] args) {

  }

  public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    if (k > input.length || k == 0)
      return list;

    // 自定义比较器
    Comparator<Integer> cpt = new Comparator<Integer>() {

      @Override
      public int compare(Integer n1, Integer n2) {
        if (n1 == n2 || n1.equals(n2))
          return 0;
        if (n1 < n2)
          return 1;
        if (n1 > n2)
          return -1;
        return 0;
      }
    };

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, cpt); // 最大堆
    for (int i = 0; i < input.length; i++) {
      if (pq.size() < k)
        pq.add(input[i]);
      else {
        if (pq.peek() > input[i]) {
          pq.remove();
          pq.add(input[i]);
        }

      }
    }

    // 将最大堆中所有元素移入list
    while (!pq.isEmpty()) {
      list.add(pq.remove());
    }
    return list;
  }

}
