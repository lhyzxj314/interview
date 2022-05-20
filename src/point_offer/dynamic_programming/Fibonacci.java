package point_offer.dynamic_programming;

import tree.IsSymmetrical;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {


    /**
     * 暴力递归
     * 时间复杂度: O(n^2)
      */
    public int fibonacci1(int n) {
        if (n < 1)
            throw new RuntimeException("n小于1");

        if (n == 1 || n == 2)
            return 1;
        else {
            int res = fibonacci1(n - 1) + fibonacci1(n - 2);
            return res;
        }
    }

    /**
     * 用递归，但使用数组记录中间计算结果，避免重复计算
     * 时间复杂度: O(n)
     */
    private int[] fab = new int[50];

    public int fibonacci2(int n) {
        if (n < 1)
            throw new RuntimeException("n小于1");


        if (fab[n] != 0)
            return fab[n];

        if (n == 1 || n == 2)
            return 1;
        else if (n > 2) {
            int res = fibonacci2(n - 1) + fibonacci2(n - 2);
            fab[n] = res;
            return res;
        }
        return 0;
    }

    // 迭代计算(动态规划？)
    public int fibonacci3(int n) {
        if (n < 1)
            throw new RuntimeException("n小于1");

        if (n == 1 || n == 2)
            return 1;
        else {
            int pre1 = 1;
            int pre2 = 1;
            int fab = 0;
            for (int i = 3; i <= n; i++) {
                fab = pre1 + pre2;
                pre1 = pre2;
                pre2 = fab;
            }
            return pre2;
        }

    }

    public static void main(String[] args) {
        Fibonacci fab = new Fibonacci();
        System.out.println(fab.fibonacci1(40));
        System.out.println(fab.fibonacci2(40));
        System.out.println(fab.fibonacci3(40));
    }

}
