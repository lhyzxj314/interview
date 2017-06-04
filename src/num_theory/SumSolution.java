package num_theory;

/**
 * 求1+2+3+...+n：
 * 
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author xshrimp 2017年6月4日
 */
public class SumSolution {
  public int Sum_Solution1(int n) {
    int result = 0;

    @SuppressWarnings("unused")
    boolean flag = (n > 1) && (1 == (result = Sum_Solution1(n - 1)));
    result += n;
    return result;
  }

  public int Sum_Solution2(int n) {
    int sum = n;
    @SuppressWarnings("unused")
    boolean flag = (n > 0) && (1 == (sum += Sum_Solution2(n - 1)));
    return sum;
  }

  public static void main(String[] args) {
    SumSolution obj = new SumSolution();
    int res = obj.Sum_Solution2(3);
    System.out.println(res);
  }
}
