package tree;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedian {
  private static PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();;
  private static PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(11,
      new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          return o2.compareTo(o1);
        }
      });

  public void insert(Integer num) {
    if (num == null)
      return;
    
    int maxSize = maxQ.size();
    int minSize = minQ.size();
    
    if (maxSize == minSize) {
      if (maxSize == 0)
        minQ.add(num);
      else {
        if (maxQ.peek() <= num)
          minQ.add(num);
        else {
          minQ.add(maxQ.remove());
          maxQ.add(num);
        }
      }
    } else if (maxSize < minSize) {
      if (minQ.peek() <= num) {
        maxQ.add(minQ.remove());
        minQ.add(num);
      } else {
        maxQ.add(num);
      }
    } else if (maxSize > minSize) {
      if (maxQ.peek() <= num)
        minQ.add(num);
      else {
        minQ.add(maxQ.remove());
        maxQ.add(num);
      }
    }
  }

  public Double getMedian() {
    int maxSize = maxQ.size();
    int minSize = minQ.size();
    int allSize = maxSize + minSize;

    double res = 0.0d;
    if (allSize % 2 == 0)
      res = ((double) (maxQ.peek() + minQ.peek())) / 2.0d;
    else
      res = minQ.peek();

    return res;
  }
}
