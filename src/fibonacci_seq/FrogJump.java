package fibonacci_seq;

import java.util.*;

/**
 * 青蛙跳台阶(可抽象成求斐波那契数列)
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author xshrimp
 * 2017年5月25日
 */
public class FrogJump {
  private Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
  
  // 递归法计算斐波那契数列
  public int JumpFloor(int target) {
    if (target == 1 || target == 0)
      return 1;

    int res = 0;
    if (cache.get(target) == null) {
      res = JumpFloor(target - 1) + JumpFloor(target - 2);
      cache.put(target, res);
    } else
      res = cache.get(target);

    return res;
  }
  
  // 迭代法计算斐波那契数列
  public int JumpFloor1(int target) {
    if (target < 0)
      return 0;
    if (target == 1 || target == 0)
      return 1;
    
    int num1 = 1;
    int num2 = 1;
    int res = 0;
    for (int i = 2; i <= target; i++) {
      res = num1 + num2;
      num1 = num2;
      num2 = res;
    }
    return res;
  }
  
  // 转换成排列组合问题
  public int JumpFloor2(int target) {
    if (target < 0)
      return 0;
    
    int oneCount = target;
    int twoCount = 0;
    int res = 0;
    while (oneCount >= 0) {
      int slotCount = oneCount + twoCount;
      res += comb(slotCount, twoCount);
      oneCount = oneCount - 2;
      twoCount++;
    }
    return res;
  }
  
  private int comb(int n, int m) {
    if (m == 0)
      return 1;
    
    m = m<(n-m) ? m : n-m;
    int res = 1;
    for (int i = 1; i <= m; i++)
      res = res * n-- / i;
    
    return res;
  }
  
  public static void main(String[] args) {
    FrogJump obj = new FrogJump();
    int res = obj.JumpFloor(30);
    System.out.println(res);
    int res1 = obj.JumpFloor1(30);
    System.out.println(res1);
    int res2 = obj.JumpFloor2(30);
    System.out.println(res2);
  }
}
