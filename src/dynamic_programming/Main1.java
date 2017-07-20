package dynamic_programming;

import java.util.Scanner;

public class Main1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int maxValue = 0;
		int weaponNum = 0;
		/*
		 * cost[i][j]表示:
		 * 在武器数为i，价格上限为j的条件下能够获得的最大攻击力
		 */
		int[][] cost = null;
		int[] weight = null;           // 攻击力
		int[] price = null;            // 价格
		
		weaponNum = sc.nextInt();   // 武器种类数
		maxValue  = sc.nextInt();   // 价格上限
		cost = new int[weaponNum + 1][maxValue + 1];
		price = new int[weaponNum + 1];
		weight = new int[weaponNum + 1];
		for (int i = 1; i <= weaponNum; i++) {
			weight[i] = sc.nextInt();
			price[i] = sc.nextInt();
		}
		sc.close();
		
		
		for (int i = 1; i <= weaponNum; i++) {
			for (int j = 1; j <= maxValue; j++) {
				if (price[i] <= j) {
					int priceA = cost[i - 1][j];
					int priceB = cost[i - 1][j - price[i]] + weight[i];
					cost[i][j] = Math.max(priceA, priceB);
				} else
					cost[i][j] = cost[i - 1][j];
			}
		}
		
		System.out.println(cost[weaponNum][maxValue]);
	}
	
}
