package two_dimension_array;

import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args) {
	  /* ** 处理输入 ***/
		Scanner sc = new Scanner(System.in);
		String firstLine = sc.nextLine();
		String secondLine = sc.nextLine();
		sc.close();
		int k = Integer.parseInt(firstLine);
		String[] strArr = secondLine.split(" ");
		int[] lens = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++)
		  lens[i] = Integer.parseInt(strArr[i]);
		
		// 最小原木长度
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < lens.length; i++)
		  if (max < lens[i])
		    max = lens[i];
		
		int count = 0; // 小段木头数量
		int len = max; // 小段木头最大长度
		while (len > 0) {
		  for (int i = 0; i < lens.length; i++) {
		    count += lens[i] / len;
		    if (count >= k) {
		      System.out.println(len);
		      return;
		    }
		  }
		  count = 0;
		  len--;
		}
		System.out.println(len);
	}
	
}
