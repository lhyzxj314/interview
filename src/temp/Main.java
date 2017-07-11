package temp;

import java.util.Scanner;

public class Main {
	private static final int WEIGHT = 1;
	private static final int VALUE = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int[][] wv = new int[n][2];
			for (int i = 0; i < n; i++) {
				wv[i][WEIGHT] = scan.nextInt();
				wv[i][VALUE] = scan.nextInt();
			}
			System.out.println(calculate(wv, n - 1, m));
		}
		
		scan.close();
	}

	private static final int calculate(int[][] wv, int cur, int sum) {
		if (cur == 0)
			return wv[cur][WEIGHT] <= sum ? wv[cur][VALUE] : 0;
		if (wv[cur][WEIGHT] > sum)
			return calculate(wv, cur - 1, sum);
		else {
			int notChooseRes = calculate(wv, cur - 1, sum);
			int chooseRes = calculate(wv, cur - 1, sum - wv[cur][WEIGHT]) + wv[cur][VALUE];
			return Math.max(notChooseRes, chooseRes);
		}
	}
	
	/*public static <? extends T> void add(T obj) {
		
	}*/
}
