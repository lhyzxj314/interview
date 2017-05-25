package fibonacci_seq;

import java.util.HashMap;
import java.util.Map;

/**
 * 矩形覆盖问题
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author xshrimp
 * 2017年5月25日
 */
public class RectCover {
  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
  
  /** 用迭代方法计算斐波拉契数列 */
  public int RectCover1(int n) {
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
    
    int count = RectCover2(n - 1) + RectCover2(n - 2);
    return count;
  }
  
  /** 递归实现 */
  public int RectCover3(int target) {
    if (target <= 2)  // 递归终止条件
      return target;
    
    int res = 0;
    if (map.get(target) != null) {             // 散列表未存有计算结果，递归计算并存入散列表
      res = RectCover3(target - 1) + RectCover3(target - 2);
      map.put(target, res);                         
    } else {                              // 散列表存有计算结果，从散列表中取出
      res = map.get(target);
    }
    return res;
  }

  public int RectCover4(int target) {
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
  
  // 组合数算法
  private int comb(int m, int n) {
    n = n < (m - n) ? n : (m - n);
    int res = 1;
    for (int i = 1; i <= n; i++)
      res = res * m-- / i; // 这个用到了组合数的性质c(8,4)=8/1*7/2*6/3*5/4=c(8,3)*5/4
    return res;
  }
  
  public static void main(String[] args) {
	  
  }

}
