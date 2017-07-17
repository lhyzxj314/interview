package knapsack_problem;

/**
 * 算法导论动态规划示例：钢条切割问题
 * 
 * @author xiaojun
 * @version 1.0.0
 * @date 2017年7月17日
 */
public class CutRod {
	/**
	 * 动态规划实现方式一： 自底向上法
	 * 
	 * @author xiaojun
	 * @version 1.0.0
	 * @param price
	 * @param n
	 * @return
	 * @date 2017年7月17日
	 */
	public static int cutRodIterable(int[] price, int n) {
		if (price == null || price.length == 0)
			throw new IllegalArgumentException();

		// 动态规划表格
		int[] table = new int[n + 1];

		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j <= i; j++) {
				int temp = price[j] + table[i - j];
				if (temp > table[i])
					table[i] = temp;
			}
		}
		return table[n];
	}

	/**
	 * 动态规划实现方式二：带备忘的自顶向下法
	 * 
	 * @author xiaojun
	 * @version 1.0.0
	 * @param price
	 * @param n
	 * @return
	 * @date 2017年7月17日
	 */
	private static int cutRodRecursive(int[] price, int n) {
		if (price == null || price.length == 0)
			throw new IllegalArgumentException();
		// 动归表格
		int[] table = new int[n + 1];
		return cutRodRecursiveAux(price, n, table);
	}

	private static int cutRodRecursiveAux(int[] price, int n, int[] table) {
		if (table[n] > 0)
			return table[n];

		if (n == 0)
			return 0;
		else {
			int temp = Integer.MIN_VALUE;
			for (int i = 1; i <= n; i++)
				temp = Math.max(temp, price[i] + cutRodRecursive(price, n - i));
			table[n] = temp;
		}
		return table[n];
	}

	public static void main(String[] args) {
		int[] price = new int[] { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
		System.out.println("cutRodRecursive(price, 4)结果：" + cutRodRecursive(price, 4));
		System.out.println("cutRodIterable(price, 4)结果：" + cutRodIterable(price, 4));
	}
}
