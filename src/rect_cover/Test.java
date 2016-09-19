package rect_cover;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Test {
  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
  
  public static void main(String[] args) {
    Test t = new Test();
    new PriorityQueue<Integer>();
  }
  
  public Test() {
  }

  public boolean isContinuous(int[] numbers) {
    if (numbers.length == 0)
      return false;

    Arrays.sort(numbers);
    int offset = 0;
    int zeroCount = 0;
    for (int i = 0; i < numbers.length - 1; i++) {
      if (numbers[i] == 0)
        zeroCount++;
      else if (numbers[i + 1] == numbers[i])
        return false;
      else if (numbers[i + 1] - numbers[i] > 1) {
        offset += (numbers[i + 1] - numbers[i] - 1);
      }
    }

    return (zeroCount >= offset);
  }

  public boolean isContinuous1(int[] numbers) {
    if (numbers.length == 0)
      return false; // 长度为0，不是顺子
    
    Map<Integer, Boolean> st = new HashMap<Integer, Boolean>(); // 散列表
    int zeroCount = 0;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == 0)
        zeroCount++; // 大小王个数
      else if (st.containsKey(numbers[i]))
        return false; // 存在重复点数,不是顺子
      else {
        st.put(numbers[i], true);
        /* 获取最大点数、最小点数 */
        if (max < numbers[i])
          max = numbers[i];
        if (min > numbers[i])
          min = numbers[i];
      }
    }

    int len = st.keySet().size();
    int offset = max - min + 1;
    /* 下判断 */
    if (len == offset)
      return true;
    else if (len < offset) {
      int blankNum = offset - len;
      return zeroCount >= blankNum;
    }

    return false;
  }
  /** 用迭代方法计算斐波拉契数列 */
  public int RectCover(int n) {
    if (n <= 2) 
      return n;
    
    int index = 3;    // 从第3项开始需要递推计算F(n)
    int value1 = 1;   // F(n - 2)
    int value2 = 2;   // F(n - 1)
    do {
      int tmp = value2;
      value2 = value1 + value2;   // 计算F(n) = F(n - 2) + F(n - 1)
      value1 = tmp;
      index++;
    }
    while (index <= n); 
    
    return value2; 
  }
  
  /** 递归实现 */
  public int RectCover2(int n) {
    if (n <= 2)  // 递归终止条件
      return n;
    
    int count = RectCover(n - 1) + RectCover(n - 2);
    return count;
  }
  
  /** 递归实现 */
  public int RectCover3(int target) {
    if (target <= 2)  // 递归终止条件
      return target;
    
    int res = 0;
    if (map.get(target) != null) {             // 散列表未存有计算结果，递归计算并存入散列表
      res = RectCover(target - 1) + RectCover(target - 2);
      map.put(target, res);                         
    } else {                              // 散列表存有计算结果，从散列表中取出
      res = map.get(target);
    }
    return res;
  }

  public int RectCover1(int target) {
    if (target <= 0)
      return 0; // 排除特殊情况
    int n1 = target / 2; // 最多可以有组合块n1个
    int n2 = target % 2; // 最少可以有非组合块n2个
    int result = 0;
    for (int i = n1; i >= 0; i--) { // 逐个减少组合块
      int sum = i + n2 + (n1 - i) * 2; // 块总数
      // result += (permulation(sum) / (permulation(i) * permulation(n2 + (n1 - i) * 2)));
      result += comb(sum, i);
    }
    
    return result;
  }
  

  private int comb(int m, int n) {
    n = n < (m - n) ? n : (m - n);
    int res = 1;
    for (int i = 1; i <= n; i++)
      res = res * m-- / i; // 这个用到了组合数的性质c(8,4)=8/1*7/2*6/3*5/4=c(8,3)*5/4
    return res;
  }

}
