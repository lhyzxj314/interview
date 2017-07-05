package temp;

import java.util.Scanner;

public class Test1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		int minInterval = Integer.MAX_VALUE;
		for (int i = 1; i < n; ++i) {
			int tempInterval = 0;
			for (int j = 0 ; j < n - 1; ++j) {
				if (i == j) continue; 
				else if (j + 1 == i && j != n-2) {
					if (arr[j + 2] - arr[j] > tempInterval) {
						tempInterval = arr[j + 2] - arr[j];
					}
				}
				else if (arr[j + 1] - arr[j] > tempInterval) {
					tempInterval = arr[j + 1] - arr[j];
				}
				
			}
			if (minInterval > tempInterval) {
				minInterval = tempInterval;
			}
		}
		System.out.println(minInterval);
	}
	
	public void test() {
	  
	}

}
