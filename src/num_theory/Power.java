package num_theory;

/**
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author xshrimp
 * 2017年5月28日
 */
public class Power {
  /**
   * 常规算法，时间复杂度O(exponent)
   * @param base
   * @param exponent
   * @return
   */
  public double power1(double base, int exponent) {
    int n = 0;
    if (exponent > 0)
      n = exponent;
    else if (exponent == 0)
      return 1.0;
    else if (exponent < 0) {
      if (base == 0)
        throw new IllegalArgumentException("分母不能为0");
      n = -exponent;
    }
    
    double res = 1.0;
    for (int i = 0; i < n; i++)
      res = base * res;

    return exponent < 0 ? 1.0 / res : res;
  }
  
  /**
   * 快速幂算法,时间复杂度O(log2 exponent)
   * @param base
   * @param exponent
   * @return
   */
  public double power2(double base, int exponent) {
    int n = 0;
    if (exponent > 0)
      n = exponent;
    else if (exponent == 0)
      return 1.0;
    else if (exponent < 0) {
      if (base == 0)
        throw new IllegalArgumentException("分母不能为0");
      n = -exponent;
    }
    
    double res = 1.0;
    double temp = base;
    while (n != 0) {
      if ((n&1) == 1)
        res = res * temp;
      temp = temp * temp;
      n = n >> 1; // 相当于n = n mod 2;
    }
    
    return exponent < 0 ? 1.0 / res : res;
  }
  
  public static void main(String[] args) {
    Power obj = new Power();
    double res = obj.power1(2, 1000000);
    System.out.println(res);
    double res1 = obj.power2(2, 1000000);
    System.out.println(res1);
  }
}
