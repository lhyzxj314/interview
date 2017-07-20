package dynamic_programming;

import java.util.Scanner;

/**
 * 爱奇艺原题：
 * 0-1背包问题(未解决：原因超时)
 * @author xshrimp
 * 2017年5月20日
 */
public class Main {
	
	public static void main(String[] args) {
	  /* ** 处理输入 ***/
		Scanner sc = new Scanner(System.in);
		String firstLine = sc.nextLine();
		sc.close();
		String[] strArr = firstLine.split(" ");
		int[] arr = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++)
		  arr[i] = Integer.parseInt(strArr[i]);
		
		int weaponNum = (strArr.length - 1) / 2; // 节目总数
		int maxValue = arr[0];                   // 预算B
		int[] weight = new int[weaponNum + 1];   // 收视率
		int[] price  = new int[weaponNum + 1];   // 价格
		for (int i = 1,j = 1; i < strArr.length; i+=2) {
		  price[j]  = arr[i];
		  weight[j] = arr[i+1];
		  j++;
		}
		/*
		 * cost[i][j]表示:
		 * 在节目数为i，价格上限为j的条件下能够获得的最大收视率
		 */
		int[][] cost = new int[weaponNum + 1][maxValue + 1];
		
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
